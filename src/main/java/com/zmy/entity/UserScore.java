package com.zmy.entity;

/**
 * 用户评分实体类
 *
 * @author Chen Rui
 * @date 2019-04-28 10:07
 **/
public class UserScore {

    private Integer scoreId;

    private Integer userId;

    private Integer proId;

    private Double score;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
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
        return "UserScore{" +
                "scoreId=" + scoreId +
                ", userId=" + userId +
                ", proId=" + proId +
                ", score=" + score +
                '}';
    }
}
