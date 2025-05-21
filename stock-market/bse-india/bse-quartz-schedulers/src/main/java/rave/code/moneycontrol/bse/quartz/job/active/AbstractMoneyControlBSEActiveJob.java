package rave.code.moneycontrol.bse.quartz.job.active;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

public abstract class AbstractMoneyControlBSEActiveJob<S, T> implements Job {

    public abstract List<S> getDataFromSource();

    public abstract List<T> transformSourceData(List<S> sourceData);

    public abstract void saveTransformedData(List<T> transformedData);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<S> sourceData = this.getDataFromSource();
        List<T> transformedData = this.transformSourceData(sourceData);
        saveTransformedData(transformedData);
    }
}
