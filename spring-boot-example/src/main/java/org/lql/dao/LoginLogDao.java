package org.lql.dao;

import org.lql.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Title: LoginLogDao <br>
 * ProjectName: learn-spring <br>
 * description: 登录日志持久层对象 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/28 13:18 <br>
 */
@Repository
public class LoginLogDao {
    private final String INSERT_LOGIN_LOG_SQL = " insert into t_login_log(user_id, ip, login_datetime) values(?, ?, ?) ";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog) {
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
    }
}
