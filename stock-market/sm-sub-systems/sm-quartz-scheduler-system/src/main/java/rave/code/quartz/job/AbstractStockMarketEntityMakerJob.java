package rave.code.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public abstract class AbstractStockMarketEntityMakerJob<S, T> extends AbstractQuartzJob {

    public abstract S getDataFromSource();

    public abstract T transformSourceData(S sourceData);

    public abstract void saveTransformedData(T transformedData);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        S sourceData = this.getDataFromSource();
        T transformedData = this.transformSourceData(sourceData);
        saveTransformedData(transformedData);
    }
}
