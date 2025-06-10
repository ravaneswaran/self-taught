package rave.code.quartz.job.moneycontrol.trading;

import rave.code.data.parser.html.moneycontrol.BSEPriceShockersParser;
import rave.code.website.data.model.moneycontrol.PriceShockerModel;
import rave.code.quartz.job.moneycontrol.AbstractJob;
import rave.code.stockmarket.bse.dataaccess.BSEPriceShockerDataAccess;
import rave.code.stockmarket.bse.entity.BSEPriceShockerEntity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlPriceShockersJob extends AbstractJob<PriceShockerModel, BSEPriceShockerEntity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlPriceShockersJob.class.getName());

    @Override
    public List<PriceShockerModel> getDataFromSource() {
        BSEPriceShockersParser moneyControlBSEPriceShockersParser = new BSEPriceShockersParser();
        List<PriceShockerModel> moneyControlPriceShockerModels = moneyControlBSEPriceShockersParser.parse();
        return moneyControlPriceShockerModels;
    }

    @Override
    public List<BSEPriceShockerEntity> transformSourceData(List<PriceShockerModel> sourceData) {
        List<BSEPriceShockerEntity> moneyControlBSEPriceShockerEntities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (PriceShockerModel moneyControlPriceShockerModel : sourceData) {
            BSEPriceShockerEntity moneyControlBSEPriceShockerEntity = new BSEPriceShockerEntity();

            moneyControlBSEPriceShockerEntity.setCompanyName(moneyControlPriceShockerModel.getCompanyName());
            moneyControlBSEPriceShockerEntity.setCategory(moneyControlPriceShockerModel.getGroup());
            moneyControlBSEPriceShockerEntity.setSector(moneyControlPriceShockerModel.getSector());

            Number value = null;
            try {
                value = format.parse(moneyControlPriceShockerModel.getCurrentPrice());
                moneyControlBSEPriceShockerEntity.setCurrentPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setCurrentPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getPreviousPrice());
                moneyControlBSEPriceShockerEntity.setPreviousPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setPreviousPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getPercentageChange());
                moneyControlBSEPriceShockerEntity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getAverageVolume5Days());
                moneyControlBSEPriceShockerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getAverageVolume10Days());
                moneyControlBSEPriceShockerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getAverageVolume30Days());
                moneyControlBSEPriceShockerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getPriceToEarningRatio());
                moneyControlBSEPriceShockerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getPriceToBookRatio());
                moneyControlBSEPriceShockerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getUpperCircuit());
                moneyControlBSEPriceShockerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getLowerCircuit());
                moneyControlBSEPriceShockerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getVolumeWeightedAveragePrice());
                moneyControlBSEPriceShockerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getDisplacedMovingAverage30D());
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getDisplacedMovingAverage50D());
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getDisplacedMovingAverage150D());
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlPriceShockerModel.getDisplacedMovingAverage200D());
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            moneyControlBSEPriceShockerEntity.setCreatedDate(toDate);
            moneyControlBSEPriceShockerEntity.setModifiedDate(toDate);
            moneyControlBSEPriceShockerEntity.setCreatedBy("SYSTEM");
            moneyControlBSEPriceShockerEntity.setModifiedBy("SYSTEM");

            moneyControlBSEPriceShockerEntities.add(moneyControlBSEPriceShockerEntity);
        }

        return moneyControlBSEPriceShockerEntities;
    }

    @Override
    public void saveTransformedData(List<BSEPriceShockerEntity> transformedData) {
        BSEPriceShockerDataAccess moneyControlBSEPriceShockerDataAccess = new BSEPriceShockerDataAccess(BSEPriceShockerEntity.class);
        for (BSEPriceShockerEntity moneyControlBSEPriceShockerEntity : transformedData) {
            moneyControlBSEPriceShockerDataAccess.save(moneyControlBSEPriceShockerEntity);
        }
    }
}
