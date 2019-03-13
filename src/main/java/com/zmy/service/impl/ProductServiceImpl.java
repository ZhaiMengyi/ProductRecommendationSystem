package com.zmy.service.impl;

import com.zmy.entity.Product;
import com.zmy.mapper.ProductMapper;
import com.zmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * impl实现类
 * 把mapper和service进行整合的文件
 * 在接口的实现方法中需要导入mapper层
 */
//@Service用于标注业务层组件
@Service
//当类中方法抛出异常时，事务就会回滚，数据库里面的数据也会回滚。
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    //@Autowired注释使得接口可以被容器注入
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Integer addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public Product inquireProductById(Integer proId) {
        return productMapper.inquireProductById(proId);
    }

    @Override
    public Integer modifyProInfo(Product product) {
        return productMapper.modifyProInfo(product);
    }

    @Override
    public Integer deleteProduct(Integer proId) {
        return productMapper.deleteProduct(proId);
    }
}
