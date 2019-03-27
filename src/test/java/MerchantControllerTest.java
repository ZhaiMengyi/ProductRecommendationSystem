import com.zmy.controller.MerchantController;
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
 * 商家操作测试类
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class MerchantControllerTest {

    private MockMvc mockMvc;

    @Resource
    private MerchantController merchantController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(merchantController).build();
    }

    /**
     * 测试商家注册
     * @throws Exception 异常
     */
    @Test
    public void testAddMerchant() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/merchant/registerMerchant")
                        .param("merUsername","chenrui")
                        .param("merPassword","asdasda")
                        .param("merShopName","Dell")
                        .param("merMobile","15922222222")
                        .param("merAddress","四川省德阳市"))
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
     * 测试商家登录
     * @throws Exception 异常
     */
    @Test
    public void testMerchantLogin() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/merchant/loginMerchant")
                        .param("merUsername","chenrui")
                        .param("merPassword","asdasda"))
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
     * 测试商家查询自身信息
     * @throws Exception 异常
     */
    @Test
    public void testQueryMerchantInfo() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/merchant/inquireMerInfo")
                        .sessionAttr("merId",1))
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
     * 测试顾客查询商家信息
     * 通过参数传递，获取参数中的merId
     * @throws Exception 异常
     */
    @Test
    public void inquireMerInfoFromCus() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/merchant/inquireMerInfoFromCus")
                        .param("merId","1"))
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
     * 测试修改商家信息
     * @throws Exception 异常
     */
    @Test
    public void testModifyMerchantInfo() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/merchant/modifyMerInfo")
                        .sessionAttr("merId",1)
                        .param("merUsername","m1")
                        .param("merPassword","970811")
                        .param("merShopName","Cherry")
                        .param("merMobile","15911111111")
                        .param("merAddress","四川省成都市"))
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
     * 测试商家退出登录
     * @throws Exception 异常
     */
    @Test
    public void testMerchantLogout() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/merchant/logoutMerchant")
                        .sessionAttr("merId",1))
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
     * 测试注销商铺信息
     * 仅仅在数据库中进行标记 而非实际删除
     * @throws Exception 异常
     */
    @Test
    public void testDeleteMerchant() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/merchant/deleteMerchant")
                        .sessionAttr("merId",1))
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
