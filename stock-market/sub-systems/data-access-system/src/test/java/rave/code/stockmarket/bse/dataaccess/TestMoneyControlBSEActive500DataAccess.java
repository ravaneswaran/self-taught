package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500Entity;

import java.util.Date;

public class TestMoneyControlBSEActive500DataAccess extends TestCase {

    public void testSaveMethod(){
        MoneyControlBSEActive500Entity moneyControlBSEActive500Entity = new MoneyControlBSEActive500Entity();

        moneyControlBSEActive500Entity.setCompanyName("test-company");
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

        MoneyControlBSEActive500DataAccess moneyControlBSEActive500DataAccess = new MoneyControlBSEActive500DataAccess(MoneyControlBSEActive500Entity.class);

        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getId());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getCompanyName());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getCategory());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getHigh());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getLow());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSEActive500Entity.getModifiedBy());

        moneyControlBSEActive500DataAccess.save(moneyControlBSEActive500Entity);
        MoneyControlBSEActive500Entity returnElement = moneyControlBSEActive500DataAccess.findBy(moneyControlBSEActive500Entity.getId());
        assertNotNull(returnElement);
    }

}
