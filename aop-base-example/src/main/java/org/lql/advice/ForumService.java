package org.lql.advice;

import java.sql.SQLException;

/**
 * Title: ForumService <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:17 <br>
 */
public class ForumService {

    public void removeForum(int forumId) {
        throw new RuntimeException("运行异常");
    }

    public void updateForum(Forum forum) throws Exception{
        throw new SQLException("数据库更新异常");
    }
}
