package rave.code.quartz.scheduler;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.history.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ScheduleJobsAt_8_45_AM_FromMondayToFriday extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ScheduleJobsAt_4_PM_FromMondayToFriday.class.toString());

    private Scheduler scheduler;

    public ScheduleJobsAt_8_45_AM_FromMondayToFriday(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob() {

        JobDetail bseActive100HistoryJobDetail = newJob(BSEActive100HistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_100_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail bseActive200HistoryJobDetail = newJob(BSEActive200HistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_200_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail bseActive500HistoryJobDetail = newJob(BSEActive500HistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_500_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail bsePriceShockerHistoryJobDetail = newJob(BSEPriceShockersHistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_PRICE_SHOCKER_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();
        JobDetail bseVolumeShockerHistoryJobDetail = newJob(BSEVolumeShockersHistoryJob.class)
                .withIdentity(JobName.BSE_ACTIVE_VOLUME_SHOCKER_HISTORY_JOB_NAME.get(), Group.HISTORY.toString())
                .build();

        Trigger bseActive100HistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_100_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_8_45_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_100_HISTORY.get())
                .build();
        Trigger bseActive200HistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_200_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_8_45_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_200_HISTORY.get())
                .build();
        Trigger bseActive500HistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_ACTIVE_500_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_8_45_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_ACTIVE_500_HISTORY.get())
                .build();
        Trigger bsePriceShockerHistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_PRICE_SHOCKER_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_8_45_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_PRICE_SHOCKER_HISTORY.get())
                .build();
        Trigger bseVolumeShockerHistoryJobDetailTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_VOLUME_SHOCKER_HISTORY_TRIGGER_NAME.get(), Group.HISTORY.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_8_45_AM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.BSE_VOLUME_SHOCKER_HISTORY.get())
                .build();

        try {
            this.scheduler.scheduleJob(bseActive100HistoryJobDetail, bseActive100HistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bseActive200HistoryJobDetail, bseActive200HistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bseActive500HistoryJobDetail, bseActive500HistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bsePriceShockerHistoryJobDetail, bsePriceShockerHistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
        try {
            this.scheduler.scheduleJob(bseVolumeShockerHistoryJobDetail, bseVolumeShockerHistoryJobDetailTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}
