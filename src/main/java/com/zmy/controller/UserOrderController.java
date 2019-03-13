package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.UserOrder;
import com.zmy.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/userOrder")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping(value = "order")
    @ResponseBody
    public Message order(@RequestParam(value = "userId")Integer userId,
                         @RequestParam(value = "proId")Integer proId,
                         @RequestParam(value = "ordTime")Date ordTime,
                         @RequestParam(value = "ordAddress")String ordAddress){
        userOrderService.order(new UserOrder(userId,proId,ordTime,ordAddress));
        return Message.success("订单支付成功");
    }
}
