package rave.code.moneycontrol.bse.quartz.job.history;

import org.quartz.JobExecutionException;
import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive500DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500HistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSEActive500HistoryJob extends AbstractMoneyControlBSEActiveHistoryJob<MoneyControlBSEActive500Entity, MoneyControlBSEActive500HistoryEntity> {

    @Override
    public void saveToHistory(List<MoneyControlBSEActive500HistoryEntity> historyData) {
        StockMarketDataAccess stockMarketDataAccess = new StockMarketDataAccess(MoneyControlBSEActive500HistoryEntity.class);
        for (MoneyControlBSEActive500HistoryEntity moneyControlBSEActive500HistoryEntity : historyData) {
            stockMarketDataAccess.save(moneyControlBSEActive500HistoryEntity);
        }
    }

    @Override
    public List<MoneyControlBSEActive500Entity> getSourceData() {
        MoneyControlBSEActive500DataAccess moneyControlBSEActive500DataAccess = new MoneyControlBSEActive500DataAccess(MoneyControlBSEActive500Entity.class);
        return moneyControlBSEActive500DataAccess.findAll();
    }

    @Override
    public List<MoneyControlBSEActive500HistoryEntity> transformToHistory(List<MoneyControlBSEActive500Entity> sourceData) {
        List<MoneyControlBSEActive500HistoryEntity> moneyControlBSEActive500HistoryEntities = new ArrayList<>();

        for (MoneyControlBSEActive500Entity moneyControlBSEActive500Entity : sourceData) {
            MoneyControlBSEActive500HistoryEntity moneyControlBSEActive500HistoryEntity = new MoneyControlBSEActive500HistoryEntity();

            moneyControlBSEActive500HistoryEntity.setId(moneyControlBSEActive500Entity.getId());
            moneyControlBSEActive500HistoryEntity.setCompanyName(moneyControlBSEActive500Entity.getCompanyName());
            moneyControlBSEActive500HistoryEntity.setHigh(moneyControlBSEActive500Entity.getHigh());
            moneyControlBSEActive500HistoryEntity.setLow(moneyControlBSEActive500Entity.getLow());
            moneyControlBSEActive500HistoryEntity.setLastPrice(moneyControlBSEActive500Entity.getLastPrice());
            moneyControlBSEActive500HistoryEntity.setPercentageChange(moneyControlBSEActive500Entity.getPercentageChange());
            moneyControlBSEActive500HistoryEntity.setValueInCrores(moneyControlBSEActive500Entity.getValueInCrores());
            moneyControlBSEActive500HistoryEntity.setAverageVolume5Days(moneyControlBSEActive500Entity.getAverageVolume5Days());
            moneyControlBSEActive500HistoryEntity.setAverageVolume10Days(moneyControlBSEActive500Entity.getAverageVolume10Days());
            moneyControlBSEActive500HistoryEntity.setAverageVolume30Days(moneyControlBSEActive500Entity.getAverageVolume30Days());
            moneyControlBSEActive500HistoryEntity.setPriceToEarningRatio(moneyControlBSEActive500Entity.getPriceToEarningRatio());
            moneyControlBSEActive500HistoryEntity.setPriceToBookRatio(moneyControlBSEActive500Entity.getPriceToBookRatio());
            moneyControlBSEActive500HistoryEntity.setUpperCircuit(moneyControlBSEActive500Entity.getUpperCircuit());
            moneyControlBSEActive500HistoryEntity.setLowerCircuit(moneyControlBSEActive500Entity.getLowerCircuit());
            moneyControlBSEActive500HistoryEntity.setVolumeWeightedAveragePrice(moneyControlBSEActive500Entity.getVolumeWeightedAveragePrice());
            moneyControlBSEActive500HistoryEntity.setDisplacedMovingAverage30D(moneyControlBSEActive500Entity.getDisplacedMovingAverage30D());
            moneyControlBSEActive500HistoryEntity.setDisplacedMovingAverage50D(moneyControlBSEActive500Entity.getDisplacedMovingAverage50D());
            moneyControlBSEActive500HistoryEntity.setDisplacedMovingAverage150D(moneyControlBSEActive500Entity.getDisplacedMovingAverage150D());
            moneyControlBSEActive500HistoryEntity.setDisplacedMovingAverage200D(moneyControlBSEActive500Entity.getDisplacedMovingAverage200D());
            moneyControlBSEActive500HistoryEntity.setCreatedBy(moneyControlBSEActive500Entity.getCreatedBy());
            moneyControlBSEActive500HistoryEntity.setModifiedBy(moneyControlBSEActive500Entity.getModifiedBy());
            moneyControlBSEActive500HistoryEntity.setCreatedDate(moneyControlBSEActive500Entity.getCreatedDate());
            moneyControlBSEActive500HistoryEntity.setModifiedDate(moneyControlBSEActive500Entity.getModifiedDate());

            moneyControlBSEActive500HistoryEntities.add(moneyControlBSEActive500HistoryEntity);
        }

        return moneyControlBSEActive500HistoryEntities;
    }

    @Override
    public void deleteSourceData(List<MoneyControlBSEActive500Entity> sourceData) {
        StockMarketDataAccess stockMarketDataAccess = new StockMarketDataAccess(MoneyControlBSEActive500Entity.class);
        for (MoneyControlBSEActive500Entity moneyControlBSEActive500Entity : sourceData) {
            stockMarketDataAccess.delete(moneyControlBSEActive500Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive500HistoryJob moneyControlBSEActive500HistoryJob = new MoneyControlBSEActive500HistoryJob();
        moneyControlBSEActive500HistoryJob.execute(null);
    }
}
