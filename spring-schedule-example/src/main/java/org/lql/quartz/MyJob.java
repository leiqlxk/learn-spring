package org.lql.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Title: MyJob <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 16:59 <br>
 */
public class MyJob implements Job {
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {

        // 获取JobDetail关联的JobDataMap
        Map dataMap = jobCtx.getJobDetail().getJobDataMap();

        String size = (String) dataMap.get("size");

        ApplicationContext applicationContext = (ApplicationContext) dataMap.get("applicationContext");
        System.out.println(size);
        // 对JobDataMap修改是否会被持久化取决于任务的类型
        dataMap.put("size", size + "0");
    }
}
