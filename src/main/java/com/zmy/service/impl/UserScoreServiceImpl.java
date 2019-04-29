package com.zmy.service.impl;

import com.zmy.entity.UserScore;
import com.zmy.mapper.UserScoreMapper;
import com.zmy.service.UserScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评分实现类
 *
 * @author Chen Rui
 * @date 2019-04-21 10:06
 **/
@Service("userScoreService")
public class UserScoreServiceImpl implements UserScoreService {

    @Resource
    private UserScoreMapper userScoreMapper;

    @Override
    public void addScore(UserScore userScore) {
        userScoreMapper.addScore(userScore);
    }

    @Override
    public void addScoreBatch(List<UserScore> userScores) {
        userScoreMapper.addScoreBatch(userScores);
    }

    @Override
    public UserScore getUserScore(UserScore userScore) {
        return userScoreMapper.getUserScore(userScore);
    }

    @Override
    public void updateScore(UserScore userScore) {
        userScoreMapper.updateScore(userScore);
    }
}
