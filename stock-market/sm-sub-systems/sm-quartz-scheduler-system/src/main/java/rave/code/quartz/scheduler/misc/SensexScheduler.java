package rave.code.quartz.scheduler.misc;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.enums.CronExpression;
import rave.code.quartz.enums.*;
import rave.code.quartz.job.moneycontrol.misc.BSESensexJob;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SensexScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(SensexScheduler.class.toString());

    public static void main(String[] args) {
        SensexScheduler scheduler = new SensexScheduler();
        scheduler.scheduleJob();
    }

    @Override
    public void scheduleJob() {
        JobDetail sensexJobDetail = newJob(BSESensexJob.class)
                .withIdentity(JobName.BSE_SENSEX_JOB_NAME.get(), Group.MISCELLANEOUS.toString())
                .build();

        Trigger sensexJobTrigger = newTrigger()
                .withIdentity(TriggerName.BSE_SENSEX_TRIGGER_NAME.get(), Group.MISCELLANEOUS.toString())
                .withSchedule(CronScheduleBuilder.cronSchedule(CronExpression.EVERY_5TH_MINUTE_OF_THE_CLOCK_ON_ALL_DAYS.toString()))
                .withPriority(Priorities.HIGH.get())
                .build();
        try {

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(sensexJobDetail, sensexJobTrigger);

            scheduler.start();
            //scheduler.shutdown(true);
        } catch (SchedulerException schedulerException) {
            LOGGER.log(Level.SEVERE, schedulerException.getMessage(), schedulerException);
        }
    }
}