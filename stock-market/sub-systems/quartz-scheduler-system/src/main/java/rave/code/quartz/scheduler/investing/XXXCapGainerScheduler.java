package rave.code.quartz.scheduler.investing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.investing.BSEMidCapGainerJob;
import rave.code.quartz.job.moneycontrol.investing.BSESmallCapGainerJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class XXXCapGainerScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(XXXCapGainerScheduler.class.toString());

    public static void main(String[] args) {
        XXXCapGainerScheduler xxxCapGainerScheduler = new XXXCapGainerScheduler();
        xxxCapGainerScheduler.scheduleJob();
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

            JobDetail bseMidCapGainerJob = newJob(BSEMidCapGainerJob.class)
                    .withIdentity("BSEMidCapGainer", AbstractQuartzScheduler.INVESTING_GROUP)
                    .build();
            JobDetail bseSmallCapGainerJob = newJob(BSESmallCapGainerJob.class)
                    .withIdentity("BSESmallCapGainer", AbstractQuartzScheduler.INVESTING_GROUP)
                    .build();

            Trigger bseMidCapGainerJobTrigger = newTrigger()
                    .withIdentity("BSEMidCapGainer", AbstractQuartzScheduler.INVESTING_GROUP)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(AbstractQuartzScheduler.MID_PRIORITY)
                            .repeatForever())
                    .withPriority(AbstractQuartzScheduler.MID_PRIORITY)
                    .build();
            Trigger bseSmallCapGainerJobTrigger = newTrigger()
                    .withIdentity("BSESmallCapGainer", AbstractQuartzScheduler.INVESTING_GROUP)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(AbstractQuartzScheduler.TOP_PRIORITY)
                            .repeatForever())
                    .withPriority(AbstractQuartzScheduler.TOP_PRIORITY)
                    .build();


            try {
                scheduler.scheduleJob(bseSmallCapGainerJob, bseSmallCapGainerJobTrigger);
                scheduler.scheduleJob(bseMidCapGainerJob, bseMidCapGainerJobTrigger);
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