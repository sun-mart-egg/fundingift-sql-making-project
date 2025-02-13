package product;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private Long productOptionId;
    private Integer price;
}
