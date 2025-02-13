package funding;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Funding {

    private Integer sumPrice;
    private Integer minPrice;
    private Integer targetPrice;
    private LocalDate anniversaryDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String content;
    private String accountBank;
    private String accountNo;
    private String name;
    private String phoneNumber;
    private String defaultAddr;
    private String detailAddr;
    private String zipCode;
    private String fundingStatus;
    private Boolean isPrivate;
    private Integer anniversaryCategoryId;
    private Long consumerId;
    private Long productId;
    private Long productOptionId;
    private String createdAt; //created_at
    private String updatedAt; //updated_at
    private String deletedAt; //deleted_at

    public static String getTable() {
        return "funding";
    }

    public static String getColumns() {
        return "(\n" +
                "    sum_price, min_price, target_price, \n" +
                "    anniversary_date, start_date, end_date, title, \n" +
                "    content, account_bank, account_no, name, \n" +
                "    phone_number, default_addr, detail_addr, zip_code, \n" +
                "    funding_status, is_private, anniversary_category_id, consumer_id, product_id, \n" +
                "    product_option_id, created_at, updated_at, deleted_at\n" +
                ")";
    }

    public String getValues() {
        StringBuilder sb = new StringBuilder();

        sb.append("(")
                .append(sumPrice).append(", ")
                .append(minPrice).append(", ")
                .append(targetPrice).append(", ")
                .append("'").append(anniversaryDate).append("' , ")
                .append("'").append(startDate).append("' , ")
                .append("'").append(endDate).append("' , ")
                .append("'").append(title).append("' , ")
                .append("'").append(content).append("' , ")
                .append("'").append(accountBank).append("' , ")
                .append("'").append(accountNo).append("' , ")
                .append("'").append(name).append("' , ")
                .append("'").append(phoneNumber).append("' , ")
                .append("'").append(defaultAddr).append("' , ")
                .append("'").append(detailAddr).append("' , ")
                .append("'").append(zipCode).append("' , ")
                .append("'").append(fundingStatus).append("' , ")
                .append(isPrivate? "b'1'" : "b'0'").append(", ")
                .append(anniversaryCategoryId).append(", ")
                .append(consumerId).append(", ")
                .append(productId).append(", ")
                .append(productOptionId).append(", ")
                .append(createdAt).append(", ")
                .append(updatedAt).append(", ")
                .append(deletedAt)
                .append(")");

        return sb.toString();
    }

}
