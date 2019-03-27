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
 * 订单功能测试类
 *
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class OrderControllerTest {

    private MockMvc mockMvc;

    @Resource
    private UserOrderController userOrderController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(userOrderController).build();
    }

    /**
     * 测试创建订单
     */
    @Test
    public void testCreateOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/userOrder/createOrder")
                        .sessionAttr("userId",1)
                        .param("proId","2")
                        .param("ordAddress","四川省成都市高新西区百叶路一号"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }

    /**
     * 测试支付订单（修改订单状态）
     */
    @Test
    public void testPayOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/userOrder/payOrder")
                        .sessionAttr("userId",1)
                        .param("ordId","2"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }

    /**
     * 测试取消订单（修改订单状态）
     */
    @Test
    public void cancelOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/userOrder/cancelOrder")
                        .sessionAttr("userId",1)
                        .param("ordId","1"))
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
