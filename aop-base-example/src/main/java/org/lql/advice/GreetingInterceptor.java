package org.lql.advice;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Title: GreetingInterceptor <br>
 * ProjectName: spring-boot-example <br>
 * description: 环绕增强 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:08 <br>
 */
public class GreetingInterceptor implements MethodInterceptor {

    // 截获目标类方法的执行，并在前后添加横切逻辑
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 获取目标方法入参
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];

        // 在目标方法前调用
        System.out.println("How are you! Mr." + clientName + '.');

        // 通过反射调用目标方法
        Object obj = methodInvocation.proceed();

        // 在目标方法执行后调用
        System.out.println("Please enjoy yourself");
        return obj;
    }

}
