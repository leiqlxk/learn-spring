package org.lql.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * Title: TestForumDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 17:10 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})
@Rollback
@Transactional
public class TestForumDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ForumMybatisDao forumMybatisDao;

    @Test
    public void getForum() {
        System.out.println(forumMybatisDao.getForum(27296));
    }
}
