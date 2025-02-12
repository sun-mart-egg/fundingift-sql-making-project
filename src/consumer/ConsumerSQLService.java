package consumer;

import _common.sql.InsertSQL;

import java.time.LocalDateTime;

import static _common.util.NumberUtil.generateRandomNumberByDigit;
import static _common.util.NumberUtil.generateRandomNumberInRange;

public class ConsumerSQLService {

    public static void makeConsumerInsertSQL(int startNumber, int endNumber) {
        //consumer 더미 데이터 만들기
        InsertSQL consumerInsertSQL = new InsertSQL(Consumer.getTable(), Consumer.getColums());
        for(long i = startNumber; i <= endNumber; i++) {
            Consumer consumer = Consumer.builder()
                    .id(i)
                    .socialId(String.valueOf(i * -1))
                    .email("test" + i + "@test.com")
                    .name("아무개" + i)
                    .profileImageUrl(null)
                    .phoneNumber("010" + generateRandomNumberByDigit(8))
                    .birthday(generateRandomNumberInRange(1980, 2002) + "")
                    .birthday(generateRandomNumberInRange(1, 12) + "" + generateRandomNumberInRange(1, 28))
                    .gender(generateRandomNumberInRange(0, 1) == 0 ? "male" : "famale")
                    .createdAt("CURRENT_TIMESTAMP")
                    .updatedAt("CURRENT_TIMESTAMP")
                    .deletedAt(null)
                    .build();

            consumerInsertSQL.addValue(consumer.getValues());

        }

        System.out.println(consumerInsertSQL.make());
    }
}
