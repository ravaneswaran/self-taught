package rave.code.quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.StockBaseJob;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class StockBaseScheduler extends AbstractScheduler{

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
                    .withIdentity("StockBaseJob", "Basing")
                    .build();

            Trigger stockBaseJobTrigger = newTrigger()
                    .withIdentity("StockBaseJobTrigger", "Basing")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .withPriority(1)
                    .build();
            try {
                scheduler.scheduleJob(stockBaseJobDetail, stockBaseJobTrigger);
            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }

            /*try {
                scheduler.shutdown();
            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }*/
        }
    }
}
