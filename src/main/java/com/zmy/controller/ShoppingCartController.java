package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.Product;
import com.zmy.entity.ShoppingCart;
import com.zmy.entity.User;
import com.zmy.entity.UserScore;
import com.zmy.service.ProductService;
import com.zmy.service.ShoppingCartService;
import com.zmy.service.UserScoreService;
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
    private ProductService productService;

    @Resource
    private UserScoreService userScoreService;

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
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Product product = productService.inquireProductById(proId);
            ShoppingCart cart = new ShoppingCart();
            cart.setProduct(product);
            cart.setUserId(user.getUserId());
            cart.setProNum(proNum);
            Integer result = shoppingCartService.addProToCarts(cart);
            if (result > 0) {
                UserScore userScore = new UserScore();
                userScore.setUserId(user.getUserId());
                userScore.setProId(proId);
                userScore.setScore(6.0);
                userScoreService.addScore(userScore);
                return Message.success("添加成功");
            } else {
                Message.error("添加失败");
            }
        }
        return Message.error("请登录");
    }

    /**
     * 查询购物车内所有商品
     * @return
     */
    @RequestMapping(value = "queryCart")
    @ResponseBody
    public Message listAllCarts() {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<ShoppingCart> carts = shoppingCartService.queryCart(user.getUserId());
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
    public Message deleteProFromCart(Integer cartId) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Integer result = shoppingCartService.deleteProFromCarts(cartId);
            if (result > 0) {
                return Message.success("删除成功");
            }

            return Message.error("删除失败");
        }

        return Message.error("请重新登录");
    }

    /**
     * 修改购物车商品数量
     * @param cartId
     * @param proNum
     * @return
     */
    @RequestMapping(value = "modifyProNum")
    @ResponseBody
    public Message modifyProNum(@RequestParam(value = "cartId") Integer cartId,
                                @RequestParam(value = "proNum") Integer proNum){
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            Integer result = shoppingCartService.modifyProNum(cartId, proNum);
            if (result > 0) {
                return Message.success("修改成功");
            }

            return Message.error("修改失败");
        }

        return Message.error("请重新登录");
    }
}
