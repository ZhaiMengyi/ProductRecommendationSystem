package com.zmy.mapper;

import com.zmy.dto.CartDTO;
import com.zmy.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    ShoppingCart getCartById(Integer cartId);

    Integer addProToCarts(@Param(value = "shoppingCart") ShoppingCart shoppingCart);
    
    Integer deleteCartBatch(List<Integer> cartIds);
    
    Integer deleteProFromCarts(Integer cartId);

    List<ShoppingCart> queryCart(Integer userId);

    Integer modifyProNum(@Param(value = "cartId") Integer cartId, @Param(value = "proNum") Integer proNum);
}
