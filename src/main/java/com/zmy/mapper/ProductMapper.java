package com.zmy.mapper;

import com.zmy.entity.Product;
import org.apache.ibatis.annotations.Param;

/**
 * 映射
 * mapper层 = DAO层
 * 对数据库进行数据持久化操作，他的方法语句是直接针对数据库操作的，主要实现一些增删改查操作
 * 在mybatis中方法主要与mapper.xml内相互一一映射，具体方法实现在mapper.xml文件里
 */
public interface ProductMapper {
    Integer addProduct(@Param(value = "product") Product product);

    Product inquireProductById(Integer proId);

    Integer modifyProInfo(@Param(value = "product") Product product);

    Integer deleteProduct(Integer proId);
}
