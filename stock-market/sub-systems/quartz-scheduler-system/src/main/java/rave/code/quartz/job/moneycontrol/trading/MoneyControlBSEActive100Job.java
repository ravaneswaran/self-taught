package rave.code.quartz.job.moneycontrol.trading;

import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEActive100Parser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericBSEActiveModel;
import rave.code.quartz.job.moneycontrol.AbstractTradingJob;
import rave.code.stockmarket.bse.dataaccess.BSEActive100DataAccess;
import rave.code.stockmarket.bse.entity.BSEActive100Entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEActive100Job extends AbstractTradingJob<MoneyControlGenericBSEActiveModel, BSEActive100Entity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive100Job.class.getName());

    @Override
    public List<MoneyControlGenericBSEActiveModel> getDataFromSource() {
        MoneyControlBSEActive100Parser moneyControlBSEActive100Parser = new MoneyControlBSEActive100Parser();
        List<MoneyControlGenericBSEActiveModel> moneyControlBSEActive100Models = moneyControlBSEActive100Parser.parse();
        return moneyControlBSEActive100Models;
    }

    @Override
    public List<BSEActive100Entity> transformSourceData(List<MoneyControlGenericBSEActiveModel> sourceData) {

        List<BSEActive100Entity> moneyControlBSEActive100Entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (MoneyControlGenericBSEActiveModel moneyControlBSEActive100Model : sourceData) {
            BSEActive100Entity moneyControlBSEActive100Entity = new BSEActive100Entity();
            moneyControlBSEActive100Entity.setCompanyName(moneyControlBSEActive100Model.getCompanyName());
            moneyControlBSEActive100Entity.setCategory(moneyControlBSEActive100Model.getGroup());
            Number value = null;

            try {
                value = format.parse(moneyControlBSEActive100Model.getHigh());
                moneyControlBSEActive100Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getLow());
                moneyControlBSEActive100Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getLastPrice());
                moneyControlBSEActive100Entity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getPercentageChange());
                moneyControlBSEActive100Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getValueInCrores());
                moneyControlBSEActive100Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getAverageVolume5Days());
                moneyControlBSEActive100Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getAverageVolume10Days());
                moneyControlBSEActive100Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getAverageVolume30Days());
                moneyControlBSEActive100Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getPriceToEarningRatio());
                moneyControlBSEActive100Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getPriceToBookRatio());
                moneyControlBSEActive100Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getUpperCircuit());
                moneyControlBSEActive100Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getLowerCircuit());
                moneyControlBSEActive100Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getVolumeWeightedAveragePrice());
                moneyControlBSEActive100Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getDisplacedMovingAverage30D());
                moneyControlBSEActive100Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getDisplacedMovingAverage50D());
                moneyControlBSEActive100Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getDisplacedMovingAverage150D());
                moneyControlBSEActive100Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive100Model.getDisplacedMovingAverage200D());
                moneyControlBSEActive100Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive100Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            moneyControlBSEActive100Entity.setCreatedDate(toDate);
            moneyControlBSEActive100Entity.setModifiedDate(toDate);
            moneyControlBSEActive100Entity.setCreatedBy("SYSTEM");
            moneyControlBSEActive100Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive100Entities.add(moneyControlBSEActive100Entity);
        }

        return moneyControlBSEActive100Entities;
    }

    @Override
    public void saveTransformedData(List<BSEActive100Entity> transformedData) {
        BSEActive100DataAccess moneyControlBSEActive100DataAccess = new BSEActive100DataAccess(BSEActive100Entity.class);
        for (BSEActive100Entity moneyControlBSEActive100Entity : transformedData) {
            moneyControlBSEActive100DataAccess.save(moneyControlBSEActive100Entity);
        }
    }
}