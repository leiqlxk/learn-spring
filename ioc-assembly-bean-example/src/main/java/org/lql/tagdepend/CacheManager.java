package org.lql.tagdepend;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Title: CacheManager <br>
 * ProjectName: spring-boot-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/7 23:01 <br>
 */
public class CacheManager {

    public CacheManager() {
        Timer timer = new Timer();
        TimerTask cacheTask = new CacheTask();
        timer.schedule(cacheTask, 0, SystemSettings.REFRESH_CYCLE);
    }
}
