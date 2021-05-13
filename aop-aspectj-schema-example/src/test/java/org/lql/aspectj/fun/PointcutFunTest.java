package org.lql.aspectj.fun;

import org.lql.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Title: PointcutFunTest <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:26 <br>
 */
public class PointcutFunTest {

    @Test
    public void pointcut() {
        String configPath = "org/lql/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        naiveWaiter.greetTo("Curry");
        naughtyWaiter.greetTo("James");
    }
}
