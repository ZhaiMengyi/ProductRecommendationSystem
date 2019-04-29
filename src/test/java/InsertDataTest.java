import com.zmy.entity.UserScore;
import com.zmy.mapper.UserScoreMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 插入评分数据
 *
 * @date 2019-04-28 14:37
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Rollback(value = false)
public class InsertDataTest {

    @Resource
    private UserScoreMapper userScoreMapper;

    @Test
    public void test(){
        String[] userIds = new String[]{"21","22","23","24","25","26","27","28","29","30"};
        String[] bookIds = new String[]{"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45"};
        String[] scores = new String[]{"2","6","10"};

        for (int a = 0; a < 1000; a++){
            int i = new Random().nextInt(9) + 1;
            int j = new Random().nextInt(14) +1;
            int k = new Random().nextInt(2) +1;
            Integer userId = Integer.parseInt(userIds[i]);
            Integer bookId = Integer.parseInt(bookIds[j]);
            double score = Double.parseDouble(scores[k]);

            UserScore userScore = new UserScore();
            userScore.setUserId(userId);
            userScore.setProId(bookId);
            userScore.setScore(score);
            UserScore userScore1 = userScoreMapper.getUserScore(userScore);
            if (userScore1 != null){
                userScoreMapper.updateScore(userScore);
            } else {
                userScoreMapper.addScore(userScore);
            }
            System.out.println(userId + "-" + bookId + "-" + score);
        }

    }
}