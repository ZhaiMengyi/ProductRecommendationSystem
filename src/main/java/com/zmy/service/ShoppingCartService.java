package com.zmy.service;

import com.zmy.entity.Product;
import com.zmy.entity.ShoppingCart;

public interface ShoppingCartService {
    /**
     * 添加商品到购物车
     *
     * @param shoppingCart 购物车信息
     * @return 影响行数
     */
    Integer addProToCarts(ShoppingCart shoppingCart);

    /**
     * 从购物车删除商品
     *
     * @param cartId 需要删除的购物车信息的Id号
     * @return 影响行数
     */
    Integer deleteProFromCarts(Integer cartId);
}
