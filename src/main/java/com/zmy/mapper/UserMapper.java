package com.zmy.mapper;

import com.zmy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    Integer registerUser(@Param(value = "user") User user);

    User loginUser(@Param(value = "userName") String userName, @Param(value = "userPassword") String userPassword);

    User inquireUserInfoById(Integer userId);

    Integer modifyUserInfo(@Param(value = "user") User user);

    Integer deleteUser(Integer userId);
}
