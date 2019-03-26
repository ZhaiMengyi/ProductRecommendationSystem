package com.zmy.controller;

import com.zmy.dto.Message;
import com.zmy.entity.User;
import com.zmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private HttpServletRequest request;

    /**
     * 注册用户
     *
     * @param userName
     * @param userPassword
     * @param userMobile
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "registerUser")
    @ResponseBody
    public Message registerUser(@RequestParam(value = "userName") String userName,
                                @RequestParam(value = "userPassword") String userPassword,
                                @RequestParam(value = "userMobile") String userMobile,
                                @RequestParam(value = "userAddress") String userAddress) {
        userService.registerUser(new User(userName, userPassword, userMobile, userAddress));
        return Message.success("注册成功");
    }

    /**
     * 登录
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "loginUser")
    @ResponseBody
    public Message loginUser(@RequestParam(value = "userName") String userName,
                             @RequestParam(value = "userPassword") String userPassword) {
        Integer userId = userService.loginUser(userName, userPassword);
        if (userId > 0){
            User user = userService.inquireUserInfoById(userId);
            if (user.getUserStatus() != 1){
                request.getSession().setAttribute("userId", userId);
                return Message.success("登录成功");
            }
        }
        return Message.error("账号或密码错误");
    }

    /**
     * 查询
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "inquireUserInfoById")
    @ResponseBody
    public Message inquireUserInfoById(@RequestParam(value = "userId") Integer userId) {
        return Message.success().addObject("user", userService.inquireUserInfoById(userId));
    }

    /**
     * 修改
     *
     * @param userName
     * @param userPassword
     * @param userMobile
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "modifyUserInfo", method = RequestMethod.PUT)
    @ResponseBody
    public Message modifyUserInfo(@RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "userPassword") String userPassword,
                                  @RequestParam(value = "userMobile") String userMobile,
                                  @RequestParam(value = "userAddress") String userAddress) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0) {
            Integer res = userService.modifyUserInfo(new User(userId, userName, userPassword, userMobile, userAddress));
            if (res > 0){
                return Message.success("修改成功");
            }
        }

        return Message.success("修改失败");
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
    @ResponseBody
    public Message deleteUser() {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (userId != null && userId != 0){
            userService.deleteUser(userId);
            return Message.success("删除用户信息成功");
        }
        return Message.error("删除用户信息失败");
    }

    @RequestMapping(value = "logoutUser", method = RequestMethod.PUT)
    @ResponseBody
    public Message logoutUser() {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null && userId != 0){
            session.removeAttribute("userId");
            return Message.success("退出登录成功");
        }
        return Message.error("退出异常");
    }
}
