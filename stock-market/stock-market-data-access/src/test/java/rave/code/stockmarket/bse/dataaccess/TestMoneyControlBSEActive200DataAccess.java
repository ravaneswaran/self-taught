package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;

import java.util.Date;

public class TestMoneyControlBSEActive200DataAccess extends TestCase {

    public void testSaveMethod(){
        MoneyControlBSEActive200Entity moneyControlBSEActive200Entity = new MoneyControlBSEActive200Entity();

        moneyControlBSEActive200Entity.setCompanyName("test-company");
        moneyControlBSEActive200Entity.setHigh("some-high");
        moneyControlBSEActive200Entity.setLow("some-low");
        moneyControlBSEActive200Entity.setVariation("some-change");
        moneyControlBSEActive200Entity.setLastPrice("some-price");
        moneyControlBSEActive200Entity.setPercentageGain("some-percentage-gain");
        moneyControlBSEActive200Entity.setPreviousClose("some-previous-close");
        Date toDate = new Date();
        moneyControlBSEActive200Entity.setCreatedDate(toDate);
        moneyControlBSEActive200Entity.setModifiedDate(toDate);
        moneyControlBSEActive200Entity.setCreatedBy("SYSTEM");
        moneyControlBSEActive200Entity.setModifiedBy("SYSTEM");

        MoneyControlBSEActive200DataAccess moneyControlBSEActive200DataAccess = new MoneyControlBSEActive200DataAccess(MoneyControlBSEActive200Entity.class);

        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getId());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getVariation());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getCompanyName());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getHigh());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getPercentageGain());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getPreviousClose());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getLow());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive200Entity.getModifiedBy());

        moneyControlBSEActive200DataAccess.save(moneyControlBSEActive200Entity);
        MoneyControlBSEActive200Entity returnElement = moneyControlBSEActive200DataAccess.findBy(moneyControlBSEActive200Entity.getId());
        assertNotNull(returnElement);
    }

}
