package com.zmy.service;

import com.zmy.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 注册用户账号
     * @param user 用户账号信息
     * @return 影响行数
     */
    Integer registerUser(User user);
    /**
     * 用户登录
     * @param userName     用户名
     * @param userPassword 用户密码
     * @return 影响行数
     */
    User loginUser(@Param(value = "userName") String userName, @Param(value = "userPassword") String userPassword);
    /**
     * 查看个人信息
     * @param userId 用户Id
     * @return 个人信息
     */
    User inquireUserInfoById(Integer userId);
    /**
     * 修改个人信息
     * @param user 修改后的个人信息
     * @return 影响行数
     */
    Integer modifyUserInfo(User user);
    /**
     * 注销用户账号
     * @param userId 用户Id
     * @return 影响行数
     */
}