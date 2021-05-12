package org.lql.autoproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: AutoProxyTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 14:34 <br>
 */
public class AutoProxyTest {

    public static void main(String[] args) {
        String configPath = "org/lql/autoproxy/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = ctx.getBean("waiter", Waiter.class);
        Seller seller = ctx.getBean("seller", Seller.class);

        waiter.greetTo("James");
        waiter.greetTo("Curry");

    }
}
