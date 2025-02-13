package friend;

import lombok.Builder;

@Builder
public class Friend {

    private Long consumerId; // 소비자
    private Long toConsumerId; // 소비자 친구의 소비자
    private Boolean isFavorite;
    private String createdAt; //created_at
    private String updatedAt; //updated_at
    private String deletedAt; //deleted_at

    public static String getTable() {
        return "friend";
    }

    public static String getColumns() {
        return "(consumer_id, to_consumer_id, is_favorite, created_at, updated_at, deleted_at)";
    }

    public String getValues() {
        StringBuilder sb = new StringBuilder();

        sb.append("(")
                .append(consumerId).append(", ")
                .append(toConsumerId).append(", ")
                .append(isFavorite ? "b'1'" : "b'0'").append(", ")
                .append(createdAt).append(", ")
                .append(updatedAt).append(", ")
                .append(deletedAt)
                .append(")");

        return sb.toString();
    }

    public void swapConsumerId() {
        Long temp = consumerId;
        this.consumerId = toConsumerId;
        this.toConsumerId = temp;
    }
}
