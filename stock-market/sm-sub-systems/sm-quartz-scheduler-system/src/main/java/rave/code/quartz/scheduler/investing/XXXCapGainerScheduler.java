package rave.code.quartz.scheduler.investing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class XXXCapGainerScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(XXXCapGainerScheduler.class.toString());

    public static void main(String[] args) {
        XXXCapGainerScheduler xxxCapGainerScheduler = new XXXCapGainerScheduler();
        xxxCapGainerScheduler.scheduleJob();
    }

    @Override
    public void scheduleJob() {

        JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                .withIdentity(JobName.BSE_MID_CAP_GAINER_JOB_NAME.get(), Group.INVESTING.toString()).storeDurably()
                .build();
        JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                .withIdentity(JobName.BSE_SMALL_CAP_GAINER_JOB_NAME.get(), Group.INVESTING.toString()).storeDurably()
                .build();

        Trigger bseMidCapGainerJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_MID_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        Trigger bseSmallCapGainerJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_SMALL_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.LOW.get())
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(bseSmallCapGainerJob, bseSmallCapGainerJobTrigger);
            scheduler.scheduleJob(bseMidCapGainerJob, bseMidCapGainerJobTrigger);

            LOGGER.log(Level.INFO, "Starting XXXCapGainerScheduler scheduler....");
            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }
    }
}