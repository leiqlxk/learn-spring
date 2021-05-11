package org.lql.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.lql.proxy.PerformanceMonitor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Title: ControllablePerformanceMonitor <br>
 * ProjectName: spring-boot-example <br>
 * description: 引介增强 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 21:38 <br>
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    // 拦截方法
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        Object object = null;

        // 对于支持性能监视可控代理，通过判断其状态决定是否开启性能监控
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            object = super.invoke(mi);
            PerformanceMonitor.end();
        }else {
            object = super.invoke(mi);
        }
        return object;
    }
}
