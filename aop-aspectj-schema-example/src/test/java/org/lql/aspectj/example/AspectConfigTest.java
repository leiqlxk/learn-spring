package org.lql.aspectj.example;

import org.lql.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Title: AspectConfigTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 17:30 <br>
 */
public class AspectConfigTest {

    @Test
    public void config() {
        String configPath = "org/lql/aspectj/example/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) ctx.getBean("target");
        waiter.greetTo("Curry");
        waiter.serveTo("James");
        waiter.toString();
    }
}
