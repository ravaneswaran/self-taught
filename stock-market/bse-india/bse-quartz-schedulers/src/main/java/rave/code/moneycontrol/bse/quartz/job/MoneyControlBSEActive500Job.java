package rave.code.moneycontrol.bse.quartz.job;

import org.quartz.JobExecutionException;
import rave.code.moneycontrol.bse.data.parser.html.MoneyControlBSEActive500Parser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericBSEActiveModel;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive500DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500Entity;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEActive500Job extends AbstractMoneyControlBSEJob<MoneyControlGenericBSEActiveModel, MoneyControlBSEActive500Entity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive500Job.class.getName());

    @Override
    public List<MoneyControlGenericBSEActiveModel> getDataFromSource() {
        MoneyControlBSEActive500Parser moneyControlBSEActive500Parser = new MoneyControlBSEActive500Parser();
        List<MoneyControlGenericBSEActiveModel> moneyControlBSEActive500Models = moneyControlBSEActive500Parser.parse();
        return moneyControlBSEActive500Models;
    }

    @Override
    public List<MoneyControlBSEActive500Entity> transformSourceData(List<MoneyControlGenericBSEActiveModel> sourceData) {

        System.out.println("----------------------->>>>>> "+sourceData.size());

        List<MoneyControlBSEActive500Entity> moneyControlBSEActive500Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (MoneyControlGenericBSEActiveModel moneyControlBSEActive500Model : sourceData) {
            MoneyControlBSEActive500Entity moneyControlBSEActive500Entity = new MoneyControlBSEActive500Entity();
            moneyControlBSEActive500Entity.setCompanyName(moneyControlBSEActive500Model.getCompanyName());
            moneyControlBSEActive500Entity.setCategory(moneyControlBSEActive500Model.getGroup());
            Number value = null;

            try {
                value = format.parse(moneyControlBSEActive500Model.getHigh());
                moneyControlBSEActive500Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getLow());
                moneyControlBSEActive500Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getLastPrice());
                moneyControlBSEActive500Entity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getPercentageChange());
                moneyControlBSEActive500Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getValueInCrores());
                moneyControlBSEActive500Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getAverageVolume5Days());
                moneyControlBSEActive500Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getAverageVolume10Days());
                moneyControlBSEActive500Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getAverageVolume30Days());
                moneyControlBSEActive500Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getPriceToEarningRatio());
                moneyControlBSEActive500Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getPriceToBookRatio());
                moneyControlBSEActive500Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getUpperCircuit());
                moneyControlBSEActive500Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getLowerCircuit());
                moneyControlBSEActive500Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getVolumeWeightedAveragePrice());
                moneyControlBSEActive500Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getDisplacedMovingAverage30D());
                moneyControlBSEActive500Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getDisplacedMovingAverage50D());
                moneyControlBSEActive500Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getDisplacedMovingAverage150D());
                moneyControlBSEActive500Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(moneyControlBSEActive500Model.getDisplacedMovingAverage200D());
                moneyControlBSEActive500Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                moneyControlBSEActive500Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            moneyControlBSEActive500Entity.setCreatedDate(toDate);
            moneyControlBSEActive500Entity.setModifiedDate(toDate);
            moneyControlBSEActive500Entity.setCreatedBy("SYSTEM");
            moneyControlBSEActive500Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive500Entities.add(moneyControlBSEActive500Entity);
        }
        return moneyControlBSEActive500Entities;
    }

    @Override
    public void saveTransformedData(List<MoneyControlBSEActive500Entity> transformedData) {
        MoneyControlBSEActive500DataAccess moneyControlBSEActive500DataAccess = new MoneyControlBSEActive500DataAccess(MoneyControlBSEActive500Entity.class);
        for (MoneyControlBSEActive500Entity moneyControlBSEActive500Entity : transformedData) {
            moneyControlBSEActive500DataAccess.save(moneyControlBSEActive500Entity);
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        MoneyControlBSEActive500Job moneyControlBSEActive500Job = new MoneyControlBSEActive500Job();
        moneyControlBSEActive500Job.execute(null);
    }
}
