package org.lql.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Title: SimpleTriggerRunner <br>
 * ProjectName: learn-spring <br>
 * description: 使用simpleTrigger对SimpleJob进行调度 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 14:56 <br>
 */
public class SimpleTriggerRunner {

    public static void main(String[] args) throws SchedulerException {

        // 创建一个JobDetail实例，指定SimpleJob
        JobDetail jobDetail = new JobDetail("job1_1", "jgroup1", SimpleJob.class);

        // 通过SimpleTrigger定义调度规则：马上启动，每2秒运行一次，共运行100次
        SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");
        simpleTrigger.setStartTime(new Date());
        simpleTrigger.setRepeatInterval(2000);
        simpleTrigger.setRepeatCount(100);

        // 通过SchedulerFactory获取一个调度器实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 注册并进行调度
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        // 调度启动
        scheduler.start();
    }
}
