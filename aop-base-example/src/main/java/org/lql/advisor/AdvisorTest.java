package org.lql.advisor;

import org.lql.advice.Monitorable;
import org.lql.proxy.ForumService;
import org.lql.proxy.ForumServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: StaticMethodTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 10:46 <br>
 */
public class AdvisorTest {

    public static void main(String[] args) {
        String configPath = "org/lql/advisor/beans.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        // 静态方法名匹配
        Waiter waiter = ctx.getBean("waiter", Waiter.class);
        Seller seller = ctx.getBean("seller", Seller.class);

        waiter.greetTo("John");
        seller.greetTo("Tim");

        System.out.println("---------------");
        // 正则表达式匹配
        Waiter waiter1 = ctx.getBean("waiter1", Waiter.class);
        waiter1.greetTo("Green");
        waiter1.serveTo("Curry");

        System.out.println("---------------");
        // 流程切面
        Waiter waiter2 = ctx.getBean("waiter2", Waiter.class);
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter2);
        waiterDelegate.service("James");

        System.out.println("---------------");
        // 复合切面
        Waiter waiter3 = ctx.getBean("waiter3", Waiter.class);
        WaiterDelegate waiterDelegate1 = new WaiterDelegate();
        waiterDelegate1.setWaiter(waiter3);

        waiter3.greetTo("Tom");
        waiter3.serveTo("Jordan");
        waiterDelegate1.service("Cobe");

        System.out.println("---------------");
        // 引介切面
        ForumServiceImpl forumService = ctx.getBean("forumService", ForumServiceImpl.class);

        forumService.removeTopic(123);

        Monitorable monitorable = (Monitorable)forumService;
        monitorable.setMonitorActive(true);
        forumService.removeTopic(123);
    }
}
