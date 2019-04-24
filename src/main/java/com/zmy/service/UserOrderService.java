package com.zmy.service;


import com.zmy.entity.UserOrder;


public interface UserOrderService {
    /**
     * 支付订单
     * @return 影响行数
     */
    Integer payOrder(Integer ordId);
    /**
     * 创建订单
     * @param userOrder
     * @return
     */
    Integer createOrder(UserOrder userOrder);
    /**
     * 取消订单
     * @param ordId
     * @return
     */
    Integer cancelOrder(Integer ordId);
}
