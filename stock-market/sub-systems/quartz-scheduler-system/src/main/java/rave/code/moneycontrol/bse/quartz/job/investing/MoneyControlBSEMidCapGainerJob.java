package rave.code.moneycontrol.bse.quartz.job.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEMidCapGainersParser;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlTradingJob;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEMidCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEMidCapGainerEntity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEMidCapGainerJob extends AbstractMoneyControlTradingJob<MoneyControlGenericModel, MoneyControlBSEMidCapGainerEntity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEMidCapGainerJob.class.getName());

    @Override
    public List<MoneyControlGenericModel> getDataFromSource() {
        MoneyControlBSEMidCapGainersParser moneyControlBSEMidCapGainersParser = new MoneyControlBSEMidCapGainersParser();
        return moneyControlBSEMidCapGainersParser.parse();
    }

    @Override
    public List<MoneyControlBSEMidCapGainerEntity> transformSourceData(List<MoneyControlGenericModel> sourceData) {
        List<MoneyControlBSEMidCapGainerEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (MoneyControlGenericModel moneyControlGenericModel : sourceData) {
            MoneyControlBSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity = new MoneyControlBSEMidCapGainerEntity();

            moneyControlBSEMidCapGainerEntity.setId(UUID.randomUUID().toString());
            moneyControlBSEMidCapGainerEntity.setCompanyName(moneyControlGenericModel.getCompanyName());

            Number value = null;
            try {
                value = format.parse(moneyControlGenericModel.getHigh());
                moneyControlBSEMidCapGainerEntity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEMidCapGainerEntity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlGenericModel.getLow());
                moneyControlBSEMidCapGainerEntity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEMidCapGainerEntity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlGenericModel.getLastPrice());
                moneyControlBSEMidCapGainerEntity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEMidCapGainerEntity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlGenericModel.getPreviousClose());
                moneyControlBSEMidCapGainerEntity.setPreviousClose(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEMidCapGainerEntity.setPreviousClose(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlGenericModel.getChange());
                moneyControlBSEMidCapGainerEntity.setVariation(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEMidCapGainerEntity.setVariation(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlGenericModel.getPercentageGain());
                moneyControlBSEMidCapGainerEntity.setPercentageGain(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEMidCapGainerEntity.setPercentageGain(String.valueOf(0.00));
            }

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
