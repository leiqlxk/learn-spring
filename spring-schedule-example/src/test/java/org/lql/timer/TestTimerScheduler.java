package org.lql.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.Timer;

/**
 * Title: TestTimerScheduler <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/27 17:00 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext-timer.xml"})
public class TestTimerScheduler {

    @Autowired
    private Timer timer;

    @Test
    public void testScheduler() throws Throwable{
        System.out.println("begin...");
        Thread.currentThread().sleep(10000);
        System.out.println("end.");
    }
}
