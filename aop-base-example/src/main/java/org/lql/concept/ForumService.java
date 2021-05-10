package org.lql.concept;

/**
 * Title: ForumService <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/10 16:51 <br>
 */
public class ForumService {

    private TransactionManager transactionManager;

    private PerformanceMonitor performanceMonitor;

    private TopicDao topicDao;

    private ForumDao forumDao;

    // 以下两个方法中属于业务代码的仅仅只有中间一句，其余皆为重复代码
    // 此类型的重复代码我们无法通过抽取父类来消除
    // AOP另辟蹊径通过横向抽取机制为这类无法通过纵向继承体系进行抽象的重复性代码提供了解决方案
    public void removeTopic(int topicId) {
        performanceMonitor.start();
        transactionManager.beginTransaction();

        topicDao.removeTopic(topicId);

        transactionManager.endTransaction();
        performanceMonitor.end();
    }

    public void createForum(Forum forum) {
        performanceMonitor.start();
        transactionManager.beginTransaction();

        forumDao.create(forum);

        transactionManager.endTransaction();
        performanceMonitor.end();
    }
}
