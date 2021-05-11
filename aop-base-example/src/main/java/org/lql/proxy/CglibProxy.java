package org.lql.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Title: CglibProxy <br>
 * ProjectName: learn-spring <br>
 * description: cglib代理实现类
 * 其通过底层字节码技术，可以为一个类创建子类，在子类中采用方法拦截的技术拦截所有父类方法的调用并顺势织入横切逻辑，因此其没有接口的限制<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 15:25 <br>
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        // 通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    // 拦截父类所有方法的调用，o-目标对象，method-目标对象方法的反射对象，objects-动态入参，methodProxy-代理类实例
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());

        // 通过代理类调用方法
        Object result = methodProxy.invokeSuper(o, objects);

        PerformanceMonitor.end();
        return result;
    }
}
