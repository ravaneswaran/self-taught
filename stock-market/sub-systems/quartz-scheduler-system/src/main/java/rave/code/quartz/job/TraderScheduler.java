package rave.code.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.history.BSEActive100HistoryJob;
import rave.code.quartz.job.moneycontrol.history.BSEActive200HistoryJob;
import rave.code.quartz.job.moneycontrol.history.BSEActive500HistoryJob;
import rave.code.quartz.job.moneycontrol.history.BSEPriceShockersHistoryJob;
import rave.code.quartz.job.moneycontrol.trading.MoneyControlBSEActive100Job;
import rave.code.quartz.job.moneycontrol.trading.MoneyControlBSEActive200Job;
import rave.code.quartz.job.moneycontrol.trading.MoneyControlBSEActive500Job;
import rave.code.quartz.job.moneycontrol.trading.MoneyControlPriceShockersJob;

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

            JobDetail active100JobDetail = newJob(MoneyControlBSEActive100Job.class)
                    .withIdentity("Active100Job", "Trading")
                    .build();
            JobDetail active200JobDetail = newJob(MoneyControlBSEActive200Job.class)
                    .withIdentity("Active200Job", "Trading")
                    .build();
            JobDetail active500JobDetail = newJob(MoneyControlBSEActive500Job.class)
                    .withIdentity("Active500Job", "Trading")
                    .build();
            JobDetail priceShockersJobDetail = newJob(MoneyControlPriceShockersJob.class)
                    .withIdentity("PriceShockersJob", "Trading")
                    .build();

            Trigger active100JobTrigger = newTrigger()
                    .withIdentity("Active100JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger active200JobTrigger = newTrigger()
                    .withIdentity("Active200JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger active500JobTrigger = newTrigger()
                    .withIdentity("Active500JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger priceShockersJobTrigger = newTrigger()
                    .withIdentity("PriceShockersJobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();

            try {
                scheduler.scheduleJob(active100JobDetail, active100JobTrigger);
                scheduler.scheduleJob(active200JobDetail, active200JobTrigger);
                scheduler.scheduleJob(active500JobDetail, active500JobTrigger);
                scheduler.scheduleJob(priceShockersJobDetail, priceShockersJobTrigger);
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
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger bseActive200HistoryJobTrigger = newTrigger()
                    .withIdentity("Active200HistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger bseActive500HistoryJobTrigger = newTrigger()
                    .withIdentity("Active500HistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger bsePriceShockersHistoryJobTrigger = newTrigger()
                    .withIdentity("PriceShockersHistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();

            try {
                scheduler.scheduleJob(bseActive100HistoryJobDetail, bseActive100HistoryJobTrigger);
                scheduler.scheduleJob(bseActive200HistoryJobDetail, bseActive200HistoryJobTrigger);
                scheduler.scheduleJob(bseActive500HistoryJobDetail, bseActive500HistoryJobTrigger);
                scheduler.scheduleJob(bsePriceShockersHistoryJobDetail, bsePriceShockersHistoryJobTrigger);
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

    public static void main(String[] args) {
        TraderScheduler traderScheduler = new TraderScheduler();
        traderScheduler.scheduleMoveToHistoryJobs();
        traderScheduler.scheduleTradingJobs();
    }
}
