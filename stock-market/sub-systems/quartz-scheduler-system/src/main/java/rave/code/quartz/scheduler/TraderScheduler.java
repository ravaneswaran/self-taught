package rave.code.quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.history.BSEActive100HistoryJob;
import rave.code.quartz.job.moneycontrol.history.BSEActive200HistoryJob;
import rave.code.quartz.job.moneycontrol.history.BSEActive500HistoryJob;
import rave.code.quartz.job.moneycontrol.history.BSEPriceShockersHistoryJob;
import rave.code.quartz.job.moneycontrol.trading.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Hello world!
 */
public class TraderScheduler {

    public static final Logger LOGGER = Logger.getLogger(TraderScheduler.class.toString());

    public static final int RUN_INTERVAL = 3;

    public static void main(String[] args) {
        TraderScheduler traderScheduler = new TraderScheduler();
        //traderScheduler.scheduleMoveToHistoryJobs();
        traderScheduler.scheduleTradingJobs();
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

            JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                    .withIdentity("Active100Job", "Trading")
                    .build();
            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity("Active200Job", "Trading")
                    .build();
            JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                    .withIdentity("Active500Job", "Trading")
                    .build();
            JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                    .withIdentity("PriceShockersJob", "Trading")
                    .build();
            JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                    .withIdentity("VolumeShockersJob", "Trading")
                    .build();

            Trigger bseActive100JobTrigger = newTrigger()
                    .withIdentity("Active100JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(TraderScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(3)
                    .build();
            Trigger bsePriceShockersJobTrigger = newTrigger()
                    .withIdentity("PriceShockersJobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(TraderScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(5)
                    .build();
            Trigger bseVolumeShockersJobTrigger = newTrigger()
                    .withIdentity("VolumeShockersJobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(TraderScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(5)
                    .build();
            Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity("Active200JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(TraderScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(2)
                    .build();
            Trigger bseActive500JobTrigger = newTrigger()
                    .withIdentity("Active500JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(TraderScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(1)
                    .build();
            try {
                scheduler.scheduleJob(bseActive100JobDetail, bseActive100JobTrigger);
                scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
                scheduler.scheduleJob(bseActive500JobDetail, bseActive500JobTrigger);
                scheduler.scheduleJob(bsePriceShockersJobDetail, bsePriceShockersJobTrigger);
                scheduler.scheduleJob(bseVolumeShockersJobDetail, bseVolumeShockersJobTrigger);
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

    public void scheduleMoveToHistoryJobs() {
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

            JobDetail bseActive100HistoryJobDetail = newJob(BSEActive100HistoryJob.class)
                    .withIdentity("Active100HistoryJob", "History")
                    .build();
            JobDetail bseActive200HistoryJobDetail = newJob(BSEActive200HistoryJob.class)
                    .withIdentity("Active200HistoryJob", "History")
                    .build();
            JobDetail bseActive500HistoryJobDetail = newJob(BSEActive500HistoryJob.class)
                    .withIdentity("Active500HistoryJob", "History")
                    .build();
            JobDetail bsePriceShockersHistoryJobDetail = newJob(BSEPriceShockersHistoryJob.class)
                    .withIdentity("PriceShockersHistoryJob", "History")
                    .build();

            Trigger bseActive100HistoryJobTrigger = newTrigger()
                    .withIdentity("Active100HistoryJobTrigger", "History")
                    .startNow()
                    .build();
            Trigger bseActive200HistoryJobTrigger = newTrigger()
                    .withIdentity("Active200HistoryJobTrigger", "History")
                    .startNow()
                    .build();
            Trigger bseActive500HistoryJobTrigger = newTrigger()
                    .withIdentity("Active500HistoryJobTrigger", "History")
                    .startNow()
                    .build();
            Trigger bsePriceShockersHistoryJobTrigger = newTrigger()
                    .withIdentity("PriceShockersHistoryJobTrigger", "History")
                    .startNow()
                    .build();

            try {
                scheduler.scheduleJob(bseActive100HistoryJobDetail, bseActive100HistoryJobTrigger);
                scheduler.scheduleJob(bseActive200HistoryJobDetail, bseActive200HistoryJobTrigger);
                scheduler.scheduleJob(bseActive500HistoryJobDetail, bseActive500HistoryJobTrigger);
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
