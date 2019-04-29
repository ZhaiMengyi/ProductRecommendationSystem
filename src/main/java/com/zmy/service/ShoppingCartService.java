package com.zmy.service;

import com.zmy.dto.CartDTO;
import com.zmy.entity.Product;
import com.zmy.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart getCartById(Integer cartId);
    /**
     * 添加商品到购物车
     * @param shoppingCart 购物车信息
     * @return 影响行数
     */
    Integer addProToCarts(ShoppingCart shoppingCart);

    /**
     * 批量删除购物车
     * @param cartIds
     * @return
     */
    Integer deleteCartBatch(List<Integer> cartIds);

    /**
     * 从购物车删除商品
     * @param cartId 需要删除的购物车信息的Id号
     * @return 影响行数
     */
    Integer deleteProFromCarts(Integer cartId);
    /**
     * 查询购物车内所有商品
     * @param userId
     * @return
     */
    List<ShoppingCart> queryCart(Integer userId);
    /**
     * 修改购物车商品数量
     * @param cartId
     * @param proNum
     * @return
     */
    Integer modifyProNum(Integer cartId, Integer proNum);
}
