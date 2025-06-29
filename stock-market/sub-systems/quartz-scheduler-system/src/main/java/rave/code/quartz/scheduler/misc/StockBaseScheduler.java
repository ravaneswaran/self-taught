package rave.code.quartz.scheduler.misc;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.Group;
import rave.code.quartz.job.moneycontrol.misc.StockBaseJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;
import rave.code.quartz.enums.CronExpression;

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

            JobDetail stockBaseJobDetail = newJob(StockBaseJob.class)
                    .withIdentity("StockBaseJob", Group.MISCELLANEOUS.toString())
                    .build();

            Trigger stockBaseJobTrigger = newTrigger()
                    .withIdentity("StockBaseJobTrigger", Group.MISCELLANEOUS.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.AT_4PM_MONDAY_TO_FRIDAY.toString()))
                    .withPriority(AbstractQuartzScheduler.HIGH_PRIORITY)
                    .build();
            try {
                scheduler.scheduleJob(stockBaseJobDetail, stockBaseJobTrigger);
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
