package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.dataaccess.BSEActive200DataAccess;
import rave.code.stockmarket.entity.BSEActive200Entity;

import java.util.Date;

public class TestBSEActive200DataAccess extends TestCase {

    public void testSaveMethod() {
        BSEActive200Entity bseActive200Entity = new BSEActive200Entity();

        bseActive200Entity.setStockName("test-company" + new Date().getTime());
        bseActive200Entity.setHigh("20");
        bseActive200Entity.setLow("10");
        bseActive200Entity.setCategory("some-category");
        bseActive200Entity.setLastPrice("34.5");
        bseActive200Entity.setPercentageChange("2.1");
        bseActive200Entity.setValueInCrores("23");
        Date toDate = new Date();
        bseActive200Entity.setCreatedDate(toDate);
        bseActive200Entity.setModifiedDate(toDate);
        bseActive200Entity.setCreatedBy("SYSTEM");
        bseActive200Entity.setModifiedBy("SYSTEM");

        BSEActive200DataAccess moneyControlBSEActive200DataAccess = new BSEActive200DataAccess(BSEActive200Entity.class);

        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getCategory());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getHigh());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getLow());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseActive200Entity.getModifiedBy());

        moneyControlBSEActive200DataAccess.save(bseActive200Entity);
        BSEActive200Entity returnElement = moneyControlBSEActive200DataAccess.findBy(bseActive200Entity.getStockName());
        assertNotNull(returnElement);
    }

}
