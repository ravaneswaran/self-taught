package rave.code.quartz.job.groww;

import org.quartz.JobExecutionException;
import rave.code.groww.data.parser.html.GrowwHolidayParser;
import rave.code.groww.website.data.model.GrowwHolidayModel;
import rave.code.quartz.job.moneycontrol.AbstractTradingJob;
import rave.code.stockmarket.bse.dataaccess.StockMarketHolidayDataAccess;
import rave.code.stockmarket.bse.entity.StockMarketHolidayEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StockMarketHolidayJob extends AbstractTradingJob<GrowwHolidayModel, StockMarketHolidayEntity> {

    @Override
    public List<GrowwHolidayModel> getDataFromSource() {
        return new GrowwHolidayParser().parse();
    }

    @Override
    public List<StockMarketHolidayEntity> transformSourceData(List<GrowwHolidayModel> sourceData) {
        List<StockMarketHolidayEntity> entities = new ArrayList<>();

        for (GrowwHolidayModel growwHolidayModel : sourceData) {
            StockMarketHolidayEntity entity = new StockMarketHolidayEntity();
            entity.setId(UUID.randomUUID().toString());
            entity.setHolidate(growwHolidayModel.getDate());
            entity.setHoliday(growwHolidayModel.getDay());
            entity.setDescription(growwHolidayModel.getDescription());

            Date toDate = new Date();
            entity.setCreatedDate(toDate);
            entity.setModifiedDate(toDate);
            entity.setCreatedBy("SYSTEM");
            entity.setModifiedBy("SYSTEM");

            entities.add(entity);
        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<StockMarketHolidayEntity> transformedData) {
        StockMarketHolidayDataAccess stockMarketHolidayDataAccess = new StockMarketHolidayDataAccess();
        for (StockMarketHolidayEntity entity : transformedData) {
            stockMarketHolidayDataAccess.save(entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        new StockMarketHolidayJob().execute(null);
    }
}
