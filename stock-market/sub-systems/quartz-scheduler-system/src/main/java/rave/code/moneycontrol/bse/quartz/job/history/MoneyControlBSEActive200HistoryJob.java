package rave.code.moneycontrol.bse.quartz.job.history;

import org.quartz.JobExecutionException;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlHistoryJob;
import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive200DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100HistoryEntity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200HistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSEActive200HistoryJob extends AbstractMoneyControlHistoryJob<MoneyControlBSEActive200Entity, MoneyControlBSEActive200HistoryEntity> {

    @Override
    public void saveToHistory(List<MoneyControlBSEActive200HistoryEntity> historyData) {
        StockMarketDataAccess stockMarketDataAccess = new StockMarketDataAccess(MoneyControlBSEActive100HistoryEntity.class);
        for (MoneyControlBSEActive200HistoryEntity moneyControlBSEActive200HistoryEntity : historyData) {
            stockMarketDataAccess.save(moneyControlBSEActive200HistoryEntity);
        }
    }

    @Override
    public List<MoneyControlBSEActive200Entity> getSourceData() {
        MoneyControlBSEActive200DataAccess moneyControlBSEActive200DataAccess = new MoneyControlBSEActive200DataAccess(MoneyControlBSEActive200Entity.class);
        return moneyControlBSEActive200DataAccess.findAll();
    }

    @Override
    public List<MoneyControlBSEActive200HistoryEntity> transformToHistory(List<MoneyControlBSEActive200Entity> sourceData) {
        List<MoneyControlBSEActive200HistoryEntity> moneyControlBSEActive200HistoryEntities = new ArrayList<>();

        for (MoneyControlBSEActive200Entity moneyControlBSEActive200Entity : sourceData) {
            MoneyControlBSEActive200HistoryEntity moneyControlBSEActive200HistoryEntity = new MoneyControlBSEActive200HistoryEntity();

            moneyControlBSEActive200HistoryEntity.setId(moneyControlBSEActive200Entity.getId());
            moneyControlBSEActive200HistoryEntity.setCompanyName(moneyControlBSEActive200Entity.getCompanyName());
            moneyControlBSEActive200HistoryEntity.setHigh(moneyControlBSEActive200Entity.getHigh());
            moneyControlBSEActive200HistoryEntity.setLow(moneyControlBSEActive200Entity.getLow());
            moneyControlBSEActive200HistoryEntity.setLastPrice(moneyControlBSEActive200Entity.getLastPrice());
            moneyControlBSEActive200HistoryEntity.setPercentageChange(moneyControlBSEActive200Entity.getPercentageChange());
            moneyControlBSEActive200HistoryEntity.setValueInCrores(moneyControlBSEActive200Entity.getValueInCrores());
            moneyControlBSEActive200HistoryEntity.setAverageVolume5Days(moneyControlBSEActive200Entity.getAverageVolume5Days());
            moneyControlBSEActive200HistoryEntity.setAverageVolume10Days(moneyControlBSEActive200Entity.getAverageVolume10Days());
            moneyControlBSEActive200HistoryEntity.setAverageVolume30Days(moneyControlBSEActive200Entity.getAverageVolume30Days());
            moneyControlBSEActive200HistoryEntity.setPriceToEarningRatio(moneyControlBSEActive200Entity.getPriceToEarningRatio());
            moneyControlBSEActive200HistoryEntity.setPriceToBookRatio(moneyControlBSEActive200Entity.getPriceToBookRatio());
            moneyControlBSEActive200HistoryEntity.setUpperCircuit(moneyControlBSEActive200Entity.getUpperCircuit());
            moneyControlBSEActive200HistoryEntity.setLowerCircuit(moneyControlBSEActive200Entity.getLowerCircuit());
            moneyControlBSEActive200HistoryEntity.setVolumeWeightedAveragePrice(moneyControlBSEActive200Entity.getVolumeWeightedAveragePrice());
            moneyControlBSEActive200HistoryEntity.setDisplacedMovingAverage30D(moneyControlBSEActive200Entity.getDisplacedMovingAverage30D());
            moneyControlBSEActive200HistoryEntity.setDisplacedMovingAverage50D(moneyControlBSEActive200Entity.getDisplacedMovingAverage50D());
            moneyControlBSEActive200HistoryEntity.setDisplacedMovingAverage150D(moneyControlBSEActive200Entity.getDisplacedMovingAverage150D());
            moneyControlBSEActive200HistoryEntity.setDisplacedMovingAverage200D(moneyControlBSEActive200Entity.getDisplacedMovingAverage200D());
            moneyControlBSEActive200HistoryEntity.setCreatedBy(moneyControlBSEActive200Entity.getCreatedBy());
            moneyControlBSEActive200HistoryEntity.setModifiedBy(moneyControlBSEActive200Entity.getModifiedBy());
            moneyControlBSEActive200HistoryEntity.setCreatedDate(moneyControlBSEActive200Entity.getCreatedDate());
            moneyControlBSEActive200HistoryEntity.setModifiedDate(moneyControlBSEActive200Entity.getModifiedDate());

            moneyControlBSEActive200HistoryEntities.add(moneyControlBSEActive200HistoryEntity);
        }

        return moneyControlBSEActive200HistoryEntities;
    }

    @Override
    public void deleteSourceData(List<MoneyControlBSEActive200Entity> sourceData) {
        StockMarketDataAccess stockMarketDataAccess = new StockMarketDataAccess(MoneyControlBSEActive200Entity.class);
        for (MoneyControlBSEActive200Entity moneyControlBSEActive200Entity : sourceData) {
            stockMarketDataAccess.delete(moneyControlBSEActive200Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive200HistoryJob moneyControlBSEActive200HistoryJob = new MoneyControlBSEActive200HistoryJob();
        moneyControlBSEActive200HistoryJob.execute(null);
    }
}
