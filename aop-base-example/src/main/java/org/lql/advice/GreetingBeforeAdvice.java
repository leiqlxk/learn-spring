package org.lql.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Title: GreetingBeforeAdvice <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 17:27 <br>
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    // 在目标类方法调用之前执行,method-目标类方法，objects-入参，o-目标类实例
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
