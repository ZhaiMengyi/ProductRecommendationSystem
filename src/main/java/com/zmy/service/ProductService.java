package com.zmy.service;

import com.zmy.entity.Product;

import java.util.List;


/**
 * 业务接口
 * service层
 * 存放业务逻辑处理
 * 给controller层的类提供接口进行调用。一般就是自己写的方法封装起来，就是声明一下，具体实现在serviceImpl中
 */
public interface ProductService {
    /**
     * 添加商品
     *
     * @param product 添加的商品信息
     * @return 影响行数
     */
    Integer addProduct(Product product);

    /**
     * 通过商品Id查询商品
     *
     * @param proId 商品Id号
     * @return 商品信息
     */
    Product inquireProductById(Integer proId);

    /**
     * 获取全部商品
     * @return
     */
    List<Product> getAllProduct();

    /**
     * 获取推荐商品
     * @param userId
     * @return
     */
    List<Product> getRecommended(Integer userId);
    /**
     * 修改商品信息
     *
     * @param product 修改后的商品信息
     * @return 影响行数
     */
    Integer modifyProInfo(Product product);

    /**
     * 删除商品
     *
     * @param proId 商品Id号
     * @return 影响行数
     */
    Integer deleteProduct(Integer proId);
}
