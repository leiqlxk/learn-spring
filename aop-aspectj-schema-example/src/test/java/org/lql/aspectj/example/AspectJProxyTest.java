package org.lql.aspectj.example;

import org.lql.NavieWaiter;
import org.lql.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

/**
 * Title: AspectJProxyTest <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 16:45 <br>
 */
public class AspectJProxyTest {

    @Test
    public void proxy() {
        Waiter target = new NavieWaiter();

        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        // 设置目标对象
        aspectJProxyFactory.setTarget(target);
        // 添加切面
        aspectJProxyFactory.addAspect(PreGreetingAspect.class);

        // 生成织入切面的代理对象
        Waiter waiter = aspectJProxyFactory.getProxy();
        waiter.greetTo("Curry");
        waiter.serveTo("James");
    }
}
