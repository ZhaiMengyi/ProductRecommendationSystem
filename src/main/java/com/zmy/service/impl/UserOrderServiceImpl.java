package com.zmy.service.impl;

import com.zmy.entity.UserOrder;
import com.zmy.mapper.UserOrderMapper;
import com.zmy.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderMapper orderMapper;

    @Override
    public Integer payOrder(Integer ordId) {
        return orderMapper.payOrder(ordId);
    }

    @Override
    public Integer createOrder(UserOrder userOrder) {
        return orderMapper.createOrder(userOrder);
    }

    @Override
    public Integer cancelOrder(Integer ordId) {
        return orderMapper.cancelOrder(ordId);
    }
}
