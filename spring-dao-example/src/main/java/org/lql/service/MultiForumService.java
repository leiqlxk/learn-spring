package org.lql.service;

import org.lql.ForumTransactional;
import org.lql.TopicTransactional;
import org.lql.dao.ForumDao;
import org.lql.dao.PostDao;
import org.lql.dao.TopicDao;
import org.lql.domain.Forum;
import org.lql.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: MultiForumService <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/19 22:30 <br>
 */
@Service
public class MultiForumService {
    private ForumDao forumDao;
    private TopicDao topicDao;
    private PostDao postDao;

    // 使用不同的事务管理器，正常情况下一个应用只需要一个事务管理器,在一两处使用带标识的Transaction注解也许合适
    // 但如果到处都使用则显得比较啰嗦，可以使用自定义一个绑定到特定事务管理器的注解，然后直接使用这个自定义注解
    //	@Transactional("topic")
    @TopicTransactional
    public void addTopic(Topic topic) throws Exception {
        System.out.println("topic tx");
    }

    // 使用不同的事务管理器
    //	@Transactional("forum")
    @ForumTransactional
    public void updateForum(Forum forum) {
        System.out.println("forum tx");
    }

    public ForumDao getForumDao() {
        return forumDao;
    }
    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }
    public TopicDao getTopicDao() {
        return topicDao;
    }
    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }
    public PostDao getPostDao() {
        return postDao;
    }
    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
