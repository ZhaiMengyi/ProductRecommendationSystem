import com.zmy.controller.UserController;
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
 * 顾客功能测试类
 *
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Resource
    private UserController userController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    /**
     * 测试顾客注册
     */
    @Test
    public void testRegisterUser() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/user/registerUser")
                        .param("userName","asdasd")
                        .param("userPassword","asd123")
                        .param("userMobile","15988888888")
                        .param("userAddress","四川省成都市"))
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
     * 测试顾客登录，获取userId
     *
     * 登录成功后UserController方法中把userId存入session中
     */
    @Test
    public void testLoginUser() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/user/loginUser")
                        .param("userName","asdasd")
                        .param("userPassword","asd123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getRequest()
                .getSession()
                .getAttribute("userId").toString();

        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }

    /**
     * 测试顾客退出登录
     */
    @Test
    public void testLogout() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/user/logoutUser")
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

    /**
     * 测试修改顾客信息
     */
    @Test
    public void testModifyUser() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/user/modifyUserInfo")
                        .sessionAttr("userId",1)
                        .param("userName","testModify")
                        .param("userPassword","asd123")
                        .param("userMobile","15933333333")
                        .param("userAddress","四川省成都市"))
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
     * 测试删除顾客
     * 在数据库中标记，非实际删除
     */
    @Test
    public void testDeleteUser() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/user/deleteUser")
                        .sessionAttr("userId", 5))
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
