package org.lql.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Title: TransactionManager <br>
 * ProjectName: spring-boot-example <br>
 * description: 异常抛出增强 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:19 <br>
 */
public class TransactionManager implements ThrowsAdvice {

    // 定义增强，在ThrowsAdvice异常排除增强接口中没有定义任何方法，它是一个标签接口，在运行期Spring使用反射机制自行判断
    // 方法名必须为afterThrowing
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("---------------");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常：" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }
}
