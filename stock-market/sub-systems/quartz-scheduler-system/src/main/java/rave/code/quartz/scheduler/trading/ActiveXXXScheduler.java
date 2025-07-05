package rave.code.quartz.scheduler.trading;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.job.moneycontrol.trading.BSEActive100Job;
import rave.code.quartz.job.moneycontrol.trading.BSEActive200Job;
import rave.code.quartz.job.moneycontrol.trading.BSEActive500Job;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ActiveXXXScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ActiveXXXScheduler.class.toString());

    @Override
    public void scheduleJob() {

        JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                .withIdentity(JobName.BSE_ACTIVE_100_JOB_NAME.get(), Group.TRADING.toString())
                .build();
        JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                .withIdentity(JobName.BSE_ACTIVE_200_JOB_NAME.get(), Group.TRADING.toString())
                .build();
        JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                .withIdentity(JobName.BSE_ACTIVE_500_JOB_NAME.get(), Group.TRADING.toString())
                .build();

        Trigger bseActive100JobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_100_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.LOW.get())
                .build();
        Trigger bseActive200JobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_200_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get())
                .build();
        Trigger bseActive500JobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_500_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
            scheduler.scheduleJob(bseActive500JobDetail, bseActive500JobTrigger);
            scheduler.scheduleJob(bseActive100JobDetail, bseActive100JobTrigger);

            scheduler.start();

            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }

    }

    public static void main(String[] args) {
        ActiveXXXScheduler activeXXXScheduler = new ActiveXXXScheduler();
        activeXXXScheduler.scheduleJob();
    }
}
