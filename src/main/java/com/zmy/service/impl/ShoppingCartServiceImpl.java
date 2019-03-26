package com.zmy.service.impl;

import com.zmy.dto.CartDTO;
import com.zmy.entity.ShoppingCart;
import com.zmy.mapper.ShoppingCartMapper;
import com.zmy.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public Integer addProToCarts(ShoppingCart shoppingCart) {
        return shoppingCartMapper.addProToCarts(shoppingCart);
    }

    @Override
    public Integer deleteProFromCarts(Integer cartId) {
        return shoppingCartMapper.deleteProFromCarts(cartId);
    }

    @Override
    public List<CartDTO> queryCart(Integer userId) {
        return shoppingCartMapper.queryCart(userId);
    }
}
