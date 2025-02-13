package _common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.Reader;

public class MyBatisConfig {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 1. MyBatis 설정 파일 로드 (환경 정보 포함)
            String resource = "mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            throw new RuntimeException("MyBatis 초기화 실패", e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
