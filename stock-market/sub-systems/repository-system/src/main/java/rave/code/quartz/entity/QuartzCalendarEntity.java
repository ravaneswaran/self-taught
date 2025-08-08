package rave.code.quartz.entity;

import java.sql.Blob;

public class QuartzCalendarEntity {

    private String schedulerName;
    private String calendarName;
    private Blob calendar;

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public Blob getCalendar() {
        return calendar;
    }

    public void setCalendar(Blob calendar) {
        this.calendar = calendar;
    }
}
