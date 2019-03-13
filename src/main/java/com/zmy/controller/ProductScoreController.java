package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.ProductScore;
import com.zmy.service.ProductScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/productScore")
public class ProductScoreController {
    @Autowired
    private ProductScoreService productScoreService;

    @RequestMapping(value = "rateProduct")
    @ResponseBody
    public Message rateProduct(@RequestParam(value = "userId") Integer userId,
                               @RequestParam(value = "proId") Integer proId,
                               @RequestParam(value = "score") Double score) {
        productScoreService.rateProduct(new ProductScore(userId, proId, score));
        return Message.success("打分成功");
    }

}
