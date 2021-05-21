package org.lql.connleak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Title: JdbcUserService <br>
 * ProjectName: learn-spring <br>
 * description: 连接泄漏 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 11:24 <br>
 */
@Service("jdbcUserService")
public class JdbcUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void logon(String name) {

        try {
            // 直接从数据源获取连接，后续程序没有显示释放连接，其将造成数据连接泄露问题
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            String sql = "**********************";
            jdbcTemplate.update(sql);

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
