package com.zmy.entity;

public class ProductScore {
    private Integer userId;
    private Integer proId;
    private Double score;

    public ProductScore() {
    }

    public ProductScore(Integer userId, Integer proId, Double score) {
        this.userId = userId;
        this.proId = proId;
        this.score = score;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "ProductScore{" +
                "userId=" + userId +
                ", proId=" + proId +
                ", score=" + score +
                '}';
    }
}
