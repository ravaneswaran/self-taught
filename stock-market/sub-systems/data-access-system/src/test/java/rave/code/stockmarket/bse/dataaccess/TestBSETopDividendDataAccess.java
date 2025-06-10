package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSETopDividendEntity;

import java.util.Date;

public class TestBSETopDividendDataAccess extends TestCase {

    public void testSaveMethod(){
        BSETopDividendEntity moneyControlBSETopDividendEntity = new BSETopDividendEntity();

        moneyControlBSETopDividendEntity.setCompanyName("test-company-"+new Date().getTime());
        moneyControlBSETopDividendEntity.setLastPrice("some-price");

        moneyControlBSETopDividendEntity.setLatestDividendPercentage("some-percentage");
        moneyControlBSETopDividendEntity.setDividendYieldPercentage52High("some-high");
        moneyControlBSETopDividendEntity.setDividendYieldPercentage52Low("some-low");
        moneyControlBSETopDividendEntity.setDividendYieldPercentageAtCurrent("some-current-percentage");

        Date toDate = new Date();
        moneyControlBSETopDividendEntity.setCreatedDate(toDate);
        moneyControlBSETopDividendEntity.setModifiedDate(toDate);
        moneyControlBSETopDividendEntity.setCreatedBy("SYSTEM");
        moneyControlBSETopDividendEntity.setModifiedBy("SYSTEM");

        BSETopDividendDataAccess moneyControlBSETopDividendataAccess = new BSETopDividendDataAccess(BSETopDividendEntity.class);


        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getCompanyName());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getLatestDividendPercentage());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getDividendYieldPercentage52High());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getDividendYieldPercentage52Low());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getDividendYieldPercentageAtCurrent());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> "+moneyControlBSETopDividendEntity.getModifiedBy());

        moneyControlBSETopDividendataAccess.save(moneyControlBSETopDividendEntity);
        BSETopDividendEntity returnElement = moneyControlBSETopDividendataAccess.findBy(moneyControlBSETopDividendEntity.getCompanyName());
        assertNotNull(returnElement);
    }

}
