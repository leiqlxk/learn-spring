package org.lql.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: After <br>
 * ProjectName: spring-boot-example <br>
 * description: 后置增强测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 20:34 <br>
 */
public class AfterAdivceTest {

    public static void main(String[] args) {
        // spring容器方式
        String classPath = "org/lql/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(classPath);

        Waiter afterWaiter = (Waiter) ctx.getBean("afterWaiter");
        afterWaiter.greetTo("John");

        // 混合前后增强
        Waiter mixinWaiter = (Waiter) ctx.getBean("mixinWaiter");
        mixinWaiter.greetTo("tim");
    }
}
