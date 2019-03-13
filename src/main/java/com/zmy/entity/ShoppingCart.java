package com.zmy.entity;


public class ShoppingCart {
    private Integer cartId;
    private Integer userId;
    private Integer proId;
    private Integer proNum;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer cartId, Integer userId, Integer proId, Integer proNum) {
        this.cartId = cartId;
        this.userId = userId;
        this.proId = proId;
        this.proNum = proNum;
    }

    public ShoppingCart(Integer userId, Integer proId, Integer proNum) {
        this.userId = userId;
        this.proId = proId;
        this.proNum = proNum;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", proId=" + proId +
                ", proNum=" + proNum +
                '}';
    }
}
