package com.zmy.mapper;

import com.zmy.dto.CartDTO;
import com.zmy.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    Integer addProToCarts(@Param(value = "shoppingCart") ShoppingCart shoppingCart);

    Integer deleteProFromCarts(Integer cartId);

    List<CartDTO> queryCart(Integer userId);
}
