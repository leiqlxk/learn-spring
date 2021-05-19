package org.lql.service;

import org.lql.dao.ForumDao;
import org.lql.dao.PostDao;
import org.lql.dao.TopicDao;
import org.lql.domain.Forum;
import org.lql.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title: BbtForum <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/18 17:07 <br>
 */
@Service
// Transaction的属性：
//      事务传播行为（propagation）：默认为Propagation.REQUIRED
//      事务隔离级别（isolation）：默认为Isolation.ISOLATION_DEFAULT
//      读写事务属性（readOnly）：默认为false，布尔值
//      超时时间（timeout）：int型以秒为单位，默认依赖底层的事务系统的默认值
//      回滚设置（rollbackFor）：一组异常类，默认为任何运行时异常引发回滚，任何检查时异常不会引发回滚，可以设置多个用逗号隔开
//      回滚设置（rollbackForClassName）：一组异常类名
//      不回滚设置（noRollbackFor）
//      不回滚设置（noRollbackForClassName）
@Transactional
public class BbtForum {

    public ForumDao forumDao;

    public TopicDao topicDao;

    public PostDao postDao;

    public void addTopic(Topic topic) {
        topicDao.addTopic(topic);
        postDao.addPost(topic.getPost());
    }

    public Forum getForum(int forumId) {
        return forumDao.getForum(forumId);
    }

    public void updateForum(Forum forum) {
        forumDao.updateForum(forum);
    }


    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }
}
