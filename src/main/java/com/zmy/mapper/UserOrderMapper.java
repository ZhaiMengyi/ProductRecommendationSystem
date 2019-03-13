package com.zmy.mapper;

import com.zmy.entity.UserOrder;
import org.apache.ibatis.annotations.Param;

public interface UserOrderMapper {
    Integer order(@Param(value = "userOrder") UserOrder userOrder);
}
