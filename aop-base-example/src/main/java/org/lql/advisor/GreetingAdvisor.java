package org.lql.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Title: GreetingAdvisor <br>
 * ProjectName: learn-spring <br>
 * description: 静态方法匹配切面 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 10:31 <br>
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    // 切点方法匹配规则：方法名为greetTo
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    // 切点类匹配规则：为Waiter的类或子类
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
