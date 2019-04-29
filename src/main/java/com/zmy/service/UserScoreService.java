package com.zmy.service;


import com.zmy.entity.UserScore;

import java.util.List;

/**
 * 评分
 *
 * @date 2019-04-21 10:05
 **/
public interface UserScoreService {
    /**
     * 查询评分数据
     * @param userScore
     * @return
     */
    UserScore getUserScore(UserScore userScore);

    /**
     * 添加评分数据
     *
     * @param userScore
     */
    void addScore(UserScore userScore);

    /**
     * 批量添加评分数据
     * @param userScores
     */
    void addScoreBatch(List<UserScore> userScores);
    /**
     * 更新评分数据
     *
     * @param userScore
     */
    void updateScore(UserScore userScore);
}
