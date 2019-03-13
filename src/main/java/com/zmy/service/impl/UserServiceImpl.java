package com.zmy.service.impl;

import com.zmy.entity.User;
import com.zmy.mapper.UserMapper;
import com.zmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public Integer loginUser(String userName, String userPassword) {
        return userMapper.loginUser(userName, userPassword);
    }

    @Override
    public User inquireUserInfoById(Integer userId) {
        return userMapper.inquireUserInfoById(userId);
    }

    @Override
    public Integer modifyUserInfo(User user) {
        return userMapper.modifyUserInfo(user);
    }

    @Override
    public Integer deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }
}
