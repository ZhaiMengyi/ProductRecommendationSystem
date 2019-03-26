import com.zmy.controller.ShoppingCartController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 购物车测试类
 *
 * @author Chen Rui
 * @version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class CartControllerTest {

    private MockMvc mockMvc;

    @Resource
    private ShoppingCartController shoppingCartController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(shoppingCartController).build();
    }

    /**
     * 测试顾客添加商品到购物车
     */
    @Test
    public void testAddProToCart() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/shoppingCarts/addProToCarts")
                        .sessionAttr("userId",1)
                        .param("proId","1")
                        .param("proNum","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }

    /**
     * 查询购物车内所有商品及数量
     */
    @Test
    public void testQueryCart() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/shoppingCarts/queryCart")
                        .sessionAttr("userId",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }
}
