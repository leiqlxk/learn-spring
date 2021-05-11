package org.lql.proxy;

/**
 * Title: ForumServiceImpl <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 9:38 <br>
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        // 开始对该方法进行性能监控
//        PerformanceMonitor.begin("org.lql.proxy.ForumServiceImpl.removeTopic");

        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 结束对该方法的性能监控
//        PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        // 开始对该方法进行性能监控
//        PerformanceMonitor.begin("org.lql.proxy.ForumServiceImpl.removeForum");

        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.currentThread().sleep(40);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 结束对该方法的性能监控
//        PerformanceMonitor.end();
    }
}
