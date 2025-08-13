package rave.code.quartz.scheduler.misc;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.misc.StockBaseJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class StockBaseScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(StockBaseScheduler.class.toString());

    public static void main(String[] args) {
        StockBaseScheduler scheduler = new StockBaseScheduler();
        scheduler.scheduleJob();
    }

    @Override
    public void scheduleJob() {
        JobDetail stockBaseJobDetail = newJob(StockBaseJob.class)
                .withIdentity(JobName.BSE_STOCK_BASE_JOB_NAME.get(), Group.MISCELLANEOUS.toString())
                .build();

        Trigger stockBaseJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_STOCK_BASE_TRIGGER_NAME.get(), Group.MISCELLANEOUS.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_4PM_MONDAY_TO_FRIDAY.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(stockBaseJobDetail, stockBaseJobTrigger);

            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException se) {
            LOGGER.log(Level.SEVERE, se.getMessage(), se);
        }
    }
}
