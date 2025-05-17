package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;

import java.util.Date;

public class TestMoneyControlBSEActive100DataAccess extends TestCase {

    public void testSaveMethod(){
        MoneyControlBSEActive100Entity moneyControlBSEActive100Entity = new MoneyControlBSEActive100Entity();

        moneyControlBSEActive100Entity.setCompanyName("test-company");
        moneyControlBSEActive100Entity.setHigh("some-high");
        moneyControlBSEActive100Entity.setLow("some-low");
        moneyControlBSEActive100Entity.setVariation("some-change");
        moneyControlBSEActive100Entity.setLastPrice("some-price");
        moneyControlBSEActive100Entity.setPercentageGain("some-percentage-gain");
        moneyControlBSEActive100Entity.setPreviousClose("some-previous-close");
        Date toDate = new Date();
        moneyControlBSEActive100Entity.setCreatedDate(toDate);
        moneyControlBSEActive100Entity.setModifiedDate(toDate);
        moneyControlBSEActive100Entity.setCreatedBy("SYSTEM");
        moneyControlBSEActive100Entity.setModifiedBy("SYSTEM");

        MoneyControlBSEActive100DataAccess moneyControlBSEActive100DataAccess = new MoneyControlBSEActive100DataAccess(MoneyControlBSEActive100Entity.class);

        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getId());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getVariation());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getCompanyName());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getHigh());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getPercentageGain());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getPreviousClose());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getLow());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive100Entity.getModifiedBy());

        moneyControlBSEActive100DataAccess.save(moneyControlBSEActive100Entity);
        MoneyControlBSEActive100Entity returnElement = moneyControlBSEActive100DataAccess.findBy(moneyControlBSEActive100Entity.getId());
        assertNotNull(returnElement);
    }

}
