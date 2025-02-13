package friend;

import _common.sql.InsertSQL;

import static _common.util.RandomUtil.randomBoolean;

public class FriendSQLService {

    // 서로 친구 insert SQL 생성
    public static void makeMutualFriendInsertSQL(Long loginConsumerId, int startNumber, int endNumber) {

        InsertSQL friendInsertSQL = new InsertSQL(Friend.getTable(), Friend.getColumns());
        for(long i = startNumber; i <= endNumber; i++) {

            Friend friend = Friend.builder()
                    .id(i)
                    .consumerId(loginConsumerId)
                    .toConsumerId(i)
                    .isFavorite(randomBoolean())
                    .createdAt("CURRENT_TIMESTAMP")
                    .updatedAt("CURRENT_TIMESTAMP")
                    .deletedAt(null)
                    .build();

            friendInsertSQL.addValue(friend.getValues());

            friend.swapConsumerId(i + endNumber);
            friendInsertSQL.addValue(friend.getValues());
        }

        System.out.println(friendInsertSQL.make());
    }
}
