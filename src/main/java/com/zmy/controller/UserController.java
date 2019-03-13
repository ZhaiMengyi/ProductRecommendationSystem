package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.User;
import com.zmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param userName
     * @param userPassword
     * @param userMobile
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "registerUser")
    @ResponseBody
    public Message registerUser(@RequestParam(value = "userName")String userName,
                                @RequestParam(value = "userPassword")String userPassword,
                                @RequestParam(value = "userMobile")String userMobile,
                                @RequestParam(value = "userAddress")String userAddress){
        userService.registerUser(new User(userName,userPassword,userMobile,userAddress));
        return Message.success("注册成功");
    }

    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "loginUser")
    @ResponseBody
    public Message loginUser(@RequestParam(value = "userName") String userName,
                             @RequestParam(value = "userPassword") String userPassword){
        userService.loginUser(userName,userPassword);
        return Message.success("登录成功");
    }

    /**
     * 查询
     * @param userId
     * @return
     */
    @RequestMapping(value = "inquireUserInfoById")
    @ResponseBody
    public Message inquireUserInfoById(@RequestParam(value = "userId")Integer userId){
        return Message.success().addObject("user",userService.inquireUserInfoById(userId));
    }

    /**
     * 修改
     * @param userId
     * @param userName
     * @param userPassword
     * @param userMobile
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "modifyUserInfo")
    @ResponseBody
    public Message modifyUserInfo(@RequestParam(value = "userId")Integer userId,
                                @RequestParam(value = "userName")String userName,
                                @RequestParam(value = "userPassword")String userPassword,
                                @RequestParam(value = "userMobile")String userMobile,
                                @RequestParam(value = "userAddress")String userAddress){
        userService.modifyUserInfo(new User(userName,userPassword,userMobile,userAddress));
        return Message.success("修改成功");
    }

    /**
     * 注销
     * @param userId
     * @return
     */
    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public Message deleteUser(@RequestParam(value = "userId")Integer userId){
        userService.deleteUser(userId);
        return Message.success("注销成功");
    }
}
