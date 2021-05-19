package org.lql.dao;

import org.lql.domain.Topic;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

/**
 * Title: TopicDap <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/18 15:20 <br>
 */
@Repository
public class TopicDao {
    public void addTopic(Topic topic) {
    }

   /* private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        if (threadLocal.get() == null) {
            Connection conn = ConnectionManager.getConnection();
            threadLocal.set(conn);
            return conn;
        }else {
            return threadLocal.get();
        }
    }*/
}
