import com.zmy.controller.ProductController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * 商品功能测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class ProductControllerTest {

    protected Log logger= LogFactory.getLog(ProductControllerTest.class);

    private MockMvc mockMvc;

    @Resource
    private ProductController productController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }


    @Test
    public void testQueryProduct() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        //请求的url
                        .get("/product/inquireProductById")
                        .param("proId","2"))
                //返回的状态是200
                .andExpect(status().isOk())
                //打印出请求和相应的内容
                .andDo(print())
                .andReturn()
                .getResponse()
                //将相应的数据转换为字符串
                .getContentAsString();
        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }

    /**
     * 测试增加商品
     * @throws Exception 异常信息
     */
    @Test
    public void testAddProduct() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                .get("/product/addProduct")
                .param("proName","Laptop")
                .param("proPrice","8999")
                .param("proInventory","999")
                .param("merId","1")
        )
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
     * 测试修改商品信息
     * @throws Exception 异常信息
     */
    @Test
    public void testModifyProduct() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        //请求的url
                        .get("/product/modifyProInfo")
                        .param("proId","3")
                        .param("proName","PC")
                        .param("proPrice","8999")
                        .param("proInventory","999")
                        .sessionAttr("merId",1)
        )
                //返回的状态是200
                .andExpect(status().isOk())
                //将相应的数据转换为字符串
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }

    /**
     * 测试删除商品
     * @throws Exception 异常信息
     */
    @Test
    public void testDeleteProduct() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders
                        //请求的url
                        .delete("/product/deleteProduct")
                        .sessionAttr("merId",1)
                        .param("proId","3")
                        .param("merId","1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("========");
        System.out.println("返回结果：" + result);
        System.out.println("========");
    }
}
