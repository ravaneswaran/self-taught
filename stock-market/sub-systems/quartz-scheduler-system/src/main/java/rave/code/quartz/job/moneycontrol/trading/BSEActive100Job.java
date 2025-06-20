package rave.code.quartz.job.moneycontrol.trading;

import rave.code.data.parser.html.moneycontrol.BSEActive100Parser;
import rave.code.quartz.job.moneycontrol.AbstractJob;
import rave.code.stockmarket.bse.dataaccess.BSEActive100DataAccess;
import rave.code.stockmarket.bse.entity.BSEActive100Entity;
import rave.code.website.data.model.moneycontrol.BSEGenericActiveModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEActive100Job extends AbstractJob<BSEGenericActiveModel, BSEActive100Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive100Job.class.getName());

    private BSEActive100DataAccess bseActive100DataAccess = new BSEActive100DataAccess(BSEActive100Entity.class);

    @Override
    public List<BSEGenericActiveModel> getDataFromSource() {
        BSEActive100Parser moneyControlBSEActive100Parser = new BSEActive100Parser();
        List<BSEGenericActiveModel> moneyControlBSEActive100Models = moneyControlBSEActive100Parser.parse();
        return moneyControlBSEActive100Models;
    }

    @Override
    public List<BSEActive100Entity> transformSourceData(List<BSEGenericActiveModel> sourceData) {

        List<BSEActive100Entity> moneyControlBSEActive100Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (BSEGenericActiveModel bseActive100Model : sourceData) {

            BSEActive100Entity bseActive100Entity = this.bseActive100DataAccess.findBy(bseActive100Model.getCompanyName());
            if (null == bseActive100Entity) {
                bseActive100Entity = new BSEActive100Entity();
                bseActive100Entity.setCompanyName(bseActive100Model.getCompanyName());
            }

            bseActive100Entity.setCategory(bseActive100Model.getGroup());

            Number value = null;
            try {
                value = format.parse(bseActive100Model.getHigh());
                bseActive100Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getLow());
                bseActive100Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getLastPrice());
                String lastPrice = String.valueOf(value.doubleValue());
                bseActive100Entity.setLastPrice(lastPrice);
                if (bseActive100Entity.isNewEntity()) {
                    bseActive100Entity.setLastPriceMovement(lastPrice);
                } else {
                    bseActive100Entity.setLastPriceMovement(String.format("%s -> %s", bseActive100Entity.getLastPriceMovement(), lastPrice));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getPercentageChange());
                bseActive100Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getValueInCrores());
                bseActive100Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getAverageVolume5Days());
                bseActive100Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getAverageVolume10Days());
                bseActive100Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getAverageVolume30Days());
                bseActive100Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getPriceToEarningRatio());
                bseActive100Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getPriceToBookRatio());
                bseActive100Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getUpperCircuit());
                bseActive100Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getLowerCircuit());
                bseActive100Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getVolumeWeightedAveragePrice());
                bseActive100Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage30D());
                bseActive100Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage50D());
                bseActive100Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage150D());
                bseActive100Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage200D());
                bseActive100Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bseActive100Entity.setCreatedDate(toDate);
            bseActive100Entity.setModifiedDate(toDate);
            bseActive100Entity.setCreatedBy("SYSTEM");
            bseActive100Entity.setModifiedBy("SYSTEM");

            moneyControlBSEActive100Entities.add(bseActive100Entity);
        }

        return moneyControlBSEActive100Entities;
    }

    @Override
    public void saveTransformedData(List<BSEActive100Entity> transformedData) {
        for (BSEActive100Entity bseActive100Entity : transformedData) {
            if (bseActive100Entity.isNewEntity()) {
                this.bseActive100DataAccess.save(bseActive100Entity);
            } else {
                this.bseActive100DataAccess.update(bseActive100Entity);
            }
        }
    }
}