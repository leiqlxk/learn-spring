package org.lql.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: BeforeAdviceTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 17:31 <br>
 */
public class BeforeAdviceTest {

    public static void main(String[] args) {
        Waiter waiter = new NaiveWaiter();

        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        // Spring提供的代理工厂
        ProxyFactory factory = new ProxyFactory();

        // 指定对接口进行代理，默认使用jdk动态代理
        factory.setInterfaces(waiter.getClass().getInterfaces());

        // 启动优化，接口也使用cglib
        factory.setOptimize(true);

        // 设置目标类
        factory.setTarget(waiter);

        // 为代理目标添加增强
        factory.addAdvice(beforeAdvice);

        // 生成代理实例
        Waiter proxy = (Waiter) factory.getProxy();
        proxy.greetTo("John");
        proxy.serverTo("Tim");

        // spring容器方式
        String classPath = "org/lql/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(classPath);

        Waiter waiter1 = (Waiter) ctx.getBean("waiter");
        waiter1.greetTo("John");
    }
}
