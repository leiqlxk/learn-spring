package org.lql.advisor;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Title: GreetingComposablePointcut <br>
 * ProjectName: learn-spring <br>
 * description: 复合切点 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 13:21 <br>
 */
public class GreetingComposablePointcut {

    public Pointcut getIntersectionPointcut() {
        // 创建一个复合切点
        ComposablePointcut cp = new ComposablePointcut();

        // 创建一个流程切点
        Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class, "service");

        // 创建一个方法名切点
        NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
        pt2.addMethodName("greeTo");

        // 将两个切点进行交集操作
        return cp.intersection(pt1).intersection((MethodMatcher) pt2);
    }
}
