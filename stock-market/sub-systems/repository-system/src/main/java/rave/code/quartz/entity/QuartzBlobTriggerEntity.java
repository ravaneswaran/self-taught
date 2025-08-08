package rave.code.quartz.entity;

import java.sql.Blob;

public class QuartzBlobTriggerEntity {

    private String schedulerName;
    private String triggerName;
    private String triggerGroup;
    private Blob blobData;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public Blob getBlobData() {
        return blobData;
    }

    public void setBlobData(Blob blobData) {
        this.blobData = blobData;
    }
}
