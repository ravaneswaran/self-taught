package rave.code.quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.trading.BSEActive200Job;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Active200JobScheduler extends AbstractScheduler {

    public static final Logger LOGGER = Logger.getLogger(Active200JobScheduler.class.toString());

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

            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity("Active200Job", "Trading")
                    .build();

            Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity("Active200JobTrigger", "Trading")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(2)
                            .repeatForever())
                    .withPriority(10)
                    .build();
            try {
                scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
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
        Active200JobScheduler active200JobScheduler = new Active200JobScheduler();
        active200JobScheduler.scheduleJob();
    }
}
