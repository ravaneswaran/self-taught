package rave.code.quartz.job.moneycontrol;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public abstract class AbstractHistoryJob<S, T> implements Job {

    public abstract void loadHistoryAndClearSource();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.loadHistoryAndClearSource();
    }
}
