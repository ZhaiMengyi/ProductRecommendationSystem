package com.zmy.mapper;

import com.zmy.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserOrderMapper {
    Integer order(@Param(value = "userOrder") UserOrder userOrder);
}
