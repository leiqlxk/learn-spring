package org.lql.proxy;

/**
 * Title: MethodPerformance <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 9:39 <br>
 */
public class MethodPerformance {

    private Long begin;

    private Long end;

    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.reset(serviceMethod);
    }

    public void printPerformance() {
        this.end = System.currentTimeMillis();
        long elapse = this.end - this.begin;

        System.out.println(this.serviceMethod + "花费" + elapse + "毫秒。");
    }

    public void reset(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }
}
