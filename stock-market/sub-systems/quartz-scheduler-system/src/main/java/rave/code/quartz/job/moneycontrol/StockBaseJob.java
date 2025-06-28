package rave.code.quartz.job.moneycontrol;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.stockmarket.dataaccess.*;
import rave.code.stockmarket.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StockBaseJob extends AbstractJob<Object, Object> {

    private BSEActive100DataAccess bseActive100DataAccess = new BSEActive100DataAccess();
    private BSEActive200DataAccess bseActive200DataAccess = new BSEActive200DataAccess();
    private BSEActive500DataAccess bseActive500DataAccess = new BSEActive500DataAccess();
    private BSEPriceShockerDataAccess bsePriceShockerDataAccess = new BSEPriceShockerDataAccess();
    private BSEVolumeShockerDataAccess bseVolumeShockerDataAccess = new BSEVolumeShockerDataAccess();
    private BSESensexDataAccess bseSensexDataAccess = new BSESensexDataAccess();
    private StockBaseDataAccess stockBaseDataAccess = new StockBaseDataAccess();

    @Override
    public List<Object> getDataFromSource() {
        return null;
    }

    @Override
    public List<Object> transformSourceData(List<Object> sourceData) {
        return null;
    }

    @Override
    public void saveTransformedData(List<Object> transformedData) {

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<BSEActive100Entity> bseActive100Entities = this.bseActive100DataAccess.findAll();
        List<BSEActive200Entity> bseActive200Entities = this.bseActive200DataAccess.findAll();
        List<BSEActive500Entity> bseActive500Entities = this.bseActive500DataAccess.findAll();
        List<BSEPriceShockerEntity> bsePriceShockerEntities = this.bsePriceShockerDataAccess.findAll();
        List<BSEVolumeShockerEntity> bseVolumeShockerEntities = this.bseVolumeShockerDataAccess.findAll();
        List<BSESensexEntity> bseSensexEntities = this.bseSensexDataAccess.findAll();

        List<StockBaseEntity> stockBaseEntities = new ArrayList<>();

        for (BSEActive100Entity bseActive100Entity : bseActive100Entities) {
            StockBaseEntity stockBaseEntity = this.stockBaseDataAccess.findBy(bseActive100Entity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseActive100Entity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseActive100Entity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSEActive200Entity bseActive200Entity : bseActive200Entities) {
            StockBaseEntity stockBaseEntity = this.stockBaseDataAccess.findBy(bseActive200Entity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseActive200Entity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseActive200Entity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSEActive500Entity bseActive500Entity : bseActive500Entities) {
            StockBaseEntity stockBaseEntity = this.stockBaseDataAccess.findBy(bseActive500Entity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseActive500Entity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseActive500Entity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSEPriceShockerEntity bsePriceShockerEntity : bsePriceShockerEntities) {
            StockBaseEntity stockBaseEntity = this.stockBaseDataAccess.findBy(bsePriceShockerEntity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bsePriceShockerEntity.getCurrentPrice());
            }
            stockBaseEntity.setStockName(bsePriceShockerEntity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSEVolumeShockerEntity bseVolumeShockerEntity : bseVolumeShockerEntities) {
            StockBaseEntity stockBaseEntity = this.stockBaseDataAccess.findBy(bseVolumeShockerEntity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseVolumeShockerEntity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseVolumeShockerEntity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSESensexEntity bseSensexEntity : bseSensexEntities) {
            StockBaseEntity stockBaseEntity = this.stockBaseDataAccess.findBy(bseSensexEntity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseSensexEntity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseSensexEntity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        List<StockBaseEntity> uniqueItemList = stockBaseEntities.stream().distinct().collect(Collectors.toList());

        this.stockBaseDataAccess.bulkUpsert(uniqueItemList);
    }
}
