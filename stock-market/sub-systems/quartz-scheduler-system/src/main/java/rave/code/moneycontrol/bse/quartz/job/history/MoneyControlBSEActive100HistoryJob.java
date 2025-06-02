package rave.code.moneycontrol.bse.quartz.job.history;

import org.quartz.JobExecutionException;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlHistoryJob;
import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive100DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100HistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSEActive100HistoryJob extends AbstractMoneyControlHistoryJob<MoneyControlBSEActive100Entity, MoneyControlBSEActive100HistoryEntity> {

    @Override
    public void saveToHistory(List<MoneyControlBSEActive100HistoryEntity> historyData) {
        StockMarketDataAccess stockMarketDataAccess = new StockMarketDataAccess(MoneyControlBSEActive100HistoryEntity.class);
        for (MoneyControlBSEActive100HistoryEntity moneyControlBSEActive100HistoryEntity : historyData) {
            stockMarketDataAccess.save(moneyControlBSEActive100HistoryEntity);
        }
    }

    @Override
    public List<MoneyControlBSEActive100Entity> getSourceData() {
        MoneyControlBSEActive100DataAccess moneyControlBSEActive100DataAccess = new MoneyControlBSEActive100DataAccess(MoneyControlBSEActive100Entity.class);
        return moneyControlBSEActive100DataAccess.findAll();
    }

    @Override
    public List<MoneyControlBSEActive100HistoryEntity> transformToHistory(List<MoneyControlBSEActive100Entity> sourceData) {
        List<MoneyControlBSEActive100HistoryEntity> moneyControlBSEActive100HistoryEntities = new ArrayList<>();

        for (MoneyControlBSEActive100Entity moneyControlBSEActive100Entity : sourceData) {
            MoneyControlBSEActive100HistoryEntity moneyControlBSEActive100HistoryEntity = new MoneyControlBSEActive100HistoryEntity();

            moneyControlBSEActive100HistoryEntity.setId(moneyControlBSEActive100Entity.getId());
            moneyControlBSEActive100HistoryEntity.setCompanyName(moneyControlBSEActive100Entity.getCompanyName());
            moneyControlBSEActive100HistoryEntity.setHigh(moneyControlBSEActive100Entity.getHigh());
            moneyControlBSEActive100HistoryEntity.setLow(moneyControlBSEActive100Entity.getLow());
            moneyControlBSEActive100HistoryEntity.setLastPrice(moneyControlBSEActive100Entity.getLastPrice());
            moneyControlBSEActive100HistoryEntity.setPercentageChange(moneyControlBSEActive100Entity.getPercentageChange());
            moneyControlBSEActive100HistoryEntity.setValueInCrores(moneyControlBSEActive100Entity.getValueInCrores());
            moneyControlBSEActive100HistoryEntity.setAverageVolume5Days(moneyControlBSEActive100Entity.getAverageVolume5Days());
            moneyControlBSEActive100HistoryEntity.setAverageVolume10Days(moneyControlBSEActive100Entity.getAverageVolume10Days());
            moneyControlBSEActive100HistoryEntity.setAverageVolume30Days(moneyControlBSEActive100Entity.getAverageVolume30Days());
            moneyControlBSEActive100HistoryEntity.setPriceToEarningRatio(moneyControlBSEActive100Entity.getPriceToEarningRatio());
            moneyControlBSEActive100HistoryEntity.setPriceToBookRatio(moneyControlBSEActive100Entity.getPriceToBookRatio());
            moneyControlBSEActive100HistoryEntity.setUpperCircuit(moneyControlBSEActive100Entity.getUpperCircuit());
            moneyControlBSEActive100HistoryEntity.setLowerCircuit(moneyControlBSEActive100Entity.getLowerCircuit());
            moneyControlBSEActive100HistoryEntity.setVolumeWeightedAveragePrice(moneyControlBSEActive100Entity.getVolumeWeightedAveragePrice());
            moneyControlBSEActive100HistoryEntity.setDisplacedMovingAverage30D(moneyControlBSEActive100Entity.getDisplacedMovingAverage30D());
            moneyControlBSEActive100HistoryEntity.setDisplacedMovingAverage50D(moneyControlBSEActive100Entity.getDisplacedMovingAverage50D());
            moneyControlBSEActive100HistoryEntity.setDisplacedMovingAverage150D(moneyControlBSEActive100Entity.getDisplacedMovingAverage150D());
            moneyControlBSEActive100HistoryEntity.setDisplacedMovingAverage200D(moneyControlBSEActive100Entity.getDisplacedMovingAverage200D());
            moneyControlBSEActive100HistoryEntity.setCreatedBy(moneyControlBSEActive100Entity.getCreatedBy());
            moneyControlBSEActive100HistoryEntity.setModifiedBy(moneyControlBSEActive100Entity.getModifiedBy());
            moneyControlBSEActive100HistoryEntity.setCreatedDate(moneyControlBSEActive100Entity.getCreatedDate());
            moneyControlBSEActive100HistoryEntity.setModifiedDate(moneyControlBSEActive100Entity.getModifiedDate());

            moneyControlBSEActive100HistoryEntities.add(moneyControlBSEActive100HistoryEntity);
        }

        return moneyControlBSEActive100HistoryEntities;
    }

    @Override
    public void deleteSourceData(List<MoneyControlBSEActive100Entity> sourceData) {
        StockMarketDataAccess stockMarketDataAccess = new StockMarketDataAccess(MoneyControlBSEActive100Entity.class);
        for (MoneyControlBSEActive100Entity moneyControlBSEActive100Entity : sourceData) {
            stockMarketDataAccess.delete(moneyControlBSEActive100Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive100HistoryJob moneyControlBSEActive100HistoryJob = new MoneyControlBSEActive100HistoryJob();
        moneyControlBSEActive100HistoryJob.execute(null);
    }
}
