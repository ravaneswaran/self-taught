package rave.code.quartz.job.moneycontrol;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;

import java.util.List;

public abstract class AbstractEntityMakerJob<S, T> extends AbstractQuartzJob {

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