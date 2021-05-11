package org.lql.proxy;

/**
 * Title: PerformanceMonitor <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 9:38 <br>
 */
public class PerformanceMonitor {

    // 通过一个ThreadLocal保存与调用线程相关的性能监视信息
    // ThreadLocal是将非线程安全类改造为线程安全的法宝。
    private static ThreadLocal<MethodPerformance> performanceThreadLocal = new ThreadLocal<MethodPerformance>();

    // 启动对某一目标方法的性能监视
    public static void begin(String method) {
        System.out.println("begin monitor...");

        MethodPerformance mp = performanceThreadLocal.get();
        if (mp == null) {
            mp = new MethodPerformance(method);
            performanceThreadLocal.set(mp);
        }else {
            mp.reset(method);
        }
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceThreadLocal.get();

        // 打印出方法性能监视的结果信息
        mp.printPerformance();
    }
}
