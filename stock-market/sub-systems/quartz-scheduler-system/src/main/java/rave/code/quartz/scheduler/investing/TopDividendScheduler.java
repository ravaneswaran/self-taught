package rave.code.quartz.scheduler.investing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.Group;
import rave.code.quartz.job.moneycontrol.investing.BSETopDividendJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;
import rave.code.quartz.enums.CronExpression;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TopDividendScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(TopDividendScheduler.class.toString());

    public static void main(String[] args) {
        TopDividendScheduler topDividendScheduler = new TopDividendScheduler();
        topDividendScheduler.scheduleJob();
    }

    @Override
    public void scheduleJob() {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }

        if (null != scheduler) {
            try {
                scheduler.start();
            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }

            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity("BSETopDividend", Group.INVESTING.toString())
                    .build();

            Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity("BSETopDividend", Group.INVESTING.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5_MINUTE_ON_ALL_DAYS.toString()))
                    .withPriority(AbstractQuartzScheduler.HIGH_PRIORITY)
                    .build();

            try {
                scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);

            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }

            try {
                scheduler.shutdown(true);
            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }
        }
    }
}