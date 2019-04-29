package com.zmy.service.impl;

import com.zmy.entity.ShoppingCart;
import com.zmy.mapper.ShoppingCartMapper;
import com.zmy.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public ShoppingCart getCartById(Integer cartId) {
        return shoppingCartMapper.getCartById(cartId);
    }

    @Override
    public Integer deleteCartBatch(List<Integer> cartIds) {
        return shoppingCartMapper.deleteCartBatch(cartIds);
    }

    @Override
    public Integer addProToCarts(ShoppingCart shoppingCart) {
        return shoppingCartMapper.addProToCarts(shoppingCart);
    }

    @Override
    public Integer deleteProFromCarts(Integer cartId) {
        return shoppingCartMapper.deleteProFromCarts(cartId);
    }

    @Override
    public List<ShoppingCart> queryCart(Integer userId) {
        return shoppingCartMapper.queryCart(userId);
    }

    @Override
    public Integer modifyProNum(Integer cartId, Integer proNum) {
        return shoppingCartMapper.modifyProNum(cartId, proNum);
    }
}
