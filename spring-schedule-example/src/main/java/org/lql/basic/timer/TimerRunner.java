package org.lql.basic.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Title: TimerRunner <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/27 16:52 <br>
 */
public class TimerRunner {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new SimpleTimerTask();

        timer.schedule(timerTask, 1000L, 5000L);
    }
}
