package org.lql.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: AopTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 15:15 <br>
 */
public class AopTest {

    public static void main(String[] args) {
        String config = "org/lql/aop/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        Waiter waiter = (Waiter) ctx.getBean("waiter", Waiter.class);
        waiter.serveTo("Curry");
    }
}
