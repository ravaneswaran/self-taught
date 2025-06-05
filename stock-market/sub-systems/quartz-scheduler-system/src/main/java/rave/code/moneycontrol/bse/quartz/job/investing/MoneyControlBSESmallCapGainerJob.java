package rave.code.moneycontrol.bse.quartz.job.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSESmallCapGainersParser;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlTradingJob;
import rave.code.moneycontrol.website.data.model.MoneyControlCapGainerModel;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSESmallCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSESmallCapGainerJob extends AbstractMoneyControlTradingJob<MoneyControlCapGainerModel, MoneyControlBSESmallCapGainerEntity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSESmallCapGainerJob.class.getName());

    @Override
    public List<MoneyControlCapGainerModel> getDataFromSource() {
        MoneyControlBSESmallCapGainersParser moneyControlBSESmallCapGainersParser = new MoneyControlBSESmallCapGainersParser();
        return moneyControlBSESmallCapGainersParser.parse();
    }

    @Override
    public List<MoneyControlBSESmallCapGainerEntity> transformSourceData(List<MoneyControlCapGainerModel> sourceData) {
        List<MoneyControlBSESmallCapGainerEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (MoneyControlGenericModel moneyControlGenericModel : sourceData) {
            MoneyControlBSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity = new MoneyControlBSESmallCapGainerEntity();

            String companyName = moneyControlGenericModel.getCompanyName();
            if (null != companyName && !"".equals(companyName)) {
                moneyControlBSESmallCapGainerEntity.setCompanyName(moneyControlGenericModel.getCompanyName());
                Number value = null;

                try {
                    value = format.parse(moneyControlGenericModel.getHigh());
                    moneyControlBSESmallCapGainerEntity.setHigh(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setHigh(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlGenericModel.getLow());
                    moneyControlBSESmallCapGainerEntity.setLow(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLow(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlGenericModel.getLastPrice());
                    moneyControlBSESmallCapGainerEntity.setLastPrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLastPrice(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlGenericModel.getPreviousClose());
                    moneyControlBSESmallCapGainerEntity.setPreviousClose(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPreviousClose(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlGenericModel.getChange());
                    moneyControlBSESmallCapGainerEntity.setVariation(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setVariation(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlGenericModel.getPercentageGain());
                    moneyControlBSESmallCapGainerEntity.setPercentageGain(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPercentageGain(String.valueOf(0.00));
                }

                Date toDate = new Date();
                moneyControlBSESmallCapGainerEntity.setCreatedDate(toDate);
                moneyControlBSESmallCapGainerEntity.setModifiedDate(toDate);
                moneyControlBSESmallCapGainerEntity.setCreatedBy("SYSTEM");
                moneyControlBSESmallCapGainerEntity.setModifiedBy("SYSTEM");

                entities.add(moneyControlBSESmallCapGainerEntity);
            }
        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<MoneyControlBSESmallCapGainerEntity> transformedData) {
        MoneyControlBSESmallCapGainerDataAccess moneyControlBSESmallCapGainerDataAccess = new MoneyControlBSESmallCapGainerDataAccess(MoneyControlBSESmallCapGainerEntity.class);
        for (MoneyControlBSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity : transformedData) {
            moneyControlBSESmallCapGainerDataAccess.upsert(moneyControlBSESmallCapGainerEntity);
        }
    }
}
