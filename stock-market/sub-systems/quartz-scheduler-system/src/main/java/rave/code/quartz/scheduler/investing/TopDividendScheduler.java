package rave.code.quartz.scheduler.investing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSETopDividendJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class TopDividendScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(TopDividendScheduler.class.toString());

    public static void main(String[] args) {
        TopDividendScheduler topDividendScheduler = new TopDividendScheduler();
        topDividendScheduler.scheduleJob();
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

            JobDetail bseTopDividendJob = newJob(BSETopDividendJob.class)
                    .withIdentity("BSETopDividend", AbstractQuartzScheduler.INVESTING_GROUP)
                    .build();

            Trigger bseTopDividendJobTrigger = newTrigger()
                    .withIdentity("BSETopDividend", AbstractQuartzScheduler.INVESTING_GROUP)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(AbstractQuartzScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(AbstractQuartzScheduler.TOP_PRIORITY)
                    .build();

            try {
                scheduler.scheduleJob(bseTopDividendJob, bseTopDividendJobTrigger);

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