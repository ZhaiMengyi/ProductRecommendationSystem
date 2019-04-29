package com.zmy.mapper;

import com.zmy.entity.UserScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评分Mapper
 *
 * @date 2019-04-21 10:06
 **/
@Repository("userScoreMapper")
public interface UserScoreMapper {

    /**
     * 查询评分数据
     *
     * @param userScore
     * @return
     */
    UserScore getUserScore(@Param("userScore") UserScore userScore);

    /**
     * 添加评分数据
     *
     * @param userScore
     */
    void addScore(@Param("userScore") UserScore userScore);

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
    void updateScore(@Param("userScore") UserScore userScore);
}
