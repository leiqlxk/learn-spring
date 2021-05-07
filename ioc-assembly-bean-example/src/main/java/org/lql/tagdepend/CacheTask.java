package org.lql.tagdepend;

import java.util.TimerTask;

/**
 * Title: CacheTask <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 23:03 <br>
 */
public class CacheTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("doing clean cache");
    }
}
