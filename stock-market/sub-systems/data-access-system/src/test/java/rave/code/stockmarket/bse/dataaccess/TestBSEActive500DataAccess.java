package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSEActive500Entity;

import java.util.Date;

public class TestBSEActive500DataAccess extends TestCase {

    public void testSaveMethod() {
        BSEActive500Entity moneyControlBSEActive500Entity = new BSEActive500Entity();

        moneyControlBSEActive500Entity.setCompanyName("test-company" + new Date().getTime());
        moneyControlBSEActive500Entity.setHigh("some-high");
        moneyControlBSEActive500Entity.setLow("some-low");
        moneyControlBSEActive500Entity.setCategory("some-category");
        moneyControlBSEActive500Entity.setLastPrice("some-price");
        moneyControlBSEActive500Entity.setPercentageChange("some-percentage-change");
        moneyControlBSEActive500Entity.setValueInCrores("some-value-in-crores");
        Date toDate = new Date();
        moneyControlBSEActive500Entity.setCreatedDate(toDate);
        moneyControlBSEActive500Entity.setModifiedDate(toDate);
        moneyControlBSEActive500Entity.setCreatedBy("SYSTEM");
        moneyControlBSEActive500Entity.setModifiedBy("SYSTEM");

        BSEActive500DataAccess moneyControlBSEActive500DataAccess = new BSEActive500DataAccess(BSEActive500Entity.class);

        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getCompanyName());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getCategory());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getHigh());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getLow());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive500Entity.getModifiedBy());

        moneyControlBSEActive500DataAccess.save(moneyControlBSEActive500Entity);
        BSEActive500Entity returnElement = moneyControlBSEActive500DataAccess.findBy(moneyControlBSEActive500Entity.getCompanyName());
        assertNotNull(returnElement);
    }

}
