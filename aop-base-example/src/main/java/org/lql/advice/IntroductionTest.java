package org.lql.advice;

import org.lql.proxy.ForumServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: IntroductionTest <br>
 * ProjectName: spring-boot-example <br>
 * description: 引介增强测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:53 <br>
 */
public class IntroductionTest {

    public static void main(String[] args) {
        // spring容器方式
        String classPath = "org/lql/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(classPath);

        ForumServiceImpl forumServiceImpl = (ForumServiceImpl) ctx.getBean("forumServiceImpl");

        // 默认情况下，未开启性能监视功能
        forumServiceImpl.removeForum(10);
        forumServiceImpl.removeTopic(1024);

        // 开启性能监视功能
        Monitorable monitorable = (Monitorable) forumServiceImpl;
        monitorable.setMonitorActive(true);

        // 在性能监视功能开启的情况下，再次调用业务
        forumServiceImpl.removeForum(10);
        forumServiceImpl.removeTopic(1024);
    }
}
