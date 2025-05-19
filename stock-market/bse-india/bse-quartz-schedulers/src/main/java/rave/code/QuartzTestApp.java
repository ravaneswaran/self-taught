package rave.code;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import rave.code.moneycontrol.bse.quartz.job.TestJob;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class QuartzTestApp {

    public static final Logger LOGGER = Logger.getLogger(QuartzTestApp.class.toString());

    public static void main(String[] args) {
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //Create JobDetail object specifying which Job you want to execute
            JobDetail jobDetail  = JobBuilder.newJob(TestJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            //Associate Trigger to the Job
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    // 0 0/2 8-17 * * ?
                    .withSchedule(CronScheduleBuilder.cronSchedule("* */5 * * * ?"))
                    .forJob("myJob", "group1")
                    .build();

            //Pass JobDetail and trigger dependencies to schedular
            scheduler.scheduleJob(jobDetail,trigger);

            // and start it off
            scheduler.start();

            try {
                Thread.sleep(60000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            scheduler.shutdown();
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

}
