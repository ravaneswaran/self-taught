package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSEActive100Entity;

import java.util.Date;

public class TestBSEActive100DataAccess extends TestCase {

    public void testSaveMethod() {
        BSEActive100Entity moneyControlBSEActive100Entity = new BSEActive100Entity();

        moneyControlBSEActive100Entity.setCompanyName("test-company" + new Date().getTime());
        moneyControlBSEActive100Entity.setHigh("some-high");
        moneyControlBSEActive100Entity.setLow("some-low");
        moneyControlBSEActive100Entity.setCategory("some-category");
        moneyControlBSEActive100Entity.setLastPrice("some-price");
        moneyControlBSEActive100Entity.setPercentageChange("some-percentage-change");
        moneyControlBSEActive100Entity.setValueInCrores("some-value-in-crores");
        Date toDate = new Date();
        moneyControlBSEActive100Entity.setCreatedDate(toDate);
        moneyControlBSEActive100Entity.setModifiedDate(toDate);
        moneyControlBSEActive100Entity.setCreatedBy("SYSTEM");
        moneyControlBSEActive100Entity.setModifiedBy("SYSTEM");

        BSEActive100DataAccess moneyControlBSEActive100DataAccess = new BSEActive100DataAccess(BSEActive100Entity.class);

        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getCompanyName());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getCategory());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getHigh());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getLow());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + moneyControlBSEActive100Entity.getModifiedBy());

        moneyControlBSEActive100DataAccess.save(moneyControlBSEActive100Entity);
        BSEActive100Entity returnElement = moneyControlBSEActive100DataAccess.findBy(moneyControlBSEActive100Entity.getCompanyName());
        assertNotNull(returnElement);
    }

}
