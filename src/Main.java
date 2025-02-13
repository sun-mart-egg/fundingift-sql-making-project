import consumer.ConsumerSQLService;
import friend.FriendSQLService;

public class Main {
    public static void main(String[] args) {

        ConsumerSQLService.makeConsumerInsertSQL(500, 1500);

        FriendSQLService.makeMutualFriendInsertSQL(29L, 500, 1500);
    }


}