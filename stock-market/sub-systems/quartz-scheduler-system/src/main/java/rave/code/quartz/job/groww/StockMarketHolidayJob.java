package rave.code.quartz.job.groww;

import org.quartz.JobExecutionException;
import rave.code.data.parser.html.groww.HolidayListParser;
import rave.code.website.data.model.groww.HolidayModel;
import rave.code.quartz.job.moneycontrol.AbstractJob;
import rave.code.stockmarket.bse.dataaccess.StockMarketHolidayDataAccess;
import rave.code.stockmarket.bse.entity.StockMarketHolidayEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StockMarketHolidayJob extends AbstractJob<HolidayModel, StockMarketHolidayEntity> {

    @Override
    public List<HolidayModel> getDataFromSource() {
        return new HolidayListParser().parse();
    }

    @Override
    public List<StockMarketHolidayEntity> transformSourceData(List<HolidayModel> sourceData) {
        List<StockMarketHolidayEntity> entities = new ArrayList<>();

        for (HolidayModel growwHolidayModel : sourceData) {
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
