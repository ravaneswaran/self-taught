package rave.code;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.moneycontrol.bse.quartz.job.history.MoneyControlBSEActive100HistoryJob;
import rave.code.moneycontrol.bse.quartz.job.history.MoneyControlBSEActive200HistoryJob;
import rave.code.moneycontrol.bse.quartz.job.history.MoneyControlBSEActive500HistoryJob;
import rave.code.moneycontrol.bse.quartz.job.history.MoneyControlBSEPriceShockersHistoryJob;
import rave.code.moneycontrol.bse.quartz.job.trading.MoneyControlBSEActive100Job;
import rave.code.moneycontrol.bse.quartz.job.trading.MoneyControlBSEActive200Job;
import rave.code.moneycontrol.bse.quartz.job.trading.MoneyControlBSEActive500Job;
import rave.code.moneycontrol.bse.quartz.job.trading.MoneyControlPriceShockersJob;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200HistoryEntity;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Hello world!
 */
public class QuartzMainScheduler {

    public static final Logger LOGGER = Logger.getLogger(QuartzMainScheduler.class.toString());

    public void scheduleTradingJobs(){

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

    public void scheduleMoveToHistoryJobs(){
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

            JobDetail active100HistoryJobDetail = newJob(MoneyControlBSEActive100HistoryJob.class)
                    .withIdentity("Active100HistoryJob", "History")
                    .build();
            JobDetail active200HistoryJobDetail = newJob(MoneyControlBSEActive200HistoryJob.class)
                    .withIdentity("Active200HistoryJob", "History")
                    .build();
            JobDetail active500HistoryJobDetail = newJob(MoneyControlBSEActive500HistoryJob.class)
                    .withIdentity("Active500HistoryJob", "History")
                    .build();
            JobDetail priceShockersHistoryJobDetail = newJob(MoneyControlBSEPriceShockersHistoryJob.class)
                    .withIdentity("PriceShockersHistoryJob", "History")
                    .build();

            Trigger active100HistoryJobTrigger = newTrigger()
                    .withIdentity("Active100HistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger active200HistoryJobTrigger = newTrigger()
                    .withIdentity("Active200HistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger active500HistoryJobTrigger = newTrigger()
                    .withIdentity("Active500HistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger priceShockersHistoryJobTrigger = newTrigger()
                    .withIdentity("PriceShockersHistoryJobTrigger", "History")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();

            try {
                scheduler.scheduleJob(active100HistoryJobDetail, active100HistoryJobTrigger);
                scheduler.scheduleJob(active200HistoryJobDetail, active200HistoryJobTrigger);
                scheduler.scheduleJob(active500HistoryJobDetail, active500HistoryJobTrigger);
                scheduler.scheduleJob(priceShockersHistoryJobDetail, priceShockersHistoryJobTrigger);
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
        QuartzMainScheduler quartzMainScheduler = new QuartzMainScheduler();

        quartzMainScheduler.scheduleMoveToHistoryJobs();
        quartzMainScheduler.scheduleTradingJobs();
    }
}
