package rave.code.quartz.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.quartz.entity.id.QuartzTriggerId;

@Entity
@Table(name = "QUARTZ_CRON_TRIGGERS")
public class QuartzCronTriggerEntity {

    @EmbeddedId
    private QuartzTriggerId quartzTriggerId;
    private String cronExpression;
    private String timeZoneId;

    public QuartzTriggerId getQuartzTriggerId() {
        return quartzTriggerId;
    }

    public void setQuartzTriggerId(QuartzTriggerId quartzTriggerId) {
        this.quartzTriggerId = quartzTriggerId;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}
