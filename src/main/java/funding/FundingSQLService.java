package funding;

import _common.sql.InsertSQL;
import product.Product;
import product.ProductService;

import java.time.LocalDate;
import java.util.List;

import static _common.util.RandomUtil.*;
import static _common.util.RandomUtil.generateRandomNumberInRange;

public class FundingSQLService {

    private static final String[] texts = {"필요해요.", "많은 참여 부탁!", "축하해주세요.", "필요함.", "Wanted", "갖고 싶다... 격하게", "다같이 축하 플리즈~", "미리 감사합니다^^", "미리 고마워!", "thank so much"};
    private static final String[] banks = {"농협", "신한", "경남", "대구", "IBK"};
    private static final String[] defaultAddrs = {"서울", "대구", "마산", "강릉", "동해"};


    /**
     * @param cnt : 한 사용자당 만들 펀딩 개수
     * @param startNumber : 펀딩 만들 사용자 시작 id
     * @param endNumber : 펀딩 만들 사용자 마지막 id
     */
    public static String makeFundingInsertSQL(int cnt, int startNumber, int endNumber) {

        StringBuilder result = new StringBuilder("-- funding 더미 데이터 생성, 인당 " + cnt +
                "개의 펀딩 생성, 사용자id " + startNumber + " ~ " + endNumber + "까지 펀딩 생성\n");
        result.append("-- 더미데이터 생성 날짜가 펀딩 시작일\n");
        result.append("-- 더미데이터 생성 날짜 + random(0 ~ 6)가 기념일\n");
        result.append("-- 더미데이터 생성 날짜 + 6가 펀딩 종료일\n");

        InsertSQL consumerInsertSQL = new InsertSQL(Funding.getTable(), Funding.getColumns());
        LocalDate now = LocalDate.now();
        ProductService productService = new ProductService();
        List<Product> products = productService.getRandomProducts((endNumber - startNumber + 1) * cnt);
        int totalIndex = products.size();
        int index = 0;

        for(long i = startNumber; i <= endNumber; i++) {
            for(int j = 0; j < cnt; j++) {
                int random = generateRandomNumberInRange(0, 6);
                Product p = products.get(index % totalIndex);

                Funding funding = Funding.builder()
                        .id((long) 500 + index++)
                        .sumPrice(0)
                        .minPrice(generateFixedDigitRandomNumber(3))
                        .targetPrice(p.getPrice())
                        .anniversaryDate(now.plusDays(random))
                        .startDate(now)
                        .endDate(now.plusDays(6))
                        .title(texts[generateRandomNumberInRange(0, 9)])
                        .content(texts[generateRandomNumberInRange(0, 9)])
                        .accountBank(banks[generateRandomNumberInRange(0, 4)])
                        .accountNo(generateFixedDigitRandomNumber(7) + "" + generateFixedDigitRandomNumber(6))
                        .name("아무개" + i)
                        .phoneNumber("010" + generateFixedDigitRandomNumber(8))
                        .defaultAddr(defaultAddrs[generateRandomNumberInRange(0, 4)])
                        .detailAddr(null)
                        .zipCode(generateFixedDigitRandomNumber(5) + "")
                        .fundingStatus("IN_PROGRESS")
                        .isPrivate(randomBoolean())
                        .anniversaryCategoryId(generateRandomNumberInRange(1, 6))
                        .consumerId(i)
                        .productId(p.getId())
                        .productOptionId(p.getProductOptionId())
                        .createdAt("CURRENT_TIMESTAMP")
                        .updatedAt("CURRENT_TIMESTAMP")
                        .deletedAt(null)
                        .build();

                consumerInsertSQL.addValue(funding.getValues());
            }
        }

        return result.append(consumerInsertSQL.make()).toString();
    }
}
