package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.Product;
import com.zmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制层
 * controller层 = web层
 * 主要负责具体业务模块流程的控制，需要调用service逻辑设计层的接口来控制业务流程
 * 因为service中的方法是我们使用到的，controller通过接收前端传过来的参数进行业务操作，在返回一个指定的路径或者数据表
 */
//@Controller用于标注控制层组件
@Controller
//处理请求地址映射，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
@RequestMapping("/product")
public class ProductController {
    //属性加上@Autowired后不需要getter()和setter()方法，Spring也会自动注入。
    //@Autowired注释使得接口可以被容器注入
    @Autowired
    private ProductService productService;

    /**
     * 查询商品信息
     * @param proId
     * @return
     */
    @RequestMapping(value = "inquireProductById")
    //@ResponseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后
    //写入到response对象的body区，通常用来返回JSON数据或者是XML数据
    @ResponseBody
    //@RequestParam用于将指定的请求参数赋值给方法中的形参
    public Message getProductById(@RequestParam(value = "proId") Integer proId){
        return Message.success().addObject("product",productService.inquireProductById(proId));
    }

    /**
     * 添加商品
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
                              @RequestParam(value = "merId") Integer merId){
        productService.addProduct(new Product(proName,proPrice,proInventory,merId));
        return Message.success("添加成功");

    }

    /**
     * 修改商品信息
     * @param proName
     * @param proPrice
     * @param proInventory
     * @param merId
     * @return
     */
    @RequestMapping(value = "modifyProInfo")
    @ResponseBody
    public Message inquireProInfo(@RequestParam(value = "proId") Integer proId,
                                  @RequestParam(value = "proName") String proName,
                                  @RequestParam(value = "proPrice") Double proPrice,
                                  @RequestParam(value = "proInventory") Integer proInventory,
                                  @RequestParam(value = "merId") Integer merId){
        productService.modifyProInfo(new Product(proName,proPrice,proInventory,merId));
        return Message.success("修改成功");

    }

    @RequestMapping(value = "deleteProduct")
    @ResponseBody
    public Message deleteProduct(@RequestParam(value = "proId") Integer proId){
        productService.deleteProduct(proId);
        return Message.success("删除成功");
    }
}
