package _facade;

import _common.util.ClipboardUtil;
import consumer.ConsumerSQLService;
import friend.FriendSQLService;
import funding.FundingSQLService;

public class WriteFacade {

    public void writeConsoleAndClipBoard() {

        StringBuilder sb = new StringBuilder();

//        sb.append(ConsumerSQLService.makeConsumerInsertSQL(2000, 3000));

        sb.append(FriendSQLService.makeMutualFriendInsertSQL(5L, 2000, 2300));

//        sb.append(FundingSQLService.makeFundingInsertSQL(5, 2000, 3000));

        ClipboardUtil.copyToClipboard(sb.toString());

        System.out.println(sb.toString());
        System.out.println("클립보드에 복사되었습니다.");
    }
}
