package rave.code.quartz.job.moneycontrol.trading;

import rave.code.data.parser.html.moneycontrol.BSEActive200Parser;
import rave.code.quartz.job.moneycontrol.AbstractJob;
import rave.code.stockmarket.bse.dataaccess.BSEActive200DataAccess;
import rave.code.stockmarket.bse.entity.BSEActive200Entity;
import rave.code.website.data.model.moneycontrol.BSEGenericActiveModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEActive200Job extends AbstractJob<BSEGenericActiveModel, BSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive200Job.class.getName());

    private BSEActive200DataAccess bseActive200DataAccess = new BSEActive200DataAccess(BSEActive200Entity.class);

    @Override
    public List<BSEGenericActiveModel> getDataFromSource() {
        BSEActive200Parser moneyControlBSEActive200Parser = new BSEActive200Parser();
        List<BSEGenericActiveModel> moneyControlBSEActive200Models = moneyControlBSEActive200Parser.parse();
        return moneyControlBSEActive200Models;
    }

    @Override
    public List<BSEActive200Entity> transformSourceData(List<BSEGenericActiveModel> sourceData) {

        List<BSEActive200Entity> moneyControlBSEActive200Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (BSEGenericActiveModel bseActive200Model : sourceData) {


            BSEActive200Entity bseActive200Entity = this.bseActive200DataAccess.findBy(bseActive200Model.getCompanyName());
            if (null == bseActive200Entity) {
                bseActive200Entity = new BSEActive200Entity();
                bseActive200Entity.setCompanyName(bseActive200Model.getCompanyName());
            }
            bseActive200Entity.setCategory(bseActive200Model.getGroup());
            Number value = null;

            try {
                value = format.parse(bseActive200Model.getHigh());
                bseActive200Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getLow());
                bseActive200Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Entity.getLastPrice());
                String lastPrice = String.valueOf(value.doubleValue());
                bseActive200Entity.setLastPrice(lastPrice);
                if (bseActive200Entity.isNewEntity()) {
                    bseActive200Entity.setLastPriceMovement(lastPrice);
                } else {
                    bseActive200Entity.setLastPriceMovement(String.format("%s -> %s", bseActive200Entity.getLastPriceMovement(), lastPrice));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getPercentageChange());
                bseActive200Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getValueInCrores());
                bseActive200Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getAverageVolume5Days());
                bseActive200Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getAverageVolume10Days());
                bseActive200Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getAverageVolume30Days());
                bseActive200Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getPriceToEarningRatio());
                bseActive200Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getPriceToBookRatio());
                bseActive200Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getUpperCircuit());
                bseActive200Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getLowerCircuit());
                bseActive200Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getVolumeWeightedAveragePrice());
                bseActive200Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage30D());
                bseActive200Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage50D());
                bseActive200Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage150D());
                bseActive200Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage200D());
                bseActive200Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bseActive200Entity.setCreatedDate(toDate);
            bseActive200Entity.setModifiedDate(toDate);
            bseActive200Entity.setCreatedBy("SYSTEM");
            bseActive200Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive200Entities.add(bseActive200Entity);
        }
        return moneyControlBSEActive200Entities;
    }

    @Override
    public void saveTransformedData(List<BSEActive200Entity> transformedData) {
        for (BSEActive200Entity bseActive200Entity : transformedData) {
            if (bseActive200Entity.isNewEntity()) {
                this.bseActive200DataAccess.save(bseActive200Entity);
            } else {
                this.bseActive200DataAccess.update(bseActive200Entity);
            }
        }
    }
}