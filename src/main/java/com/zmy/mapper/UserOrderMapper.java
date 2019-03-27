package com.zmy.mapper;

import com.zmy.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserOrderMapper {
    Integer payOrder(@Param(value = "ordId") Integer ordId);


    Integer createOrder(@Param(value = "userOrder") UserOrder userOrder);

    Integer cancelOrder(Integer ordId);
}
