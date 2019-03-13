package com.zmy.service.impl;


import com.zmy.entity.ProductScore;
import com.zmy.mapper.ProductScoreMapper;
import com.zmy.service.ProductScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductScoreServiceImpl implements ProductScoreService {
    @Autowired
    private ProductScoreMapper scoreMapper;
    @Override
    public Integer rateProduct(ProductScore productScore) {
        return scoreMapper.rateProduct(productScore);
    }
}
