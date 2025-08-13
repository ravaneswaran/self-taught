package rave.code.quartz.job.groww;

import org.quartz.JobExecutionException;
import rave.code.data.parser.html.groww.HolidayListParser;
import rave.code.quartz.job.moneycontrol.AbstractEntityMakerJob;
import rave.code.stockmarket.repository.HolidayRepository;
import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.website.data.model.groww.HolidayModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HolidayJob extends AbstractEntityMakerJob<HolidayModel, HolidayEntity> {

    public static void main(String[] args) throws JobExecutionException {
        new HolidayJob().execute(null);
    }

    @Override
    public List<HolidayModel> getDataFromSource() {
        return new HolidayListParser().parse();
    }

    @Override
    public List<HolidayEntity> transformSourceData(List<HolidayModel> sourceData) {
        List<HolidayEntity> entities = new ArrayList<>();

        for (HolidayModel growwHolidayModel : sourceData) {
            HolidayEntity entity = new HolidayEntity();
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
    public void saveTransformedData(List<HolidayEntity> transformedData) {
        HolidayRepository stockMarketHolidayDataAccess = new HolidayRepository();
        for (HolidayEntity entity : transformedData) {
            stockMarketHolidayDataAccess.save(entity);
        }
    }
}
