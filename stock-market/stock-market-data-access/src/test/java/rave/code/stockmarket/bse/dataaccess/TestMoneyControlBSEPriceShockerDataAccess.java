package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEPriceShockerEntity;

import java.util.Date;

public class TestMoneyControlBSEPriceShockerDataAccess extends TestCase {

    public void testSaveMethod(){
        MoneyControlBSEPriceShockerEntity moneyControlBSEPriceShockerEntity = new MoneyControlBSEPriceShockerEntity();

        moneyControlBSEPriceShockerEntity.setCompanyName("test-company");
        moneyControlBSEPriceShockerEntity.setCategory("some-high");
        moneyControlBSEPriceShockerEntity.setSector("some-sector");
        moneyControlBSEPriceShockerEntity.setCategory("some-category");
        moneyControlBSEPriceShockerEntity.setCurrentPrice("some-current-price");
        moneyControlBSEPriceShockerEntity.setPreviousPrice("some-previous-price");
        moneyControlBSEPriceShockerEntity.setPercentageChange("some-percentage-change");
        moneyControlBSEPriceShockerEntity.setAverageVolume5Days("5d-averrage-volume");
        moneyControlBSEPriceShockerEntity.setAverageVolume10Days("10d-average-volume");
        moneyControlBSEPriceShockerEntity.setAverageVolume30Days("30d-average-volume");
        moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage30D("30d-dma");
        moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage50D("50d-dma");
        moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage150D("150d-dma");
        moneyControlBSEPriceShockerEntity.setDisplacedMovingAverage200D("200-dma");
        moneyControlBSEPriceShockerEntity.setPriceToEarningRatio("some-pe-ratio");
        moneyControlBSEPriceShockerEntity.setPriceToBookRatio("some-pb-ratio");
        moneyControlBSEPriceShockerEntity.setUpperCircuit("some-upper-circuit");
        moneyControlBSEPriceShockerEntity.setLowerCircuit("some-lower-circuit");
        moneyControlBSEPriceShockerEntity.setVolumeWeightedAveragePrice("some-vwap");

        Date toDate = new Date();
        moneyControlBSEPriceShockerEntity.setCreatedDate(toDate);
        moneyControlBSEPriceShockerEntity.setModifiedDate(toDate);
        moneyControlBSEPriceShockerEntity.setCreatedBy("SYSTEM");
        moneyControlBSEPriceShockerEntity.setModifiedBy("SYSTEM");

        MoneyControlBSEPriceShockerDataAccess moneyControlBSEPriceShockerDataAccess = new MoneyControlBSEPriceShockerDataAccess(MoneyControlBSEPriceShockerEntity.class);

        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getId());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getCompanyName());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getCategory());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getSector());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getCurrentPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getPreviousPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getPercentageChange());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getAverageVolume5Days());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getAverageVolume10Days());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getAverageVolume30Days());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getDisplacedMovingAverage30D());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getDisplacedMovingAverage50D());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getDisplacedMovingAverage150D());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getDisplacedMovingAverage200D());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getPriceToEarningRatio());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getPriceToBookRatio());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getLowerCircuit());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getUpperCircuit());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEPriceShockerEntity.getModifiedBy());

        moneyControlBSEPriceShockerDataAccess.save(moneyControlBSEPriceShockerEntity);
        MoneyControlBSEPriceShockerEntity returnElement = moneyControlBSEPriceShockerDataAccess.findBy(moneyControlBSEPriceShockerEntity.getId());
        assertNotNull(returnElement);
    }

}
