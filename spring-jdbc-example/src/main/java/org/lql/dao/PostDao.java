package org.lql.dao;

import com.mysql.cj.MysqlConnection;
import javafx.geometry.Pos;
import org.lql.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Title: Post <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/24 10:17 <br>
 */
@Repository
public class PostDao {
    public static final String ADD_POST = "insert into t_post(post_id, user_id, post_text, post_attach) values(?, ?, ?, ?)";
    public static final String GET_ATTACHS = "select post_id, post_attach from t_post where user_id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LobHandler lobHandler;

    // 自增主键
    @Autowired
    private DataFieldMaxValueIncrementer dataFieldMaxValueIncrementer;

    public void getNativeConn() {
        // 使用DataSourceUtils从模板类中获取连接
        Connection connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        try {
            // 使用模板类的本地JDBC抽取器获取本地连接
            connection = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(connection);

            // 进行强制类型转换
            MysqlConnection connection1 = (MysqlConnection) connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPost(final Post post) {
        jdbcTemplate.execute(PostDao.ADD_POST, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            @Override
            protected void setValues(PreparedStatement preparedStatement, LobCreator lobCreator) throws SQLException, DataAccessException {
                // 使用spring自增主键
                preparedStatement.setInt(1, dataFieldMaxValueIncrementer.nextIntValue());
                preparedStatement.setInt(2, post.getUserId());

                // 设置clob字段
                lobCreator.setClobAsString(preparedStatement, 3, post.getPostText());
                // 设置blob字段
                lobCreator.setBlobAsBytes(preparedStatement, 4, post.getPostAttach());
            }
        });
    }

    // 以块方式读取LOB数据
    public List<Post> getAttachs(final int userId) {
        return jdbcTemplate.query(PostDao.GET_ATTACHS, new Object[]{userId}, new RowMapper() {
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                int postId = resultSet.getInt(1);

                // 以二进制数组方式获取BLOB数据
                byte[] attach = lobHandler.getBlobAsBytes(resultSet, 2);
                Post post = new Post();
                post.setPostAttach(attach);
                post.setPostId(postId);
                return post;
            }
        });
    }

    // 以流的方式读取LOB数据
    public void getAttach(final int postId, final OutputStream os) {
        String sql = "SELECT post_attach FROM t_post WHERE post_id=? ";
        jdbcTemplate.query(sql, new Object[] {postId},
                new AbstractLobStreamingResultSetExtractor() {
                    @Override
                    protected void handleNoRowFound() throws LobRetrievalFailureException {
                        System.out.println("Not Found result!");
                    }

                    @Override
                    public void streamData(ResultSet rs) throws SQLException, IOException {
                        InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
                        if (is != null) {
                            FileCopyUtils.copy(is, os);
                        }
                    }
                }
        );

    };
}
