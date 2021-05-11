package org.lql.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Title: PerformanceHandler <br>
 * ProjectName: learn-spring <br>
 * description: jdk动态代理横切面 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 14:59 <br>
 */
public class PerformanceHandler implements InvocationHandler {

    private Object target;

    // 将目标对象注入进来
    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());

        // 通过反射调用目标对象的业务方法
        Object obj = method.invoke(target, args);

        PerformanceMonitor.end();
        return obj;
    }
}
