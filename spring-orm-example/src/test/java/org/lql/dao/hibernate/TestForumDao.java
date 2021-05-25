package org.lql.dao.hibernate;

import org.lql.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Title: TestForumDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 14:19 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext-hbt.xml"})
@Rollback
@Transactional
public class TestForumDao extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private ForumHibernateDao forumHibernateDao;

    @Test
    public void addForum() {
        Forum forum = new Forum();
        forum.setForumName("test");
        forum.setForumDesc("test1");

        forumHibernateDao.addForum(forum);

        List<Forum> forums = forumHibernateDao.findForumByName("test");
        System.out.println(forums);

        Long num = forumHibernateDao.getForumNum();
        System.out.println("----------num:" + num);
    }
}
