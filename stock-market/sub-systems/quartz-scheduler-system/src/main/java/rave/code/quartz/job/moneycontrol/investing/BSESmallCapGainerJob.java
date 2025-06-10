package rave.code.quartz.job.moneycontrol.investing;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSESmallCapGainersParser;
import rave.code.moneycontrol.website.data.model.MoneyControlCapGainerModel;
import rave.code.quartz.job.moneycontrol.AbstractTradingJob;
import rave.code.stockmarket.bse.dataaccess.BSESmallCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.BSESmallCapGainerEntity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSESmallCapGainerJob extends AbstractTradingJob<MoneyControlCapGainerModel, BSESmallCapGainerEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSESmallCapGainerJob.class.getName());

    @Override
    public List<MoneyControlCapGainerModel> getDataFromSource() {
        MoneyControlBSESmallCapGainersParser moneyControlBSESmallCapGainersParser = new MoneyControlBSESmallCapGainersParser();
        return moneyControlBSESmallCapGainersParser.parse();
    }

    @Override
    public List<BSESmallCapGainerEntity> transformSourceData(List<MoneyControlCapGainerModel> sourceData) {
        List<BSESmallCapGainerEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (MoneyControlCapGainerModel moneyControlCapGainerModel : sourceData) {
            BSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity = new BSESmallCapGainerEntity();

            String companyName = moneyControlCapGainerModel.getCompanyName();
            if (null != companyName && !"".equals(companyName)) {
                moneyControlBSESmallCapGainerEntity.setCompanyName(moneyControlCapGainerModel.getCompanyName());
                Number value = null;

                try {
                    value = format.parse(moneyControlCapGainerModel.getHigh());
                    moneyControlBSESmallCapGainerEntity.setHigh(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setHigh(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLow());
                    moneyControlBSESmallCapGainerEntity.setLow(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLow(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLastPrice());
                    moneyControlBSESmallCapGainerEntity.setLastPrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLastPrice(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPreviousClose());
                    moneyControlBSESmallCapGainerEntity.setPreviousClose(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPreviousClose(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getChange());
                    moneyControlBSESmallCapGainerEntity.setVariation(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setVariation(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPercentageGain());
                    moneyControlBSESmallCapGainerEntity.setPercentageGain(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPercentageGain(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume5Days());
                    moneyControlBSESmallCapGainerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setAverageVolume5Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume10Days());
                    moneyControlBSESmallCapGainerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setAverageVolume10Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume30Days());
                    moneyControlBSESmallCapGainerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setAverageVolume30Days(String.valueOf(0.00));
                }


                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage30D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage30Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage30Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage50D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage50Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage50Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage150D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage150Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage150Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage200D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage200Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage200Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToEarningRatio());
                    moneyControlBSESmallCapGainerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPriceToEarningRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToBookRatio());
                    moneyControlBSESmallCapGainerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPriceToBookRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getUpperCircuit());
                    moneyControlBSESmallCapGainerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setUpperCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLowerCircuit());
                    moneyControlBSESmallCapGainerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLowerCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getVolumeWeightedAveragePrice());
                    moneyControlBSESmallCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
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
    public void saveTransformedData(List<BSESmallCapGainerEntity> transformedData) {
        BSESmallCapGainerDataAccess moneyControlBSESmallCapGainerDataAccess = new BSESmallCapGainerDataAccess(BSESmallCapGainerEntity.class);
        moneyControlBSESmallCapGainerDataAccess.bulkUpsert(transformedData);
    }
}
