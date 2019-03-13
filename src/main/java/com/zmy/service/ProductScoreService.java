package com.zmy.service;

import com.zmy.entity.ProductScore;

public interface ProductScoreService {
    /**
     * 给商品打分
     * @param productScore
     * @return 影响行数
     */
    Integer rateProduct(ProductScore productScore);
}
