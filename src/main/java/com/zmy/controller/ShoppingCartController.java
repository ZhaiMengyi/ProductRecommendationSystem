package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.ShoppingCart;
import com.zmy.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/shoppingCarts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加商品到购物车
     *
     * @param userId
     * @param proId
     * @param proNum
     * @return
     */
    @RequestMapping(value = "addProToCarts")
    @ResponseBody
    public Message addProToCarts(@RequestParam(value = "userId") Integer userId,
                                 @RequestParam(value = "proId") Integer proId,
                                 @RequestParam(value = "proNum") Integer proNum) {
        shoppingCartService.addProToCarts(new ShoppingCart(userId, proId, proNum));
        return Message.success("添加成功");
    }

    /**
     * 从购物车删除商品
     *
     * @param cartId
     * @return
     */
    @RequestMapping(value = "deleteProFromCarts")
    @ResponseBody
    public Message deleteProFromCarts(@RequestParam(value = "cartId") Integer cartId) {
        shoppingCartService.deleteProFromCarts(cartId);
        return Message.success("删除成功");
    }
}
