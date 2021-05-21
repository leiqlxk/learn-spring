package org.lql.dao;

import org.lql.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Title: ForumDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 14:24 <br>
 */
@Repository
public class ForumDao {
    public static String INIT_SQL = "create table t_forum(forum_id int primary key, forum_name varchar(60), forum_desc varchar(60))";
    public static String ADD_FORUM = "insert into t_forum(forum_name, forum_desc) value(?, ?)";
    public static String GET_FORUM_BY_ID = "select * from t_forum where forum_id = ?";
    public static String GET_FORUM_NUM = "select count(*) from t_forum";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initDb() {
        jdbcTemplate.execute(ForumDao.INIT_SQL);
    }

    /**
     * description: 更新一条数据 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/5/21 15:52 <br>
     *
     * @throws
     * @param forum
     * @return void
     */
    public void addForum(final Forum forum) {
        Object[] objects = new Object[] {forum.getForumName(), forum.getForumDesc()};

        // 方式一
        // jdbcTemplate.update(ForumDao.ADD_FORUM, objects);

        // 方式二，指定参数类型
        // jdbcTemplate.update(ForumDao.ADD_FORUM, objects, new int[]{Types.VARCHAR, Types.VARCHAR});

        // 方式三，通过PreparedStatementSetter设置参数
        /*jdbcTemplate.update(ForumDao.ADD_FORUM, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, forum.getForumName());
                preparedStatement.setString(2, forum.getForumDesc());
            }
        });*/

        // 方式四，返回自增长主键
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(ForumDao.ADD_FORUM, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, forum.getForumName());
                ps.setString(2, forum.getForumDesc());

                return ps;
            }
        }, keyHolder);
        forum.setForumId(keyHolder.getKey().intValue());
        System.out.println(forum);
    }

    /**
     * description: 批量更新 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/5/21 15:54 <br>
     *
     * @throws
     * @param forumList
     * @return void
     */
    public void addForums(final List<Forum> forumList) {
        jdbcTemplate.batchUpdate(ForumDao.ADD_FORUM, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Forum forum = forumList.get(i);
                preparedStatement.setString(1, forum.getForumName());
                preparedStatement.setString(2, forum.getForumDesc());
            }

            public int getBatchSize() {
                return forumList.size();
            }
        });
    }

    /**
     * description: 根据id获取记录 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/5/21 16:20 <br>
     *
     * @throws
     * @param forumId
     * @return org.lql.domain.Forum
     */
    public Forum getForum(final int forumId) {
        final Forum forum = new Forum();

        jdbcTemplate.query(ForumDao.GET_FORUM_BY_ID, new Object[]{forumId}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                forum.setForumId(forumId);
                forum.setForumName(resultSet.getString("forum_name"));
                forum.setForumDesc(resultSet.getString("forum_desc"));
            }
        });

        return forum;
    }

    /**
     * description: 批量获取数据 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/5/21 16:26 <br>
     *
     * @throws
     * @param fromId
     * @param toId
     * @return java.util.List<org.lql.domain.Forum>
     */
    public List<Forum> getForums(final int fromId, final int toId) {
        String sql = "SELECT forum_id,forum_name,forum_desc FROM t_forum WHERE forum_id between ? and ?";
        // 方法1：使用RowCallbackHandler接口
        /*
         * final List<Forum> forums = new ArrayList<Forum>();
         * jdbcTemplate.query(sql,new Object[]{fromId,toId},new
         * RowCallbackHandler(){ public void processRow(ResultSet rs) throws
         * SQLException { Forum forum = new Forum();
         * forum.setForumId(rs.getInt("forum_id"));
         * forum.setForumName(rs.getString("forum_name"));
         * forum.setForumDesc(rs.getString("forum_desc")); forums.add(forum);
         * }}); return forums;
         */

        return jdbcTemplate.query(sql, new Object[] { fromId, toId },
                new RowMapper<Forum>() {
                    public Forum mapRow(ResultSet rs, int index)
                            throws SQLException {
                        Forum forum = new Forum();
                        forum.setForumId(rs.getInt("forum_id"));
                        forum.setForumName(rs.getString("forum_name"));
                        forum.setForumDesc(rs.getString("forum_desc"));
                        return forum;
                    }
                });

    }

    public int getForumNum() {
        return jdbcTemplate.queryForObject(ForumDao.GET_FORUM_NUM, Integer.class);
    }
}
