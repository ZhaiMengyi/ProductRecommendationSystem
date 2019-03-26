package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.Merchant;
import com.zmy.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RequestMapping("/merchant")
@Controller
public class MerchantController {

    @Resource
    private MerchantService merchantService;

    @Resource
    private HttpServletRequest request;

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
        Integer merId = merchantService.loginMerchant(merUsername, merPassword);
        if (merId > 0) {
            request.getSession().setAttribute("merId", merId);
            return Message.success("登录成功");
        }

        return Message.error("账号或密码错误，请重新输入");
    }

    /**
     * 顾客查询商铺信息
     * 使用参数传递商家id
     * @return 返回商家对象
     */
    @RequestMapping(value = "inquireMerInfoFromCus", method = RequestMethod.GET)
    @ResponseBody
    public Message inquireMerInfoFromCus(@RequestParam(value = "merId") Integer merId) {
        Merchant merchant = merchantService.inquireMerInfoById(merId);
        if (merchant != null && merchant.getMerStatus() != 1) {
            return Message.success("查询成功").addObject("merchant", merchant);
        }
        return Message.error("抱歉，没有任何数据");
    }

    /**
     * 商家查询自身信息
     * 使用参数传递商家id
     * @return 返回商家对象
     */
    @RequestMapping(value = "inquireMerInfo", method = RequestMethod.GET)
    @ResponseBody
    public Message inquireMerInfo() {
        Integer merId = (Integer) request.getSession().getAttribute("merId");
        Merchant merchant = merchantService.inquireMerInfoById(merId);
        if (merchant == null) {
            return Message.error("抱歉，没有任何数据");
        }
        return Message.success("查询成功").addObject("merchant", merchant);
    }

    /**
     * 修改商铺信息
     *
     * @param merUsername
     * @param merPassword
     * @param merShopName
     * @param merMobile
     * @param merAddress
     * @return
     */
    @RequestMapping(value = "modifyMerInfo",method = RequestMethod.PUT)
    @ResponseBody
    public Message modifyMerInfo(@RequestParam(value = "merUsername") String merUsername,
                                 @RequestParam(value = "merPassword") String merPassword,
                                 @RequestParam(value = "merShopName") String merShopName,
                                 @RequestParam(value = "merMobile") String merMobile,
                                 @RequestParam(value = "merAddress") String merAddress) {
        Integer merId = (Integer) request.getSession().getAttribute("merId");
        System.out.println(merId);
        merchantService.modifyMerInfo(new Merchant(merId,merUsername, merPassword, merShopName, merMobile, merAddress));
        return Message.success("修改成功");
    }

    /**
     * 注销商铺信息
     * @return
     */
    @RequestMapping(value = "deleteMerchant")
    @ResponseBody
    public Message deleteMerchant() {
        Integer merId = (Integer) request.getSession().getAttribute("merId");
        Integer res = merchantService.deleteMerchant(merId);
        if (res > 0) {
            return Message.success("注销成功");
        }
        return Message.error("注销失败");
    }

    @RequestMapping(value = "logoutMerchant")
    @ResponseBody
    public Message logoutMerchant() {
        final String key = "merId";

        //<editor-fold desc="测试数据，在测试方法中设置的属性merId，并且打印，非测试环境注释此段代码">
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("merId"));
        //</editor-fold>

        if (session.getAttribute(key) != null){
            request.getSession().removeAttribute(key);
        }
        return Message.success("退出登录成功");
    }
    /**
     * 页面跳转
     * @param page  页面名
     * @return  视图
     */
    @RequestMapping(value = "pages/{page}", method = RequestMethod.GET)
    public String toPage(@PathVariable("page")String page){
        return page;
    }
}
