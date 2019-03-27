package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.ProductScore;
import com.zmy.service.ProductScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/productScore")
@Controller
public class ProductScoreController {
    @Resource
    private ProductScoreService productScoreService;

    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "rateProduct")
    @ResponseBody
    public Message rateProduct(@RequestParam(value = "proId") Integer proId,
                               @RequestParam(value = "score") Double score) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0) {
            Integer result = productScoreService.rateProduct(new ProductScore(userId, proId, score));
            if (result > 0) {
                return Message.success("评价成功");
            }
            return Message.error("评价失败");
        }

        return Message.error("请登录");
    }

}
