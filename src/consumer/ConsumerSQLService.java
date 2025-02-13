package consumer;

import _common.sql.InsertSQL;

import static _common.util.RandomUtil.*;

public class ConsumerSQLService {

    public static void makeConsumerInsertSQL(int startNumber, int endNumber) {
        //consumer 더미 데이터 만들기
        InsertSQL consumerInsertSQL = new InsertSQL(Consumer.getTable(), Consumer.getColumns());
        for(long i = startNumber; i <= endNumber; i++) {
            Consumer consumer = Consumer.builder()
                    .id(i)
                    .socialId(String.valueOf(i * -1))
                    .email("test" + i + "@test.com")
                    .name("아무개" + i)
                    .profileImageUrl(null)
                    .phoneNumber("010" + generateFixedDigitRandomNumber(8))
                    .birthyear(generateRandomNumberInRange(1980, 2002) + "")
                    .birthday(String.format("%02d", generateRandomNumberInRange(1, 12))
                            + String.format("%02d",generateRandomNumberInRange(1, 28)))
                    .gender(randomBoolean() ? "male" : "female")
                    .createdAt("CURRENT_TIMESTAMP")
                    .updatedAt("CURRENT_TIMESTAMP")
                    .deletedAt(null)
                    .build();

            consumerInsertSQL.addValue(consumer.getValues());
        }

        System.out.println(consumerInsertSQL.make());
    }
}
