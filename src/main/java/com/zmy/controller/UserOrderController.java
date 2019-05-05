package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.ShoppingCart;
import com.zmy.entity.User;
import com.zmy.entity.UserOrder;
import com.zmy.entity.UserScore;
import com.zmy.service.ShoppingCartService;
import com.zmy.service.UserOrderService;
import com.zmy.service.UserScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping(value = "/userOrder")
public class UserOrderController {

    @Resource
    private UserOrderService userOrderService;

    @Resource
    private ShoppingCartService shoppingCartService;

    @Resource
    private UserScoreService userScoreService;

    @Resource
    private HttpServletRequest request;

    /**
     * 从购物车结算商品
     * @param cartIds
     * @return
     */
    @RequestMapping(value = "payCart")
    @ResponseBody
    public Message payCart(@RequestParam(value = "cartIds[]") Integer[] cartIds){
        User user = (User) request.getSession().getAttribute("user");
        List<UserOrder> orders = new ArrayList<>();
        List<UserScore> userScores = new ArrayList<>();
        if (user != null){
            for (Integer cartId : cartIds){
                ShoppingCart cart = shoppingCartService.getCartById(cartId);
                UserOrder order = new UserOrder();
                order.setProId(cart.getProduct().getProId());
                order.setUserId(user.getUserId());
                order.setOrdAddress(user.getUserAddress());
                order.setOrdTime(new Date().toString());
                orders.add(order);

                UserScore userScore = new UserScore();
                userScore.setUserId(user.getUserId());
                userScore.setProId(cart.getProduct().getProId());
                userScore.setScore(10.0);
                userScores.add(userScore);
            }
            Integer line = userOrderService.createOrderBatch(orders);

            // 删除购物车
            List<Integer> cartsList = Arrays.asList(cartIds);
            Integer line2 = shoppingCartService.deleteCartBatch(cartsList);

            if (line > 0 && line2 > 0) {
                userScoreService.addScoreBatch(userScores);
                return Message.success("创建订单成功");
            } else {
                return Message.error("创建订单失败");
            }
        }

        return Message.error("请登录");
    }

    /**
     * 直接购买商品
     * @param proId
     * @return
     */
    @RequestMapping(value = "payProduct")
    @ResponseBody
    public Message payProduct(@RequestParam(value = "proId") Integer proId) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            UserOrder userOrder = new UserOrder();
            userOrder.setUserId(user.getUserId());
            userOrder.setProId(proId);
            userOrder.setOrdAddress(user.getUserAddress());
            userOrder.setOrdTime(new Date().toString());
            Integer result = userOrderService.createOrder(userOrder);

            UserScore userScore = new UserScore();
            userScore.setUserId(user.getUserId());
            userScore.setProId(proId);
            userScore.setScore(10.0);
            userScoreService.addScore(userScore);

            if (result > 0) {
                return Message.success("支付成功");
            }
            return Message.error("支付失败");
        }

        return Message.error("请登录");
    }

    /**
     * 取消订单
     * @param ordId
     * @return
     */
    @RequestMapping(value = "cancelOrder")
    @ResponseBody
    public Message cancelOrder(@RequestParam(value = "ordId") Integer ordId){
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0){
            Integer result = userOrderService.cancelOrder(ordId);
            if (result > 0) {
                return Message.success("取消订单成功");
            }
            return Message.error("取消订单失败");
        }

        return Message.error("请登录");
    }
}
