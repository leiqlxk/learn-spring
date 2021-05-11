package org.lql.advisor;

/**
 * Title: Waiter <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/11 22:15 <br>
 */
public class Waiter {

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
    }
}
