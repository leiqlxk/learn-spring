package org.lql.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Title: JDBCJobStoreRunner <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 16:17 <br>
 */
public class JDBCJobStoreRunner {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();

        // 获取调度器中所有的触发器组
        String[] triggerGroups = scheduler.getTriggerGroupNames();

        // 重新恢复在tgroup1组中名为trigger1_1的触发器的运行
        for (int i = 0; i < triggerGroups.length; i++) {
            String[] triggers = scheduler.getTriggerNames(triggerGroups[i]);
            for (int j = 0; j < triggers.length; j++) {
                Trigger trigger = scheduler.getTrigger(triggers[j], triggerGroups[i]);
                if (trigger instanceof SimpleTrigger && trigger.getFullName().equals("tgroup1.trigger1_1")) {
                    scheduler.rescheduleJob(triggers[j], triggerGroups[i], trigger);
                }
            }
        }

        scheduler.start();
    }
}
