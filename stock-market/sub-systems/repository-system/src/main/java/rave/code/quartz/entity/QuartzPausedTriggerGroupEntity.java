package rave.code.quartz.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rave.code.quartz.entity.id.QuartzPausedTriggerGroupId;

@Entity
@Table(name = "QUARTZ_PAUSED_TRIGGER_GRPS")
public class QuartzPausedTriggerGroupEntity {

    @EmbeddedId
    private QuartzPausedTriggerGroupId quartzPausedTriggerGroupId;

    public QuartzPausedTriggerGroupId getQuartzPausedTriggerGroupId() {
        return quartzPausedTriggerGroupId;
    }

    public void setQuartzPausedTriggerGroupId(QuartzPausedTriggerGroupId quartzPausedTriggerGroupId) {
        this.quartzPausedTriggerGroupId = quartzPausedTriggerGroupId;
    }
}
