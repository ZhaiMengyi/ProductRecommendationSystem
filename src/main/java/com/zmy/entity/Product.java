package com.zmy.entity;

/**
 *
 * 实体类
 * entity层 = model层
 * 用于存放我们的实体类，与数据库中的属性值基本保持一致，实现set和get的方法
 */

public class Product {
    private Integer proId;
    private String proName;
    private Double proPrice;
    private Integer proInventory;
    private String proImg;
    private Integer proBought;
    private Integer merId;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getProInventory() {
        return proInventory;
    }

    public void setProInventory(Integer proInventory) {
        this.proInventory = proInventory;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public Integer getProBought() {
        return proBought;
    }

    public void setProBought(Integer proBought) {
        this.proBought = proBought;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proInventory=" + proInventory +
                ", proImg='" + proImg + '\'' +
                ", proBought=" + proBought +
                ", merId=" + merId +
                '}';
    }
}
