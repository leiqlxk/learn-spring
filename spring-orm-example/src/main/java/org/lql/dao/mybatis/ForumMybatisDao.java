package org.lql.dao.mybatis;

import org.lql.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintWriter;
import java.util.List;

/**
 * Title: ForumMybatisDao <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 21:32 <br>
 */
public interface ForumMybatisDao {

    void addForum(Forum forum);

    void updateForum(Forum forum);

    Forum getForum(int forumId);

    long getForumNum();

    List<Forum> findForumByName(String forumName);
}
