package org.lql;

import org.lql.anno.NeedTest;

/**
 * Title: Waiter <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/13 16:29 <br>
 */
public interface Waiter {

    public void greetTo(String clientName);

    public void serveTo(String clientName);
}
