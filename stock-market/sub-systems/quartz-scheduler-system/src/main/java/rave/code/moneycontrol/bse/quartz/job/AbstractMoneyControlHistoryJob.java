package rave.code.moneycontrol.bse.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

public abstract class AbstractMoneyControlHistoryJob<S, T> implements Job {

    public abstract void saveToHistory(List<T> historyData);

    public abstract List<S> getSourceData();

    public abstract List<T> transformToHistory(List<S> sourceData);

    public abstract void deleteSourceData(List<S> sourceData);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       List<S> sourceData = this.getSourceData();
       List<T> historyData = this.transformToHistory(sourceData);
       this.saveToHistory(historyData);
       this.deleteSourceData(sourceData);
    }
}
