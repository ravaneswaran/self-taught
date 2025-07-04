package rave.code.quartz.scheduler.trading;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.Group;
import rave.code.quartz.job.moneycontrol.trading.BSEActive100Job;
import rave.code.quartz.job.moneycontrol.trading.BSEActive200Job;
import rave.code.quartz.job.moneycontrol.trading.BSEActive500Job;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;
import rave.code.quartz.enums.CronExpression;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ActiveXXXScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ActiveXXXScheduler.class.toString());

    @Override
    public void scheduleJob() {

        JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                .withIdentity("Active100Job", Group.TRADING.toString())
                .build();
        JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                .withIdentity("Active200Job", Group.TRADING.toString())
                .build();
        JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                .withIdentity("Active500Job", Group.TRADING.toString())
                .build();

        Trigger bseActive100JobTrigger = newTrigger()
                .withIdentity("Active100JobTrigger", Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                //.withPriority(AbstractQuartzScheduler.LOW_PRIORITY)
                .build();
        Trigger bseActive200JobTrigger = newTrigger()
                .withIdentity("Active200JobTrigger", Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                //.withPriority(AbstractQuartzScheduler.MID_PRIORITY)
                .build();
        Trigger bseActive500JobTrigger = newTrigger()
                .withIdentity("Active500JobTrigger", Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                //.withPriority(AbstractQuartzScheduler.HIGH_PRIORITY)
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
