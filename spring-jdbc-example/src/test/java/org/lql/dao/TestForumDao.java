package org.lql.dao;

import org.lql.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: TestForumDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 14:45 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Rollback
@Transactional
public class TestForumDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ForumDao forumDao;

    @Test
    public void testInit() throws Throwable {
        forumDao.initDb();
    }

    @Test
    public void testAddForum() throws Throwable {
        Forum forum = new Forum();
        forum.setForumName("测试");
        forum.setForumDesc("test");

        forumDao.addForum(forum);
    }

    @Test
    public void testAddForums() throws Throwable {
        List<Forum> forums = new ArrayList<Forum>();
        for(int i =0 ;i< 10 ;i++){
            Forum f1 = new Forum();
            f1.setForumName("测试");
            f1.setForumDesc("test");
            forums.add(f1);
        }

        forumDao.addForums(forums);
    }

    @Test
    public void testGetFourm() {
        Forum forum = forumDao.getForum(27296);
        System.out.println(forum);
    }
}
