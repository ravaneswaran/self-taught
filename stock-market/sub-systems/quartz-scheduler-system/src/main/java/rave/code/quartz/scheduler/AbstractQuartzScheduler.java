package rave.code.quartz.scheduler;

public abstract class AbstractQuartzScheduler {

    public static final int RUN_INTERVAL = 3;
    public static final int LOW_PRIORITY = 1;
    public static final int MID_PRIORITY = 5;
    public static final int TOP_PRIORITY = 10;

    public static final String TRADING_GROUP = "Trading";
    public static final String INVESTING_GROUP = "Investing";
    public static final String MISCELLANEOUS_GROUP = "miscellaneous";

    public abstract void scheduleJob();

}
