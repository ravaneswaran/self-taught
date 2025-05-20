package rave.code.moneycontrol.bse.quartz.job;

import org.quartz.JobExecutionException;
import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEActive200Parser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericBSEActiveModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive200DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEActive200Job extends AbstractMoneyControlBSEJob<MoneyControlGenericBSEActiveModel, MoneyControlBSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive200Job.class.getName());

    @Override
    public List<MoneyControlGenericBSEActiveModel> getDataFromSource() {
        MoneyControlBSEActive200Parser moneyControlBSEActive200Parser = new MoneyControlBSEActive200Parser();
        List<MoneyControlGenericBSEActiveModel> moneyControlBSEActive200Models = moneyControlBSEActive200Parser.parse();
        return moneyControlBSEActive200Models;
    }

    @Override
    public List<MoneyControlBSEActive200Entity> transformSourceData(List<MoneyControlGenericBSEActiveModel> sourceData) {
        List<MoneyControlBSEActive200Entity> moneyControlBSEActive200Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (MoneyControlGenericBSEActiveModel moneyControlBSEActive200Model : sourceData) {
            MoneyControlBSEActive200Entity moneyControlBSEActive200Entity = new MoneyControlBSEActive200Entity();
            moneyControlBSEActive200Entity.setCompanyName(moneyControlBSEActive200Model.getCompanyName());
            moneyControlBSEActive200Entity.setCategory(moneyControlBSEActive200Model.getGroup());
            Number value = null;

            try {
                value = format.parse(moneyControlBSEActive200Model.getHigh());
                moneyControlBSEActive200Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getLow());
                moneyControlBSEActive200Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getLastPrice());
                moneyControlBSEActive200Entity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getPercentageChange());
                moneyControlBSEActive200Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getValueInCrores());
                moneyControlBSEActive200Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getAverageVolume5Days());
                moneyControlBSEActive200Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getAverageVolume10Days());
                moneyControlBSEActive200Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getAverageVolume30Days());
                moneyControlBSEActive200Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getPriceToEarningRatio());
                moneyControlBSEActive200Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getPriceToBookRatio());
                moneyControlBSEActive200Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getUpperCircuit());
                moneyControlBSEActive200Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getLowerCircuit());
                moneyControlBSEActive200Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getVolumeWeightedAveragePrice());
                moneyControlBSEActive200Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getDisplacedMovingAverage30D());
                moneyControlBSEActive200Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getDisplacedMovingAverage50D());
                moneyControlBSEActive200Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getDisplacedMovingAverage150D());
                moneyControlBSEActive200Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive200Model.getDisplacedMovingAverage200D());
                moneyControlBSEActive200Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive200Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            moneyControlBSEActive200Entity.setCreatedDate(toDate);
            moneyControlBSEActive200Entity.setModifiedDate(toDate);
            moneyControlBSEActive200Entity.setCreatedBy("SYSTEM");
            moneyControlBSEActive200Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive200Entities.add(moneyControlBSEActive200Entity);
        }
        return moneyControlBSEActive200Entities;
    }

    @Override
    public void saveTransformedData(List<MoneyControlBSEActive200Entity> transformedData) {
        MoneyControlBSEActive200DataAccess moneyControlBSEActive200DataAccess = new MoneyControlBSEActive200DataAccess(MoneyControlBSEActive200Entity.class);
        for (MoneyControlBSEActive200Entity moneyControlBSEActive200Entity : transformedData) {
            moneyControlBSEActive200DataAccess.save(moneyControlBSEActive200Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive200Job moneyControlBSEActive200Job = new MoneyControlBSEActive200Job();
        moneyControlBSEActive200Job.execute(null);
    }
}