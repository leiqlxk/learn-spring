package org.lql.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Title: CalendarExample <br>
 * ProjectName: learn-spring <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/26 15:35 <br>
 */
public class CalendarExample {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = new JobDetail("job1_3", "jGroup1", SimpleJob.class);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 法定节假日是以每年为周期的，所以实用AnnualCalendar
        AnnualCalendar holidays = new AnnualCalendar();

        Calendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH, 5);
        laborDay.add(Calendar.DATE,1);

        Calendar nationalDay = new GregorianCalendar();
        nationalDay.add(Calendar.MONTH, 10);
        nationalDay.add(Calendar.DATE, 1);

        ArrayList<Calendar> calendars = new ArrayList<Calendar>();
        calendars.add(laborDay);
        calendars.add(nationalDay);

        // 排除这两个特殊日期
        holidays.setDaysExcluded(calendars);

        scheduler.addCalendar("holidays", holidays, false, false);

        Date runDate = TriggerUtils.getDateOf(0, 0, 10, 1, 4);
        SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_3", "trigger1", runDate, null, SimpleTrigger.REPEAT_INDEFINITELY, 60L * 60L * 1000L);
        simpleTrigger.setCalendarName("holidays");

        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();

    }
}
