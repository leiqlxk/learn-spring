package org.lql.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Title: GreetingAfterAdvice <br>
 * ProjectName: spring-boot-example <br>
 * description: 后置增强 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 20:33 <br>
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    // 在目标类方法执行后执行
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
