package org.lql.basic.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Title: SimpleTimerTask <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/27 16:49 <br>
 */
public class SimpleTimerTask extends TimerTask {
    private int count = 0;

    @Override
    public void run() {
        System.out.println("execute task.");
        // 获取本次安排执行的时间点
        Date exeTime = (new Date(scheduledExecutionTime()));
        System.out.println("本次任务安排执行时间点为：" + exeTime);
        if (++count > 10) {
            cancel();
        }
    }
}
