package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSEMidCapGainerEntity;

import java.util.Date;

public class TestBSEMidCapGainerDataAccess extends TestCase {

    public void testSaveMethod(){
        BSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity = new BSEMidCapGainerEntity();

        moneyControlBSEMidCapGainerEntity.setCompanyName("test-company-"+new Date().getTime());
        moneyControlBSEMidCapGainerEntity.setHigh("some-high");
        moneyControlBSEMidCapGainerEntity.setLow("some-low");
        moneyControlBSEMidCapGainerEntity.setVariation("some-change");
        moneyControlBSEMidCapGainerEntity.setLastPrice("some-price");
        moneyControlBSEMidCapGainerEntity.setPercentageGain("some-percentage-gain");
        moneyControlBSEMidCapGainerEntity.setPreviousClose("some-previous-close");
        Date toDate = new Date();
        moneyControlBSEMidCapGainerEntity.setCreatedDate(toDate);
        moneyControlBSEMidCapGainerEntity.setModifiedDate(toDate);
        moneyControlBSEMidCapGainerEntity.setCreatedBy("SYSTEM");
        moneyControlBSEMidCapGainerEntity.setModifiedBy("SYSTEM");

        BSEMidCapGainerDataAccess moneyControlBSEMidCapGainerDataAccess = new BSEMidCapGainerDataAccess(BSEMidCapGainerEntity.class);

        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getVariation());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getCompanyName());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getHigh());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getPercentageGain());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getPreviousClose());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getLow());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEMidCapGainerEntity.getModifiedBy());

        moneyControlBSEMidCapGainerDataAccess.save(moneyControlBSEMidCapGainerEntity);
        BSEMidCapGainerEntity returnElement = moneyControlBSEMidCapGainerDataAccess.findBy(moneyControlBSEMidCapGainerEntity.getCompanyName());
        assertNotNull(returnElement);
    }

}
