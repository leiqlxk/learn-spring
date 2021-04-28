package org.lql.dao;

import org.lql.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Title: UserDao <br>
 * ProjectName: learn-spring <br>
 * description: 用户持久层 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/28 12:59 <br>
 */
@Repository
public class UserDao {
    private final static String MATCH_COUNT_SQL = " select count(*) from t_user where user_name = ? and password = ? ";
    private final static String FIND_USER_SQL = " select user_id, user_name, credits from t_user where user_name = ? ";
    private final static String UPDATE_INFO_SQL = " update t_user set last_visit = ?, last_ip = ?, credits = ? where user_id = ? ";

    // spring的jdbc封装
    private JdbcTemplate jdbcTemplate;

    //  自动注入
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password) {

        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(String userName) {
        final User user = new User();
        jdbcTemplate.query(FIND_USER_SQL, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });

        return user;
    }

    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_INFO_SQL, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }
}
