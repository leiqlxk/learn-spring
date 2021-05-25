package org.lql.service.mybatis;

import org.lql.dao.mybatis.ForumMybatisDao;
import org.lql.dao.mybatis.PostMybatisDao;
import org.lql.dao.mybatis.TopicMybatisDao;
import org.lql.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title: BbtForumService <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 21:42 <br>
 */
@Transactional
@Service
public class BbtForumService {

    @Autowired
    private ForumMybatisDao forumMybatisDao;

    @Autowired
    private PostMybatisDao postMybatisDao;

    @Autowired
    private TopicMybatisDao topicMybatisDao;

    public void addForum(Forum forum) {
        forumMybatisDao.addForum(forum);
    }
}
