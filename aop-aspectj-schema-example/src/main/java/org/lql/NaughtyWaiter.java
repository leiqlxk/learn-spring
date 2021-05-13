package org.lql;

import org.lql.Waiter;
import org.lql.anno.NeedTest;

/**
 * Title: NaughtyWaiter <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 21:25 <br>
 */
public class NaughtyWaiter implements Waiter {

    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to "+clientName+"...");
    }

    public void serveTo(String clientName){
        System.out.println("NaughtyWaiter:serving "+clientName+"...");
    }

    public void joke(String clientName,int times){
        System.out.println("NaughtyWaiter:play "+times+" jokes to "+clientName+"...");
    }
}
