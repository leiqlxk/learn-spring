package org.lql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * Title: TestTopicDao <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 16:46 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Rollback
@Transactional
public class TestTopicDao extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private TopicDao topicDao;

    @Test
    public void testGetReplyRate() {
        double rate = topicDao.getReplyRate(2);
        System.out.println("rate is:" + rate);
    }

    @Test
    public void testGetUserTopicNum() throws Throwable {
        int num = topicDao.getUserTopicNum(1);
        System.out.println("num is:" + num);
    }
}
