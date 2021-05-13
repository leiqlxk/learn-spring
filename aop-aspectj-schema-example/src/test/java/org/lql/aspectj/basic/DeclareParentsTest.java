package org.lql.aspectj.basic;

import org.lql.Seller;
import org.lql.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Title: DeclareParentsTest <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:14 <br>
 */
public class DeclareParentsTest {

    @Test
    public void parent() {
        String configPath = "org/lql/aspectj/basic/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Curry");
        Seller seller = (Seller) waiter;
        ((Seller) waiter).sell("Beer", "Curry");
    }
}
