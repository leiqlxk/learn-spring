package org.lql.basic.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Title: SimpleJob <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 14:54 <br>
 */
public class SimpleJob implements Job {

    // 实现job接口方法
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
        System.out.println(jobCtx.getTrigger().getName() + " triggered.time is " + new Date());
    }
}
