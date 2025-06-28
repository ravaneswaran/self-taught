package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.dataaccess.BSESmallCapGainerDataAccess;
import rave.code.stockmarket.entity.BSESmallCapGainerEntity;

import java.util.Date;

public class TestBSESmallCapGainerDataAccess extends TestCase {

    public void testSaveMethod() {
        BSESmallCapGainerEntity bseSmallCapGainerEntity = new BSESmallCapGainerEntity();

        bseSmallCapGainerEntity.setStockName("test-" + new Date().getTime());
        bseSmallCapGainerEntity.setHigh("20");
        bseSmallCapGainerEntity.setLow("10");
        bseSmallCapGainerEntity.setVariation("2");
        bseSmallCapGainerEntity.setLastPrice("34");
        bseSmallCapGainerEntity.setPercentageGain("4");
        bseSmallCapGainerEntity.setPreviousClose("21");
        Date toDate = new Date();
        bseSmallCapGainerEntity.setCreatedDate(toDate);
        bseSmallCapGainerEntity.setModifiedDate(toDate);
        bseSmallCapGainerEntity.setCreatedBy("SYSTEM");
        bseSmallCapGainerEntity.setModifiedBy("SYSTEM");

        BSESmallCapGainerDataAccess moneyControlBSESmallCapGainerDataAccess = new BSESmallCapGainerDataAccess(BSESmallCapGainerEntity.class);

        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getVariation());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getHigh());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getPercentageGain());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getPreviousClose());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getLow());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getModifiedBy());

        moneyControlBSESmallCapGainerDataAccess.save(bseSmallCapGainerEntity);
        BSESmallCapGainerEntity returnElement = moneyControlBSESmallCapGainerDataAccess.findBy(bseSmallCapGainerEntity.getStockName());
        assertNotNull(returnElement);
    }

}
