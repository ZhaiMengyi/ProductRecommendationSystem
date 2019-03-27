package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.Product;
import com.zmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 控制层
 * controller层 = web层
 * 主要负责具体业务模块流程的控制，需要调用service逻辑设计层的接口来控制业务流程
 * 因为service中的方法是我们使用到的，controller通过接收前端传过来的参数进行业务操作，在返回一个指定的路径或者数据表
 * @author zmy
 */
//@Controller用于标注控制层组件
//处理请求地址映射，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径

@RequestMapping("/product")
@Controller
public class ProductController {
    //属性加上@Autowired后不需要getter()和setter()方法，Spring也会自动注入。
    //@Autowired注释使得接口可以被容器注入

    @Resource
    private HttpServletRequest request;

    @Resource
    private ProductService productService;

    /**
     * 查询商品信息
     *
     * @param proId
     * @return
     */
    //@ResponseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后
    //写入到response对象的body区，通常用来返回JSON数据或者是XML数据
    //@RequestParam用于将指定的请求参数赋值给方法中的形参

    @RequestMapping(value = "inquireProductById", method = RequestMethod.GET)
    @ResponseBody
    public Message inquireProductById(@RequestParam(value = "proId") Integer proId) {
        return Message.success().addObject("product", productService.inquireProductById(proId));
    }

    /**
     * 添加商品
     *
     * @param proName
     * @param proPrice
     * @param proInventory
     * @param merId
     * @return
     */
    @RequestMapping(value = "addProduct")
    @ResponseBody
    public Message addProduct(@RequestParam(value = "proName") String proName,
                              @RequestParam(value = "proPrice") Double proPrice,
                              @RequestParam(value = "proInventory") Integer proInventory,
                              @RequestParam(value = "merId") Integer merId) {
        Integer res = productService.addProduct(new Product(proName, proPrice, proInventory, merId));
        if (res > 0){
            return Message.success("添加成功");
        }
        return Message.error("添加失败");
    }

    /**
     * 修改商品信息
     *
     * @param proName
     * @param proPrice
     * @param proInventory
     * @return
     */
    @RequestMapping(value = "modifyProInfo")
    @ResponseBody
    public Message inquireProInfo(@RequestParam(value = "proId") Integer proId,
                                  @RequestParam(value = "proName") String proName,
                                  @RequestParam(value = "proPrice") Double proPrice,
                                  @RequestParam(value = "proInventory") Integer proInventory) {

        Integer merId = (Integer) request.getSession().getAttribute("merId");
        Integer res = productService.modifyProInfo(new Product(proId, proName, proPrice, proInventory, merId));
        if (res > 0){
            return Message.success("修改成功");
        }
        return Message.error("修改失败");

    }

    @RequestMapping(value = "deleteProduct",method = RequestMethod.DELETE)
    @ResponseBody
    public Message deleteProduct(@RequestParam(value = "proId") Integer proId) {
        Integer res = 0;
        Integer merId = productService.inquireProductById(proId).getMerId();
        final String key = "merId";
        if (merId == request.getSession().getAttribute(key)){
            res = productService.deleteProduct(proId);
        }
        if (res > 0){
            return Message.success("删除成功");
        }
        return Message.error("删除失败");
    }
}
