package com.zmy.service;


import com.zmy.entity.UserOrder;


public interface UserOrderService {
    /**
     * 订单信息
     *
     * @return 影响行数
     */
    Integer payOrder(Integer ordId);

    Integer createOrder(UserOrder userOrder);

    Integer cancelOrder(Integer ordId);
}
