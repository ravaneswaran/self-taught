package rave.code.bse.web;

import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.quartz.scheduler.investing.TopDividendScheduler;
import rave.code.quartz.scheduler.investing.XXXCapGainerScheduler;
import rave.code.quartz.scheduler.trading.ActiveXXXScheduler;
import rave.code.quartz.scheduler.trading.XXXShockerScheduler;

@Configuration
public class BSEIndiaQuartzJobConfiguration{

    @Bean
    public int scheduleActiveXXXJobs() {
        new ActiveXXXScheduler().scheduleJob();
        return 0;
    }

    @Bean
    public int scheduleXXXShockerJobs(){
        new XXXShockerScheduler().scheduleJob();
        return 0;
    }

    /*@Bean
    public int scheduleXXXCapGainerJobs(){
        new XXXCapGainerScheduler().scheduleJob();
        return 0;
    }

    @Bean
    public int scheduleTopDividendJob(){
        new TopDividendScheduler().scheduleJob();
        return 0;
    }*/
}
