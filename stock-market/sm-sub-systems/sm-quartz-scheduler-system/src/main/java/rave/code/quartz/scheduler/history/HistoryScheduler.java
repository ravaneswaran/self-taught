package rave.code.quartz.scheduler.history;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.history.*;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class HistoryScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(HistoryScheduler.class.toString());

    public static void main(String[] args) {
        HistoryScheduler historyScheduler = new HistoryScheduler();
        historyScheduler.scheduleJob();
    }

    @Override
    public void scheduleJob() {

        JobDetail active100HistoryJobDetail = newJob(BSEActive100HistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_100_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail active200HistoryJobDetail = newJob(BSEActive200HistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_200_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail active500HistoryJobDetail = newJob(BSEActive500HistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_500_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail priceShockerHistoryJobDetail = newJob(BSEPriceShockersHistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_PRICE_SHOCKER_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail volumeShockerHistoryJobDetail = newJob(BSEVolumeShockersHistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_VOLUME_SHOCKER_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();

        Trigger active100HistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_100_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        Trigger active200HistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_200_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        Trigger active500HistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_500_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        Trigger priceShockerHistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_PRICE_SHOCKER_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        Trigger volumeShockerHistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_VOLUME_SHOCKER_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();

        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(active100HistoryJobDetail, active100HistoryJobDetailTrigger);
            scheduler.scheduleJob(active200HistoryJobDetail, active200HistoryJobDetailTrigger);
            scheduler.scheduleJob(active500HistoryJobDetail, active500HistoryJobDetailTrigger);
            scheduler.scheduleJob(priceShockerHistoryJobDetail, priceShockerHistoryJobDetailTrigger);
            scheduler.scheduleJob(volumeShockerHistoryJobDetail, volumeShockerHistoryJobDetailTrigger);

            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }
    }
}