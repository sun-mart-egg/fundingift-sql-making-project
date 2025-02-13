package friend;

import _common.sql.InsertSQL;

import static _common.util.RandomUtil.randomBoolean;

public class FriendSQLService {

    // 서로 친구 insert SQL 생성
    public static String makeMutualFriendInsertSQL(Long loginConsumerId, int startNumber, int endNumber) {

        StringBuilder reulst = new StringBuilder("-- friend 더미 데이터 생성, " + loginConsumerId + 
                "과 id " + startNumber + " ~ " + endNumber + " 서로 친구 데이터\n");

        InsertSQL friendInsertSQL = new InsertSQL(Friend.getTable(), Friend.getColumns());
        for(long i = startNumber; i <= endNumber; i++) {

            Friend friend = Friend.builder()
                    .consumerId(loginConsumerId)
                    .toConsumerId(i)
//                    .isFavorite(randomBoolean())
                    .isFavorite(Boolean.FALSE)
                    .createdAt("CURRENT_TIMESTAMP")
                    .updatedAt("CURRENT_TIMESTAMP")
                    .deletedAt(null)
                    .build();

            friendInsertSQL.addValue(friend.getValues());

            friend.swapConsumerId();
            friendInsertSQL.addValue(friend.getValues());
        }

        return reulst.append(friendInsertSQL.make()).toString();
    }
}
