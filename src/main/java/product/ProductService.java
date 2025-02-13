package product;

import _common.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductService {
    private final SqlSessionFactory sqlSessionFactory;

    public ProductService() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    public List<Product> getRandomProducts(int limit) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProductMapper productMapper = session.getMapper(ProductMapper.class);
            return productMapper.getRandomProducts(limit);
        }
    }
}
