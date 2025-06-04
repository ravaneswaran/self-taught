package rave.code.moneycontrol.bse.quartz.job.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEMidCapGainersParser;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlTradingJob;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEMidCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEMidCapGainerEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MoneyControlBSEMidCapGainerJob extends AbstractMoneyControlTradingJob<MoneyControlGenericModel, MoneyControlBSEMidCapGainerEntity> {

    @Override
    public List<MoneyControlGenericModel> getDataFromSource() {
        MoneyControlBSEMidCapGainersParser moneyControlBSEMidCapGainersParser = new MoneyControlBSEMidCapGainersParser();
        return moneyControlBSEMidCapGainersParser.parse();
    }

    @Override
    public List<MoneyControlBSEMidCapGainerEntity> transformSourceData(List<MoneyControlGenericModel> sourceData) {
        List<MoneyControlBSEMidCapGainerEntity> entities = new ArrayList<>();

        for (MoneyControlGenericModel moneyControlGenericModel : sourceData) {
            MoneyControlBSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity = new MoneyControlBSEMidCapGainerEntity();

            moneyControlBSEMidCapGainerEntity.setId(UUID.randomUUID().toString());
            moneyControlBSEMidCapGainerEntity.setCompanyName(moneyControlGenericModel.getCompanyName());
            moneyControlBSEMidCapGainerEntity.setHigh(moneyControlGenericModel.getHigh());
            moneyControlBSEMidCapGainerEntity.setLow(moneyControlGenericModel.getLow());
            moneyControlBSEMidCapGainerEntity.setLastPrice(moneyControlGenericModel.getLastPrice());
            moneyControlBSEMidCapGainerEntity.setPreviousClose(moneyControlGenericModel.getPreviousClose());
            moneyControlBSEMidCapGainerEntity.setVariation(moneyControlGenericModel.getChange());
            moneyControlBSEMidCapGainerEntity.setPercentageGain(moneyControlGenericModel.getPercentageGain());

            Date toDate = new Date();
            moneyControlBSEMidCapGainerEntity.setCreatedDate(toDate);
            moneyControlBSEMidCapGainerEntity.setModifiedDate(toDate);
            moneyControlBSEMidCapGainerEntity.setCreatedBy("SYSTEM");
            moneyControlBSEMidCapGainerEntity.setModifiedBy("SYSTEM");

            entities.add(moneyControlBSEMidCapGainerEntity);

        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<MoneyControlBSEMidCapGainerEntity> transformedData) {
        MoneyControlBSEMidCapGainerDataAccess moneyControlBSEMidCapGainerDataAccess = new MoneyControlBSEMidCapGainerDataAccess(MoneyControlBSEMidCapGainerEntity.class);
        for (MoneyControlBSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity : transformedData) {
            moneyControlBSEMidCapGainerDataAccess.save(moneyControlBSEMidCapGainerEntity);
        }
    }
}
