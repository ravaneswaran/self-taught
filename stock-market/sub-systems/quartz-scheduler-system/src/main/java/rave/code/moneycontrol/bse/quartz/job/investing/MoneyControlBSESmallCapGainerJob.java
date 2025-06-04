package rave.code.moneycontrol.bse.quartz.job.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSESmallCapGainersParser;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlTradingJob;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSESmallCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MoneyControlBSESmallCapGainerJob extends AbstractMoneyControlTradingJob<MoneyControlGenericModel, MoneyControlBSESmallCapGainerEntity> {

    @Override
    public List<MoneyControlGenericModel> getDataFromSource() {
        MoneyControlBSESmallCapGainersParser moneyControlBSESmallCapGainersParser = new MoneyControlBSESmallCapGainersParser();
        return moneyControlBSESmallCapGainersParser.parse();
    }

    @Override
    public List<MoneyControlBSESmallCapGainerEntity> transformSourceData(List<MoneyControlGenericModel> sourceData) {
        List<MoneyControlBSESmallCapGainerEntity> entities = new ArrayList<>();

        for (MoneyControlGenericModel moneyControlGenericModel : sourceData) {
            MoneyControlBSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity = new MoneyControlBSESmallCapGainerEntity();

            moneyControlBSESmallCapGainerEntity.setId(UUID.randomUUID().toString());
            moneyControlBSESmallCapGainerEntity.setCompanyName(moneyControlGenericModel.getCompanyName());
            moneyControlBSESmallCapGainerEntity.setHigh(moneyControlGenericModel.getHigh());
            moneyControlBSESmallCapGainerEntity.setLow(moneyControlGenericModel.getLow());
            moneyControlBSESmallCapGainerEntity.setLastPrice(moneyControlGenericModel.getLastPrice());
            moneyControlBSESmallCapGainerEntity.setPreviousClose(moneyControlGenericModel.getPreviousClose());
            moneyControlBSESmallCapGainerEntity.setVariation(moneyControlGenericModel.getChange());
            moneyControlBSESmallCapGainerEntity.setPercentageGain(moneyControlGenericModel.getPercentageGain());

            Date toDate = new Date();
            moneyControlBSESmallCapGainerEntity.setCreatedDate(toDate);
            moneyControlBSESmallCapGainerEntity.setModifiedDate(toDate);
            moneyControlBSESmallCapGainerEntity.setCreatedBy("SYSTEM");
            moneyControlBSESmallCapGainerEntity.setModifiedBy("SYSTEM");

            entities.add(moneyControlBSESmallCapGainerEntity);

        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<MoneyControlBSESmallCapGainerEntity> transformedData) {
        MoneyControlBSESmallCapGainerDataAccess moneyControlBSESmallCapGainerDataAccess = new MoneyControlBSESmallCapGainerDataAccess(MoneyControlBSESmallCapGainerEntity.class);
        for (MoneyControlBSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity : transformedData) {
            moneyControlBSESmallCapGainerDataAccess.save(moneyControlBSESmallCapGainerEntity);
        }
    }
}
