package com.zmy.entity;


public class UserOrder {
    private Integer ordId;
    private Integer userId;
    private Integer proId;
    private String ordTime;
    private String ordAddress;

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

    public String getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(String ordTime) {
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
