package com.zmy.entity;

import java.util.Date;

public class UserOrder {
    private Integer ordId;
    private Integer userId;
    private Integer proId;
    private Date ordTime;
    private String ordAddress;

    public UserOrder() {
    }

    public UserOrder(Integer ordId, Integer userId, Integer proId, Date ordTime, String ordAddress) {
        this.ordId = ordId;
        this.userId = userId;
        this.proId = proId;
        this.ordTime = ordTime;
        this.ordAddress = ordAddress;
    }

    public UserOrder(Integer userId, Integer proId, Date ordTime, String ordAddress) {
        this.userId = userId;
        this.proId = proId;
        this.ordTime = ordTime;
        this.ordAddress = ordAddress;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Date getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(Date ordTime) {
        this.ordTime = ordTime;
    }

    public String getOrdAddress() {
        return ordAddress;
    }

    public void setOrdAddress(String ordAddress) {
        this.ordAddress = ordAddress;
    }


    @Override
    public String toString() {
        return "UserOrder{" +
                "ordId=" + ordId +
                ", userId=" + userId +
                ", proId=" + proId +
                ", ordTime=" + ordTime +
                ", ordAddress='" + ordAddress + '\'' +
                '}';
    }
}
