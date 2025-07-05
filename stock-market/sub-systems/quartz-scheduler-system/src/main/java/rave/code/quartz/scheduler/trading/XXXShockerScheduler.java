package rave.code.quartz.scheduler.trading;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.*;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.job.moneycontrol.trading.BSEPriceShockersJob;
import rave.code.quartz.job.moneycontrol.trading.BSEVolumeShockersJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class XXXShockerScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(XXXShockerScheduler.class.toString());

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

            JobDetail bsePriceShockersJobDetail = newJob(BSEPriceShockersJob.class)
                    .withIdentity(JobName.BSE_PRICE_SHOCKERS_JOB_NAME.get(), Group.TRADING.toString())
                    .build();
            JobDetail bseVolumeShockersJobDetail = newJob(BSEVolumeShockersJob.class)
                    .withIdentity(JobName.BSE_VOLUME_SHOCKERS_JOB_NAME.get(), Group.TRADING.toString())
                    .build();

            Trigger bsePriceShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_PRICE_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                    .withPriority(Priorities.MID.get())
                    .build();
            Trigger bseVolumeShockersJobTrigger = newTrigger()
                    .withIdentity(TriggerName.BSE_VOLUME_SHOCKERS_TRIGGER_NAME.get(), Group.TRADING.toString())
                    .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                    .withPriority(Priorities.HIGH.get())
                    .build();

            try {
                scheduler.scheduleJob(bsePriceShockersJobDetail, bsePriceShockersJobTrigger);
                scheduler.scheduleJob(bseVolumeShockersJobDetail, bseVolumeShockersJobTrigger);

            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }

            /*try {
                scheduler.shutdown(true);
            } catch (SchedulerException se) {
                LOGGER.log(Level.SEVERE, se.getMessage(), se);
            }*/
        }
    }

    public static void main(String[] args) {
        XXXShockerScheduler xxxShockerScheduler = new XXXShockerScheduler();
        xxxShockerScheduler.scheduleJob();
    }
}