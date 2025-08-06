package rave.code.bse.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rave.code.quartz.scheduler.trading.ActiveXXXScheduler;
import rave.code.quartz.scheduler.trading.XXXShockerScheduler;

@Configuration
public class BSEIndiaActiveXXXConfiguration {

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
}
