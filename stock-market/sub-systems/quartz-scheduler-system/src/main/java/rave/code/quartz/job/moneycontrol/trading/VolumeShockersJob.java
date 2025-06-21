package rave.code.quartz.job.moneycontrol.trading;

import rave.code.data.parser.html.moneycontrol.BSEVolumeShockersParser;
import rave.code.quartz.job.moneycontrol.AbstractJob;
import rave.code.stockmarket.bse.dataaccess.BSEVolumeShockerDataAccess;
import rave.code.stockmarket.bse.entity.BSEVolumeShockerEntity;
import rave.code.website.data.model.moneycontrol.VolumeShockerModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VolumeShockersJob extends AbstractJob<VolumeShockerModel, BSEVolumeShockerEntity> {

    private static final Logger LOGGER = Logger.getLogger(VolumeShockersJob.class.getName());

    @Override
    public List<VolumeShockerModel> getDataFromSource() {
        BSEVolumeShockersParser bseVolumeShockersParser = new BSEVolumeShockersParser();
        List<VolumeShockerModel> volumeShockerModels = bseVolumeShockersParser.parse();
        return volumeShockerModels;
    }

    @Override
    public List<BSEVolumeShockerEntity> transformSourceData(List<VolumeShockerModel> sourceData) {
        List<BSEVolumeShockerEntity> bseVolumeShockerEntities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (VolumeShockerModel volumeShockerModel : sourceData) {
            BSEVolumeShockerEntity bseVolumeShockerEntity = new BSEVolumeShockerEntity();
            bseVolumeShockerEntity.setCompanyName(volumeShockerModel.getCompanyName());

            bseVolumeShockerEntity.setCategory(volumeShockerModel.getGroup());
            bseVolumeShockerEntity.setSector(volumeShockerModel.getSector());

            Number value = null;
            try {
                value = format.parse(volumeShockerModel.getLastPrice());
                bseVolumeShockerEntity.setLastPrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getAverageVolume());
                bseVolumeShockerEntity.setAverageVolume(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setAverageVolume(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getPercentageChange());
                bseVolumeShockerEntity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getAverageVolume5Days());
                bseVolumeShockerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getAverageVolume10Days());
                bseVolumeShockerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getAverageVolume30Days());
                bseVolumeShockerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getPriceToEarningRatio());
                bseVolumeShockerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getPriceToBookRatio());
                bseVolumeShockerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getUpperCircuit());
                bseVolumeShockerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getLowerCircuit());
                bseVolumeShockerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getVolumeWeightedAveragePrice());
                bseVolumeShockerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getDisplacedMovingAverage30D());
                bseVolumeShockerEntity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getDisplacedMovingAverage50D());
                bseVolumeShockerEntity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getDisplacedMovingAverage150D());
                bseVolumeShockerEntity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(volumeShockerModel.getDisplacedMovingAverage200D());
                bseVolumeShockerEntity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseVolumeShockerEntity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bseVolumeShockerEntity.setCreatedDate(toDate);
            bseVolumeShockerEntity.setModifiedDate(toDate);
            bseVolumeShockerEntity.setCreatedBy("SYSTEM");
            bseVolumeShockerEntity.setModifiedBy("SYSTEM");

            bseVolumeShockerEntities.add(bseVolumeShockerEntity);
        }

        return bseVolumeShockerEntities;
    }

    @Override
    public void saveTransformedData(List<BSEVolumeShockerEntity> transformedData) {
        BSEVolumeShockerDataAccess bseVolumeShockerDataAccess = new BSEVolumeShockerDataAccess(BSEVolumeShockerEntity.class);
        for (BSEVolumeShockerEntity bseVolumeShockerEntity : transformedData) {
            bseVolumeShockerDataAccess.save(bseVolumeShockerEntity);
        }
    }
}
