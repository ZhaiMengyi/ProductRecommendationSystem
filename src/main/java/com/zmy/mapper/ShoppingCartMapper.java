package com.zmy.mapper;

import com.zmy.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

public interface ShoppingCartMapper {
    Integer addProToCarts(@Param(value = "shoppingCart") ShoppingCart shoppingCart);
    Integer deleteProFromCarts(Integer cartId);
}
