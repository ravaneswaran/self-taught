package rave.code.quartz.entity;

public class QuartzSchedulerStateEntity {

    private String schedulerName;
    private String instanceName;
    private long lastCheckInTime;
    private long checkInInterval;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public long getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(long lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public long getCheckInInterval() {
        return checkInInterval;
    }

    public void setCheckInInterval(long checkInInterval) {
        this.checkInInterval = checkInInterval;
    }
}
