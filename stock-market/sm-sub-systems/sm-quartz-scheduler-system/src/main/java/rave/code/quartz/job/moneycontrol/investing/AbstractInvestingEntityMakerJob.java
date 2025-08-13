package rave.code.quartz.job.moneycontrol.investing;

import rave.code.quartz.job.moneycontrol.AbstractEntityMakerJob;

import java.util.List;

public abstract class AbstractInvestingEntityMakerJob<S, T> extends AbstractEntityMakerJob<S, T> {

    public abstract List<S> getDataFromSource();

    public abstract List<T> transformSourceData(List<S> sourceData);

    public abstract void saveTransformedData(List<T> transformedData);
}