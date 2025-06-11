package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSESmallCapGainerEntity;

import java.util.Date;

public class TestBSESmallCapGainerDataAccess extends TestCase {

    public void testSaveMethod() {
        BSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity = new BSESmallCapGainerEntity();

        moneyControlBSESmallCapGainerEntity.setCompanyName("test-" + new Date().getTime());
        moneyControlBSESmallCapGainerEntity.setHigh("some-high");
        moneyControlBSESmallCapGainerEntity.setLow("some-low");
        moneyControlBSESmallCapGainerEntity.setVariation("some-change");
        moneyControlBSESmallCapGainerEntity.setLastPrice("some-price");
        moneyControlBSESmallCapGainerEntity.setPercentageGain("some-percentage-gain");
        moneyControlBSESmallCapGainerEntity.setPreviousClose("some-previous-close");
        Date toDate = new Date();
        moneyControlBSESmallCapGainerEntity.setCreatedDate(toDate);
        moneyControlBSESmallCapGainerEntity.setModifiedDate(toDate);
        moneyControlBSESmallCapGainerEntity.setCreatedBy("SYSTEM");
        moneyControlBSESmallCapGainerEntity.setModifiedBy("SYSTEM");

        BSESmallCapGainerDataAccess moneyControlBSESmallCapGainerDataAccess = new BSESmallCapGainerDataAccess(BSESmallCapGainerEntity.class);

        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getVariation());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getCompanyName());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getHigh());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getPercentageGain());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getPreviousClose());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getLow());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSESmallCapGainerEntity.getModifiedBy());

        moneyControlBSESmallCapGainerDataAccess.save(moneyControlBSESmallCapGainerEntity);
        BSESmallCapGainerEntity returnElement = moneyControlBSESmallCapGainerDataAccess.findBy(moneyControlBSESmallCapGainerEntity.getCompanyName());
        assertNotNull(returnElement);
    }

}
