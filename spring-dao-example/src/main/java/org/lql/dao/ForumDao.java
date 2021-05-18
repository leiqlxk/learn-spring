package org.lql.dao;

import org.lql.domain.Forum;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Title: ForumDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/18 17:07 <br>
 */
@Repository
public class ForumDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void initDb() {
        String sql = "Create table t_user(user_id int primary key, user_name varchar(60))";

        jdbcTemplate.execute(sql);
    }


    public Forum getForum(int forumId) {
        String sql = "select * from t_forum where forum_id = " + forumId;

        return jdbcTemplate.query(sql, new ResultSetExtractor<Forum>() {
            public Forum extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                return null;
            }
        });
    }

    public void updateForum(Forum forum) {
    }
}
