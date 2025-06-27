package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSEActive500Entity;

import java.util.Date;

public class TestBSEActive500DataAccess extends TestCase {

    public void testSaveMethod() {
        BSEActive500Entity bseActive500Entity = new BSEActive500Entity();

        bseActive500Entity.setStockName("test-company" + new Date().getTime());
        bseActive500Entity.setHigh("20");
        bseActive500Entity.setLow("10");
        bseActive500Entity.setCategory("some-category");
        bseActive500Entity.setLastPrice("34.5");
        bseActive500Entity.setPercentageChange("2.1");
        bseActive500Entity.setValueInCrores("23");
        Date toDate = new Date();
        bseActive500Entity.setCreatedDate(toDate);
        bseActive500Entity.setModifiedDate(toDate);
        bseActive500Entity.setCreatedBy("SYSTEM");
        bseActive500Entity.setModifiedBy("SYSTEM");

        BSEActive500DataAccess moneyControlBSEActive500DataAccess = new BSEActive500DataAccess(BSEActive500Entity.class);

        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getCategory());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getHigh());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getLow());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseActive500Entity.getModifiedBy());

        moneyControlBSEActive500DataAccess.save(bseActive500Entity);
        BSEActive500Entity returnElement = moneyControlBSEActive500DataAccess.findBy(bseActive500Entity.getStockName());
        assertNotNull(returnElement);
    }

}
