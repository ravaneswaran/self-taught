package rave.code.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.BSESensexJob;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class SensexScheduler {

    public static final Logger LOGGER = Logger.getLogger(TraderScheduler.class.toString());

    public static void main(String[] args) {
        SensexScheduler sensexScheduler = new SensexScheduler();
        //sensexScheduler.scheduleMoveToHistoryJobs();
        sensexScheduler.scheduleTradingJobs();
    }

    public void scheduleTradingJobs() {
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

            JobDetail bseSensexJobDetail = newJob(BSESensexJob.class)
                    .withIdentity("SensexJob", "Sensex")
                    .build();


            Trigger bseSensexJobTrigger = newTrigger()
                    .withIdentity("SensexJobTrigger", "Sensex")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .withPriority(1)
                    .build();


            try {
                scheduler.scheduleJob(bseSensexJobDetail, bseSensexJobTrigger);
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
