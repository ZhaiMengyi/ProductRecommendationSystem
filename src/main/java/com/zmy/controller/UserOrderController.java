package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.UserOrder;
import com.zmy.service.UserOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/userOrder")
public class UserOrderController {

    @Resource
    private UserOrderService userOrderService;

    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "createOrder")
    @ResponseBody
    public Message createOrder(@RequestParam(value = "proId") Integer proId,
                               @RequestParam(value = "ordAddress") String ordAddress){
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0){
            Date date = new Date();
            String createTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
            UserOrder order = new UserOrder(userId, proId, createTime, ordAddress);
            Integer result = userOrderService.createOrder(order);
            if (result > 0){
                return Message.success("创建订单成功");
            }
            return Message.error("创建订单失败");
        }

        return Message.error("请登录");
    }

    @RequestMapping(value = "payOrder")
    @ResponseBody
    public Message payOrder(@RequestParam(value = "ordId") Integer ordId) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0){
            Integer result = userOrderService.payOrder(ordId);
            if (result > 0) {
                return Message.success("支付成功");
            }
            return Message.error("支付失败");
        }

        return Message.error("请登录");
    }

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
