package rave.code.quartz.job.moneycontrol.misc;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.stockmarket.repository.*;
import rave.code.stockmarket.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StockBaseJob extends AbstractQuartzJob{

    private BSEActive100Repository bseActive100Repository = new BSEActive100Repository();
    private BSEActive200Repository bseActive200Repository = new BSEActive200Repository();
    private BSEActive500Repository bseActive500Repository = new BSEActive500Repository();
    private BSEPriceShockerRepository bsePriceShockerRepository = new BSEPriceShockerRepository();
    private BSEVolumeShockerRepository bseVolumeShockerRepository = new BSEVolumeShockerRepository();
    private BSESensexRepository bseSensexRepository = new BSESensexRepository();
    private StockBaseRepository stockBaseRepository = new StockBaseRepository();
    private BSESmallCapGainerRepository bseSmallCapGainerRepository = new BSESmallCapGainerRepository();
    private BSEMidCapGainerRepository bseMidCapGainerRepository = new BSEMidCapGainerRepository();
    private BSETopDividendRepository bseTopDividendRepository = new BSETopDividendRepository();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<BSEActive100Entity> bseActive100Entities = this.bseActive100Repository.findAll();
        List<BSEActive200Entity> bseActive200Entities = this.bseActive200Repository.findAll();
        List<BSEActive500Entity> bseActive500Entities = this.bseActive500Repository.findAll();
        List<BSEPriceShockerEntity> bsePriceShockerEntities = this.bsePriceShockerRepository.findAll();
        List<BSEVolumeShockerEntity> bseVolumeShockerEntities = this.bseVolumeShockerRepository.findAll();
        List<BSESensexEntity> bseSensexEntities = this.bseSensexRepository.findAll();
        List<BSESmallCapGainerEntity> bseSmallCapGainerEntities = this.bseSmallCapGainerRepository.findAll();
        List<BSEMidCapGainerEntity> bseMidCapGainerEntities = this.bseMidCapGainerRepository.findAll();
        List<BSETopDividendEntity> bseTopDividendEntities = this.bseTopDividendRepository.findAll();


        List<StockBaseEntity> stockBaseEntities = new ArrayList<>();

        for (BSEActive100Entity bseActive100Entity : bseActive100Entities) {
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseActive100Entity.getStockName());
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
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseActive200Entity.getStockName());
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
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseActive500Entity.getStockName());
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
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bsePriceShockerEntity.getStockName());
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
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseVolumeShockerEntity.getStockName());
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
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseSensexEntity.getStockName());
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

        for (BSESmallCapGainerEntity bseSmallCapGainerEntity : bseSmallCapGainerEntities) {
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseSmallCapGainerEntity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseSmallCapGainerEntity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseSmallCapGainerEntity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSEMidCapGainerEntity bseMidCapGainerEntity : bseMidCapGainerEntities) {
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseMidCapGainerEntity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseMidCapGainerEntity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseMidCapGainerEntity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        for (BSETopDividendEntity bseTopDividendEntity : bseTopDividendEntities) {
            StockBaseEntity stockBaseEntity = this.stockBaseRepository.findBy(bseTopDividendEntity.getStockName());
            if (null == stockBaseEntity) {
                stockBaseEntity = new StockBaseEntity();
                stockBaseEntity.setBSEBasePrice(bseTopDividendEntity.getLastPrice());
            }
            stockBaseEntity.setStockName(bseTopDividendEntity.getStockName());
            stockBaseEntity.setBSE(1);

            Date toDate = new Date();
            stockBaseEntity.setCreatedDate(toDate);
            stockBaseEntity.setModifiedDate(toDate);
            stockBaseEntity.setCreatedBy("SYSTEM");
            stockBaseEntity.setModifiedBy("SYSTEM");

            stockBaseEntities.add(stockBaseEntity);
        }

        List<StockBaseEntity> uniqueItemList = stockBaseEntities.stream().distinct().collect(Collectors.toList());

        this.stockBaseRepository.bulkUpsert(uniqueItemList);
    }
}
