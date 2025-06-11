package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSEActive200Entity;

import java.util.Date;

public class TestBSEActive200DataAccess extends TestCase {

    public void testSaveMethod() {
        BSEActive200Entity moneyControlBSEActive200Entity = new BSEActive200Entity();

        moneyControlBSEActive200Entity.setCompanyName("test-company" + new Date().getTime());
        moneyControlBSEActive200Entity.setHigh("some-high");
        moneyControlBSEActive200Entity.setLow("some-low");
        moneyControlBSEActive200Entity.setCategory("some-category");
        moneyControlBSEActive200Entity.setLastPrice("some-price");
        moneyControlBSEActive200Entity.setPercentageChange("some-percentage-change");
        moneyControlBSEActive200Entity.setValueInCrores("some-value-in-crores");
        Date toDate = new Date();
        moneyControlBSEActive200Entity.setCreatedDate(toDate);
        moneyControlBSEActive200Entity.setModifiedDate(toDate);
        moneyControlBSEActive200Entity.setCreatedBy("SYSTEM");
        moneyControlBSEActive200Entity.setModifiedBy("SYSTEM");

        BSEActive200DataAccess moneyControlBSEActive200DataAccess = new BSEActive200DataAccess(BSEActive200Entity.class);

        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getCompanyName());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getCategory());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getHigh());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getLow());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive200Entity.getModifiedBy());

        moneyControlBSEActive200DataAccess.save(moneyControlBSEActive200Entity);
        BSEActive200Entity returnElement = moneyControlBSEActive200DataAccess.findBy(moneyControlBSEActive200Entity.getCompanyName());
        assertNotNull(returnElement);
    }

}
