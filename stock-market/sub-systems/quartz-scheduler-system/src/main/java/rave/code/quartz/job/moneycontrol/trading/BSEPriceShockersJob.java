package rave.code.quartz.job.moneycontrol.trading;

import rave.code.data.parser.html.moneycontrol.BSEPriceShockersParser;
import rave.code.quartz.job.moneycontrol.AbstractJob;
import rave.code.stockmarket.bse.dataaccess.BSEPriceShockerDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive100Entity;
import rave.code.stockmarket.bse.entity.BSEPriceShockerEntity;
import rave.code.website.data.model.moneycontrol.PriceShockerModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEPriceShockersJob extends AbstractJob<PriceShockerModel, BSEPriceShockerEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSEPriceShockersJob.class.getName());

    private BSEPriceShockerDataAccess bsePriceShockerDataAccess = new BSEPriceShockerDataAccess();

    @Override
    public List<PriceShockerModel> getDataFromSource() {
        BSEPriceShockersParser moneyControlBSEPriceShockersParser = new BSEPriceShockersParser();
        List<PriceShockerModel> moneyControlPriceShockerModels = moneyControlBSEPriceShockersParser.parse();
        return moneyControlPriceShockerModels;
    }

    @Override
    public List<BSEPriceShockerEntity> transformSourceData(List<PriceShockerModel> sourceData) {
        List<BSEPriceShockerEntity> bsePriceShockerEntities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (PriceShockerModel priceShockerModel : sourceData) {

            BSEPriceShockerEntity bsePriceShockerEntity = this.bsePriceShockerDataAccess.findBy(priceShockerModel.getCompanyName().trim());
            if (null == bsePriceShockerEntity) {
                bsePriceShockerEntity = new BSEPriceShockerEntity();
                bsePriceShockerEntity.setCompanyName(priceShockerModel.getCompanyName().trim());
            }

            bsePriceShockerEntity.setCategory(priceShockerModel.getGroup());
            bsePriceShockerEntity.setSector(priceShockerModel.getSector());

            Number value = null;
            try {
                value = format.parse(priceShockerModel.getCurrentPrice());
                String currentPrice = String.valueOf(value.doubleValue());
                bsePriceShockerEntity.setCurrentPrice(currentPrice);
                if (bsePriceShockerEntity.isNewEntity()) {
                    bsePriceShockerEntity.setCurrentPriceMovement(currentPrice);
                } else {
                    bsePriceShockerEntity.setCurrentPriceMovement(String.format("%s -> %s", bsePriceShockerEntity.getCurrentPriceMovement(), currentPrice));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setCurrentPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getPreviousPrice());
                bsePriceShockerEntity.setPreviousPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setPreviousPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getPercentageChange());
                bsePriceShockerEntity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getAverageVolume5Days());
                bsePriceShockerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getAverageVolume10Days());
                bsePriceShockerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getAverageVolume30Days());
                bsePriceShockerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getPriceToEarningRatio());
                bsePriceShockerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getPriceToBookRatio());
                bsePriceShockerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getUpperCircuit());
                bsePriceShockerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getLowerCircuit());
                bsePriceShockerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getVolumeWeightedAveragePrice());
                bsePriceShockerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getDisplacedMovingAverage30D());
                bsePriceShockerEntity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getDisplacedMovingAverage50D());
                bsePriceShockerEntity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getDisplacedMovingAverage150D());
                bsePriceShockerEntity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(priceShockerModel.getDisplacedMovingAverage200D());
                bsePriceShockerEntity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bsePriceShockerEntity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bsePriceShockerEntity.setCreatedDate(toDate);
            bsePriceShockerEntity.setModifiedDate(toDate);
            bsePriceShockerEntity.setCreatedBy("SYSTEM");
            bsePriceShockerEntity.setModifiedBy("SYSTEM");

            bsePriceShockerEntities.add(bsePriceShockerEntity);
        }

        return bsePriceShockerEntities;
    }

    @Override
    public void saveTransformedData(List<BSEPriceShockerEntity> transformedData) {
        this.bsePriceShockerDataAccess.bulkUpsert(transformedData);
    }
}
