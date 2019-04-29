package com.zmy.service.impl;

import com.zmy.entity.UserOrder;
import com.zmy.mapper.UserOrderMapper;
import com.zmy.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userOrderService")
@Transactional(rollbackFor = Exception.class)
public class UserOrderServiceImpl implements UserOrderService {

    @Resource
    private UserOrderMapper userOrderMapper;

    @Override
    public Integer payOrder(Integer ordId) {
        return userOrderMapper.payOrder(ordId);
    }

    @Override
    public Integer createOrder(UserOrder userOrder) {
        return userOrderMapper.createOrder(userOrder);
    }

    @Override
    public Integer createOrderBatch(List<UserOrder> orders) {
        return userOrderMapper.createOrderBatch(orders);
    }

    @Override
    public Integer cancelOrder(Integer ordId) {
        return userOrderMapper.cancelOrder(ordId);
    }
}
