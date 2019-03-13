package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.Merchant;
import com.zmy.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    /**
     * 注册商家
     *
     * @param merUsername
     * @param merPassword
     * @param merShopName
     * @param merMobile
     * @param merAddress
     * @return
     */
    @RequestMapping(value = "registerMerchant")
    @ResponseBody
    public Message registerMerchant(@RequestParam(value = "merUsername") String merUsername,
                                    @RequestParam(value = "merPassword") String merPassword,
                                    @RequestParam(value = "merShopName") String merShopName,
                                    @RequestParam(value = "merMobile") String merMobile,
                                    @RequestParam(value = "merAddress") String merAddress) {
        merchantService.registerMerchant(new Merchant(merUsername, merPassword, merShopName, merMobile, merAddress));
        return Message.success("注册商家成功");
    }

    /**
     * 登录
     *
     * @param merUsername
     * @param merPassword
     * @return
     */
    @RequestMapping(value = "loginMerchant")
    @ResponseBody
    public Message loginMerchant(@RequestParam(value = "merUsername") String merUsername,
                                 @RequestParam(value = "merPassword") String merPassword) {
        merchantService.loginMerchant(merUsername, merPassword);
        return Message.success("登录成功");
    }

    /**
     * 查询商铺信息
     *
     * @param merId
     * @return
     */
    @RequestMapping(value = "inquireMerInfoById")
    @ResponseBody
    public Message inquireMerInfoById(@RequestParam(value = "merId") Integer merId) {
        return Message.success().addObject("merchant", merchantService.inquireMerInfoById(merId));
    }

    /**
     * 修改商铺信息
     *
     * @param merId
     * @param merUsername
     * @param merPassword
     * @param merShopName
     * @param merMobile
     * @param merAddress
     * @return
     */
    @RequestMapping(value = "modifyMerInfo")
    @ResponseBody
    public Message modifyMerInfo(@RequestParam(value = "merId") Integer merId,
                                 @RequestParam(value = "merUsername") String merUsername,
                                 @RequestParam(value = "merPassword") String merPassword,
                                 @RequestParam(value = "merShopName") String merShopName,
                                 @RequestParam(value = "merMobile") String merMobile,
                                 @RequestParam(value = "merAddress") String merAddress) {
        merchantService.modifyMerInfo(new Merchant(merUsername, merPassword, merShopName, merMobile, merAddress));
        return Message.success("修改成功");
    }

    /**
     * 注销商铺信息
     *
     * @param merId
     * @return
     */
    @RequestMapping(value = "deleteMerchant")
    @ResponseBody
    public Message deleteMerchant(@RequestParam(value = "merId") Integer merId) {
        merchantService.deleteMerchant(merId);
        return Message.success("注销成功");
    }
}
