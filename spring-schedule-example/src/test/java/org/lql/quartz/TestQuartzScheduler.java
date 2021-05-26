package org.lql.quartz;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Title: TestQuartzScheduler <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 17:28 <br>
 */
@ContextConfiguration(locations = {"classpath:applicationContext-quartz.xml"})
public class TestQuartzScheduler extends AbstractTestNGSpringContextTests {

    @Autowired
    private Scheduler scheduler;

    @Test
    public void testScheduler() throws Throwable {
        System.out.println("begin.....");
        scheduler.start();
        Thread.currentThread().sleep(10000);
        System.out.println("end.");
    }
}
