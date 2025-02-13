package _facade;

import _common.util.ClipboardUtil;
import consumer.ConsumerSQLService;
import friend.FriendSQLService;

public class WriteFacade {

    public void writeConsoleAndClipBoard() {

        StringBuilder sb = new StringBuilder();

        sb.append(ConsumerSQLService.makeConsumerInsertSQL(500, 1500));

        sb.append(FriendSQLService.makeMutualFriendInsertSQL(29L, 500, 1500));

        ClipboardUtil.copyToClipboard(sb.toString());

        System.out.println(sb.toString());
        System.out.println("클립보드에 복사되었습니다.");
    }
}
