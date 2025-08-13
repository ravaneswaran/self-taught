package rave.code.quartz.scheduler.investing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.investing.BSETopDividendJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

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

        JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                .withIdentity(JobName.BSE_TOP_DIVIDEND_JOB_NAME.get(), Group.INVESTING.toString()).storeDurably()
                .build();

        Trigger bseTopDividendJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_TOP_DIVIDEND_TRIGGER_NAME.get(), Group.INVESTING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();

        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);
            LOGGER.log(Level.INFO, "Starting TopDividendScheduler scheduler....");
            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }
    }
}