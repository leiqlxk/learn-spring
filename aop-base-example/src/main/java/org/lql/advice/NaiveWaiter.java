package org.lql.advice;

/**
 * Title: NaiveWaiter <br>
 * ProjectName: learn-spring <br>
 * description: 新手服务员 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 17:26 <br>
 */
public class NaiveWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    public void serverTo(String name) {
        System.out.println("serving " + name + "...");
    }
}
