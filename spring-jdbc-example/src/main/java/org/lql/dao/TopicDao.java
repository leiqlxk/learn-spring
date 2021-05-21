package org.lql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: TopicDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 16:36 <br>
 */
@Repository
public class TopicDao {

    public static String GET_REPLY_RATE = "SELECT topic_replies,topic_views FROM t_topic WHERE user_id=?";

    public static String CALL_PROCEDURE = "{call P_GET_TOPIC_NUM(?,?)}";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * description: queryForObject <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/5/21 16:43 <br>
     * 
     * @throws
     * @param userId
     * @return double
     */ 
    public double getReplyRate(int userId) {

        return jdbcTemplate.queryForObject(TopicDao.GET_REPLY_RATE, new Object[]{userId},
                new RowMapper<Double>() {
                    public Double mapRow(ResultSet resultSet, int i) throws SQLException {
                        int replies = resultSet.getInt("topic_replies");
                        int views = resultSet.getInt("topic_views");

                        if (views > 0) {
                            return (double) replies / views;
                        }else {
                            return 0.0;
                        }
                    }
                });
    }

    public int getUserTopicNum(final int userId) {
        // 方式1，通过callableStatementCallback
        /*int num = jdbcTemplate.execute(TopicDao.CALL_PROCEDURE, new CallableStatementCallback<Integer>() {
            public Integer doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                // 绑定参数
                callableStatement.setInt(1, userId);
                // 注册输出参数
                callableStatement.registerOutParameter(2, Types.INTEGER);
                callableStatement.execute();
                // 获取输出参数值
                return callableStatement.getInt(2);
            }
        });*/

        // 方式2，通过CallableStatementCreatorFactory创建CallableStatementCreator
        CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(TopicDao.CALL_PROCEDURE);
        fac.addParameter(new SqlParameter("userId", Types.INTEGER));
        fac.addParameter(new SqlOutParameter("topicNum", Types.INTEGER));
        Map<String, Integer> paramsMap = new HashMap<String, Integer>();
        paramsMap.put("userId", userId);

        CallableStatementCreator csc = fac.newCallableStatementCreator(paramsMap);
        Integer num = jdbcTemplate.execute(csc, new CallableStatementCallback<Integer>() {
            public Integer doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                callableStatement.execute();
                return callableStatement.getInt(2);
            }
        });

        return num;
    }
}
