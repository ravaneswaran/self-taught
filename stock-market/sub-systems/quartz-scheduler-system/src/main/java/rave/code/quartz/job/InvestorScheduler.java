package rave.code.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSETopDividendJob;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class InvestorScheduler {

    public static final Logger LOGGER = Logger.getLogger(InvestorScheduler.class.toString());

    public void scheduleInvestingJobs() {

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

            JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                    .withIdentity("BSEMidCapGainer", "Investing")
                    .build();
            JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                    .withIdentity("BSESmallCapGainer", "Investing")
                    .build();
            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity("BSETopDividend", "Investing")
                    .build();


            Trigger bseMidCapGainerJobTrigger = newTrigger()
                    .withIdentity("BSEMidCapGainer", "Investing")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger bseSmallCapGainerJobTrigger = newTrigger()
                    .withIdentity("BSESmallCapGainer", "Investing")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();
            Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity("BSETopDividend", "Investing")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(5)
                            .repeatForever())
                    .build();


            try {
                scheduler.scheduleJob(bseSmallCapGainerJob, bseSmallCapGainerJobTrigger);
                scheduler.scheduleJob(bseMidCapGainerJob, bseMidCapGainerJobTrigger);
                scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);
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
        InvestorScheduler investorScheduler = new InvestorScheduler();
        investorScheduler.scheduleInvestingJobs();
    }
}
