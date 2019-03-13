package com.zmy.entity;

public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userMobile;
    private String userAddress;

    public User() {
    }

    public User(Integer userId, String userName, String userPassword, String userMobile, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
    }

    public User(String userName, String userPassword, String userMobile, String userAddress) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
