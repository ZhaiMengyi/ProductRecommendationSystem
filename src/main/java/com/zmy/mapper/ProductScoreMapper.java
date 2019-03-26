package com.zmy.mapper;


import com.zmy.entity.ProductScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface ProductScoreMapper {
    Integer rateProduct(@Param(value = "productScore") ProductScore productScore);
}
