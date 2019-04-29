package com.zmy.mapper;

import com.zmy.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userOrderMapper")
public interface UserOrderMapper {
    Integer payOrder(@Param(value = "ordId") Integer ordId);

    Integer createOrderBatch(List<UserOrder> orders);

    Integer createOrder(@Param(value = "userOrder") UserOrder userOrder);

    Integer cancelOrder(Integer ordId);
}
