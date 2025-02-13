package product;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    @Select("""
        SELECT p.product_id AS id, 
               MIN(po.product_option_id) AS product_option_id, 
               p.price
        FROM product p
        JOIN product_option po ON p.product_id = po.product_id
        WHERE p.product_id IN (
            SELECT product_id FROM product WHERE status = 'active' ORDER BY RAND() 
        )
        AND po.status = 'active'
        GROUP BY p.product_id
        LIMIT #{limit}
    """)
    List<Product> getRandomProducts(@Param("limit") int limit);
}
