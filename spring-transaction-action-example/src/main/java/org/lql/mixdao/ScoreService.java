package org.lql.mixdao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Title: ScoreService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/20 16:03 <br>
 */
@Service("scoreService")
public class ScoreService extends BaseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd) {
        String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";
        jdbcTemplate.update(sql, toAdd, userName);
//        throw new RuntimeException("");

        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        System.out.println("[scoreUserService.addScore]激活连接数量："+basicDataSource.getNumActive());
    }
}
