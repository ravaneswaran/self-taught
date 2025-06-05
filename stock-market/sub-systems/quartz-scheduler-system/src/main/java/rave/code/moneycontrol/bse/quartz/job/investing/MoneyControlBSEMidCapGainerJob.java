package rave.code.moneycontrol.bse.quartz.job.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEMidCapGainersParser;
import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlTradingJob;
import rave.code.moneycontrol.website.data.model.MoneyControlCapGainerModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEMidCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEMidCapGainerEntity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEMidCapGainerJob extends AbstractMoneyControlTradingJob<MoneyControlCapGainerModel, MoneyControlBSEMidCapGainerEntity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEMidCapGainerJob.class.getName());

    @Override
    public List<MoneyControlCapGainerModel> getDataFromSource() {
        MoneyControlBSEMidCapGainersParser moneyControlBSEMidCapGainersParser = new MoneyControlBSEMidCapGainersParser();
        return moneyControlBSEMidCapGainersParser.parse();
    }

    @Override
    public List<MoneyControlBSEMidCapGainerEntity> transformSourceData(List<MoneyControlCapGainerModel> sourceData) {
        List<MoneyControlBSEMidCapGainerEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (MoneyControlCapGainerModel moneyControlCapGainerModel : sourceData) {
            MoneyControlBSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity = new MoneyControlBSEMidCapGainerEntity();

            String companyName = moneyControlCapGainerModel.getCompanyName();
            if (null != companyName && !"".equals(companyName)) {
                moneyControlBSEMidCapGainerEntity.setCompanyName(companyName);

                Number value = null;
                try {
                    value = format.parse(moneyControlCapGainerModel.getHigh());
                    moneyControlBSEMidCapGainerEntity.setHigh(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setHigh(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLow());
                    moneyControlBSEMidCapGainerEntity.setLow(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setLow(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLastPrice());
                    moneyControlBSEMidCapGainerEntity.setLastPrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setLastPrice(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPreviousClose());
                    moneyControlBSEMidCapGainerEntity.setPreviousClose(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPreviousClose(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getChange());
                    moneyControlBSEMidCapGainerEntity.setVariation(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setVariation(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPercentageGain());
                    moneyControlBSEMidCapGainerEntity.setPercentageGain(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPercentageGain(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume5Days());
                    moneyControlBSEMidCapGainerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setAverageVolume5Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume10Days());
                    moneyControlBSEMidCapGainerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setAverageVolume10Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume30Days());
                    moneyControlBSEMidCapGainerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setAverageVolume30Days(String.valueOf(0.00));
                }


                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage30D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage30Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage30Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage50D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage50Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage50Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage150D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage150Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage150Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage200D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage200Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage200Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToEarningRatio());
                    moneyControlBSEMidCapGainerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPriceToEarningRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToBookRatio());
                    moneyControlBSEMidCapGainerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPriceToBookRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getUpperCircuit());
                    moneyControlBSEMidCapGainerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setUpperCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLowerCircuit());
                    moneyControlBSEMidCapGainerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setLowerCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getVolumeWeightedAveragePrice());
                    moneyControlBSEMidCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
                }

                Date toDate = new Date();
                moneyControlBSEMidCapGainerEntity.setCreatedDate(toDate);
                moneyControlBSEMidCapGainerEntity.setModifiedDate(toDate);
                moneyControlBSEMidCapGainerEntity.setCreatedBy("SYSTEM");
                moneyControlBSEMidCapGainerEntity.setModifiedBy("SYSTEM");

                entities.add(moneyControlBSEMidCapGainerEntity);
            }
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
