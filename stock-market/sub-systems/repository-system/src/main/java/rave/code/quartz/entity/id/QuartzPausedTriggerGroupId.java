package rave.code.quartz.entity.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuartzPausedTriggerGroupId implements Serializable {

    private String schedulerName;
    private String triggerGroup;
}
