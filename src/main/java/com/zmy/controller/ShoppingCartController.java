package com.zmy.controller;

import com.zmy.dto.CartDTO;
import com.zmy.dto.Message;
import com.zmy.entity.ShoppingCart;
import com.zmy.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/shoppingCarts")
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;

    @Resource
    private HttpServletRequest request;
    /**
     * 添加商品到购物车
     *
     * @param proId
     * @param proNum
     * @return
     */
    @RequestMapping(value = "addProToCarts")
    @ResponseBody
    public Message addProToCarts(@RequestParam(value = "proId") Integer proId,
                                 @RequestParam(value = "proNum") Integer proNum) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0){
            Integer result = shoppingCartService.addProToCarts(new ShoppingCart(userId, proId, proNum));
            if (result > 0) {
                return Message.success("添加成功");
            }
        }
        return Message.error("添加失败");
    }

    @RequestMapping(value = "queryCart")
    @ResponseBody
    public Message listAllCarts() {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0) {
            List<CartDTO> carts = shoppingCartService.queryCart(userId);
            if (carts != null && carts.size() > 0){
                return Message.success("查询成功").addObject("carts", carts);
            }
            return Message.error("您的购物车为空");
        }

        return Message.error("查询失败");
    }

    /**
     * 从购物车删除商品
     *
     * @param cartId
     * @return
     */
    @RequestMapping(value = "deleteProFromCart")
    @ResponseBody
    public Message deleteProFromCart(@RequestParam(value = "cartId") Integer cartId) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0) {
            Integer result = shoppingCartService.deleteProFromCarts(cartId);
            if (result > 0) {
                return Message.success("删除成功");
            }

            return Message.error("删除失败");
        }

        return Message.error("请重新登录");
    }

    @RequestMapping(value = "modifyProNum")
    @ResponseBody
    public Message modifyProNum(@RequestParam(value = "cartId") Integer cartId,
                                @RequestParam(value = "proNum") Integer proNum){
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0) {
            Integer result = shoppingCartService.modifyProNum(cartId, proNum);
            if (result > 0) {
                return Message.success("修改成功");
            }

            return Message.error("修改失败");
        }

        return Message.error("请重新登录");
    }
}
