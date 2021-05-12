package org.lql.aop;

/**
 * Title: Waiter <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 15:05 <br>
 */
public class Waiter implements BeanSelfProxyAware {
    private Waiter waiter;

    public void setSelfProxy(Object object) {
        this.waiter = (Waiter) object;
    }

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
        this.waiter.greetTo(name);
    }
}
