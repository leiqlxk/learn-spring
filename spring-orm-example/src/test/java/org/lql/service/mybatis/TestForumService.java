package org.lql.service.mybatis;

import org.lql.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * Title: TestForumService <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/25 21:44 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})
@Rollback
@Transactional
public class TestForumService extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private BbtForumService bbtForumService;

    @Test
    public void addForum() {
        Forum forum = new Forum();
        forum.setForumName("test");
        forum.setForumDesc("test1");
        bbtForumService.addForum(forum);
    }
}
