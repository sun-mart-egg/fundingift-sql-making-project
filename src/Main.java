import consumer.ConsumerSQLService;
import facade.WriteFacade;
import friend.FriendSQLService;

public class Main {
    public static void main(String[] args) {

        new WriteFacade().writeConsoleAndClipBoard();
    }
}