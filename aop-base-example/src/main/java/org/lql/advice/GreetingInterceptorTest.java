package org.lql.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: GreetingInterceptorTest <br>
 * ProjectName: spring-boot-example <br>
 * description: 环绕增强测试 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:15 <br>
 */
public class GreetingInterceptorTest {

    public static void main(String[] args) {
        // spring容器方式
        String classPath = "org/lql/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(classPath);

        Waiter afterWaiter = (Waiter) ctx.getBean("greetingIntercept");
        afterWaiter.greetTo("John");
    }
}
