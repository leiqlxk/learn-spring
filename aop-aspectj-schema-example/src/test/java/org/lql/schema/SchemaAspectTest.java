package org.lql.schema;

import org.lql.Seller;
import org.lql.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Title: SchemaAspectTest <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 22:17 <br>
 */
public class SchemaAspectTest {

    @Test
    public void schema() {
        String configPath = "org/lql/schema/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        Seller seller = (Seller) ctx.getBean("seller");
//		naiveWaiter.greetTo("John");
//		naughtyWaiter.greetTo("Tom");

        //后置增强
//		((SmartSeller)seller).sell("Beer","John");

        //环境增强
//		naiveWaiter.serveTo("John");

        //抛出异常增强
//		((SmartSeller)seller).checkBill(1);

        //final增强
//		naiveWaiter.greetTo("John");

        //引入增强
//		((Seller)naiveWaiter).sell("Beer","John");
//		((NaiveWaiter)naiveWaiter).smile("John", 2);

        //advisor
        naiveWaiter.greetTo("John");
    }
}
