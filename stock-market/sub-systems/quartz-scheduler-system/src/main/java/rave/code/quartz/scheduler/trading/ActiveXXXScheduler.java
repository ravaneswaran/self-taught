package rave.code.quartz.scheduler.trading;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.quartz.job.moneycontrol.trading.BSEActive100Job;
import rave.code.quartz.job.moneycontrol.trading.BSEActive200Job;
import rave.code.quartz.job.moneycontrol.trading.BSEActive500Job;
import rave.code.quartz.scheduler.AbstractQuartzScheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class ActiveXXXScheduler extends AbstractQuartzScheduler {

    public static final Logger LOGGER = Logger.getLogger(ActiveXXXScheduler.class.toString());

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

            JobDetail bseActive100JobDetail = newJob(BSEActive100Job.class)
                    .withIdentity("Active100Job", AbstractQuartzScheduler.TRADING_GROUP)
                    .build();
            JobDetail bseActive200JobDetail = newJob(BSEActive200Job.class)
                    .withIdentity("Active200Job", AbstractQuartzScheduler.TRADING_GROUP)
                    .build();
            JobDetail bseActive500JobDetail = newJob(BSEActive500Job.class)
                    .withIdentity("Active500Job", AbstractQuartzScheduler.TRADING_GROUP)
                    .build();

            Trigger bseActive100JobTrigger = newTrigger()
                    .withIdentity("Active100JobTrigger", AbstractQuartzScheduler.TRADING_GROUP)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(AbstractQuartzScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(AbstractQuartzScheduler.LOW_PRIORITY)
                    .build();
            Trigger bseActive200JobTrigger = newTrigger()
                    .withIdentity("Active200JobTrigger", AbstractQuartzScheduler.TRADING_GROUP)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(AbstractQuartzScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(AbstractQuartzScheduler.MID_PRIORITY)
                    .build();
            Trigger bseActive500JobTrigger = newTrigger()
                    .withIdentity("Active500JobTrigger", AbstractQuartzScheduler.TRADING_GROUP)
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInMinutes(AbstractQuartzScheduler.RUN_INTERVAL)
                            .repeatForever())
                    .withPriority(AbstractQuartzScheduler.TOP_PRIORITY)
                    .build();

            try {
                scheduler.scheduleJob(bseActive100JobDetail, bseActive100JobTrigger);
                scheduler.scheduleJob(bseActive200JobDetail, bseActive200JobTrigger);
                scheduler.scheduleJob(bseActive500JobDetail, bseActive500JobTrigger);
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

    public static void main(String[] args) {
        ActiveXXXScheduler activeXXXScheduler = new ActiveXXXScheduler();
        activeXXXScheduler.scheduleJob();
    }
}
