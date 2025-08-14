package rave.code.quartz.scheduler;

import org.quartz.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.misc.StockBaseJob;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ScheduleJobsAt_4_PM_FromMondayToFriday extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ScheduleJobsAt_4_PM_FromMondayToFriday.class.toString());

    private Scheduler scheduler;

    public ScheduleJobsAt_4_PM_FromMondayToFriday(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob() {

        JobDetail stockBaseJobDetail = newJob(StockBaseJob.class)
                .withIdentity(JobName.BSE_STOCK_BASE_JOB_NAME.get(), Group.STOCK_BASE.toString())
                .build();

        Trigger stockBaseJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_STOCK_BASE_TRIGGER_NAME.get(), Group.STOCK_BASE.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_4PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.MID.get()).withDescription(TriggerDescription.STOCK_BASE.get())
                .build();

        try {
            this.scheduler.scheduleJob(stockBaseJobDetail, stockBaseJobTrigger);
        } catch (ObjectAlreadyExistsException objectAlreadyExistsException) {
            LOGGER.log(Level.INFO, objectAlreadyExistsException.getMessage());
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage());
        }
    }
}
