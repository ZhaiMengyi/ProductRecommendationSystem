package com.zmy.service;


import com.zmy.entity.UserOrder;


public interface UserOrderService {
    /**
     * 订单信息
     * @param userOrder
     * @return 影响行数
     */
    Integer order(UserOrder userOrder);

}
