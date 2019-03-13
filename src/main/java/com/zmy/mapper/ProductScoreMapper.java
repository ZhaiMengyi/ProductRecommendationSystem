package com.zmy.mapper;


import com.zmy.entity.ProductScore;
import org.apache.ibatis.annotations.Param;

public interface ProductScoreMapper {
    Integer rateProduct(@Param(value = "productScore") ProductScore productScore);
}
