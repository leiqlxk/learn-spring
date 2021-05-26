package org.lql.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * Title: CronTriggerRunner <br>
 * ProjectName: learn-spring <br>
 * description: cron表达式触发器执行任务 <br>
 * cron表达式：其由6或7个空格分隔的时间字段组成
 *      秒（0-59）：支持的符号为（, * - /）
 *      分（0-59）：支持的符号为（, * - /）
 *      时（0-23）：支持的符号为（, * - /）
 *      日期（1-31）：支持的符号为（, * - / ? L W C）
 *      月（1-12）：支持的符号（, * - /）
 *      星期（1-7）：支持的符号为（, * - / ? L C #）
 *      年（可选：空值 1970-2099）：（, * - /）
 *
 * 通配符：
 *      *：表示对应时间域内的每一个时刻
 *      ?：该字符只在日期和星期字段中使用，它通常指定为无意义的值，相当于占位符
 *      -：表达一个范围
 *      ，：表示一个列表值
 *      /：x/y表达一个等步长序列，x为起始值，y为增量步长值
 *      L：代表Last的意思，在日期中表示这个月的最后一天，在星期中则表示星期六，但如果在星期里且前面有数字N，则表示这个月的最后N天如6L表示这个月的最后一个星期五
 *      W：对前导日期的修饰，表示离该日期最近的工作日
 *      LW组合：表示当月最后一个工作日
 *      #：表示当月的某个工作日，如6#3表示当月的第三个星期五
 *      C：代表Calendar的意思，它的意思是计划所关联的日期，如果日期没有被关联，则相当于日历中的所有日期，如5C在日期字段中相当于5日以后的那一天，1C在星期字段中相当于星期日之后的第一天
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 15:10 <br>
 */
public class CronTriggerRunner {

    public static void main(String[] args) throws ParseException, SchedulerException {

        JobDetail jobDetail = new JobDetail("job1_2", "jGroup1", SimpleJob.class);

        CronTrigger cronTrigger = new CronTrigger("trigger1_2", "tgroup1");
        CronExpression cronExpression = new CronExpression("0/5 * * * * ?");
        cronTrigger.setCronExpression(cronExpression);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
