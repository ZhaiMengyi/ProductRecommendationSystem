package com.zmy.dto;

/**
 * 购物车的数据传输对象
 *
 * @author Chen Rui
 * @version 1.0
 **/
public class CartDTO {

    private Integer proId;
    private Integer proNum;

    public CartDTO() {
    }

    public CartDTO(Integer proId, Integer proNum) {
        this.proId = proId;
        this.proNum = proNum;
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
        return "CartDTO{" +
                "proId=" + proId +
                ", proNum=" + proNum +
                '}';
    }
}
