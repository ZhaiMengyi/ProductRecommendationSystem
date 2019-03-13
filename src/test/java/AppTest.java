import com.zmy.entity.Product;
import com.zmy.entity.ShoppingCart;
import com.zmy.mapper.ProductMapper;
import com.zmy.mapper.ShoppingCartMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AppTest {
    @Test
    public void test(){
        try {
            SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            Product product = productMapper.inquireProductById(1);
            System.out.println(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddCart() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShoppingCartMapper mapper = sqlSession.getMapper(ShoppingCartMapper.class);
        Integer res = mapper.addProToCarts(new ShoppingCart(1,1,1));
        System.out.println(res);
    }

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取SqlSessionFactory对象
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}
