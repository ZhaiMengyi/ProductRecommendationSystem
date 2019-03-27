import com.zmy.controller.ProductScoreController;
import com.zmy.controller.UserOrderController;
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
 * 商品评价测试
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class ScoreControllerTest {

    private MockMvc mockMvc;

    @Resource
    private ProductScoreController productScoreController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(productScoreController).build();
    }



    /**
     * 测试评价商品
     */
    @Test
    public void cancelOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/productScore/rateProduct")
                        .sessionAttr("userId",1)
                        .param("proId","1")
                        .param("score","5"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }
}
