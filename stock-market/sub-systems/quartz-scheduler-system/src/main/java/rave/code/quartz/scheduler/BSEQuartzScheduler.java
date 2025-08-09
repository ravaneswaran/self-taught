package rave.code.quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSETopDividendJob;
import rave.code.quartz.job.moneycontrol.trading.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class BSEQuartzScheduler extends AbstractQuartzScheduler{

    public static final Logger LOGGER = Logger.getLogger(BSEQuartzScheduler.class.toString());

    @Override
    public void scheduleJob() {

        JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                .withIdentity(JobName.BSE_ACTIVE_100_JOB_NAME.get(), Group.TRADING.toString()).storeDurably()
                .build();
        JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                .withIdentity(JobName.BSE_ACTIVE_200_JOB_NAME.get(), Group.TRADING.toString()).storeDurably()
                .build();
        JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                .withIdentity(JobName.BSE_ACTIVE_500_JOB_NAME.get(), Group.TRADING.toString()).storeDurably()
                .build();
        JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                .withIdentity(JobName.BSE_PRICE_SHOCKERS_JOB_NAME.get(), Group.TRADING.toString()).storeDurably()
                .build();
        JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                .withIdentity(JobName.BSE_VOLUME_SHOCKERS_JOB_NAME.get(), Group.TRADING.toString()).storeDurably()
                .build();
        JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                .withIdentity(JobName.BSE_TOP_DIVIDEND_JOB_NAME.get(), Group.INVESTING.toString()).storeDurably()
                .build();
        JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                .withIdentity(JobName.BSE_MID_CAP_GAINER_JOB_NAME.get(), Group.INVESTING.toString()).storeDurably()
                .build();
        JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                .withIdentity(JobName.BSE_SMALL_CAP_GAINER_JOB_NAME.get(), Group.INVESTING.toString()).storeDurably()
                .build();


        Trigger bseActive100JobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_100_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100.get())
                .build();
        Trigger bseActive200JobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_200_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200.get())
                .build();
        Trigger bseActive500JobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_500_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500.get())
                .build();
        Trigger bsePriceShockersJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_PRICE_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER.get())
                .build();
        Trigger bseVolumeShockersJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_VOLUME_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER.get())
                .build();
        Trigger bseTopDividendJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_TOP_DIVIDEND_TRIGGER_NAME.get(), Group.INVESTING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_TOP_DIVIDEND.get())
                .build();
        Trigger bseMidCapGainerJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_MID_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_MID_CAP_GAINER.get())
                .build();
        Trigger bseSmallCapGainerJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_SMALL_CAP_GAINER_TRIGGER_NAME.get(), Group.INVESTING.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_SMALL_CAP_GAINER.get())
                .build();

        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
            scheduler.scheduleJob(bseActive500JobDetail, bseActive500JobTrigger);
            scheduler.scheduleJob(bseActive100JobDetail, bseActive100JobTrigger);

            scheduler.scheduleJob(bsePriceShockersJobDetail, bsePriceShockersJobTrigger);
            scheduler.scheduleJob(bseVolumeShockersJobDetail, bseVolumeShockersJobTrigger);

            scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);

            scheduler.scheduleJob(bseSmallCapGainerJob, bseSmallCapGainerJobTrigger);
            scheduler.scheduleJob(bseMidCapGainerJob, bseMidCapGainerJobTrigger);

            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }
    }

    public static void main(String[] args) {
        BSEQuartzScheduler bseQuartzScheduler = new BSEQuartzScheduler();
        bseQuartzScheduler.scheduleJob();
    }
}
