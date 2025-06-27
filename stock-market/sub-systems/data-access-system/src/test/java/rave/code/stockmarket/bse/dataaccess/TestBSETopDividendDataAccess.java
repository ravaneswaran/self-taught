package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.bse.entity.BSETopDividendEntity;

import java.util.Date;

public class TestBSETopDividendDataAccess extends TestCase {

    public void testSaveMethod() {
        BSETopDividendEntity bseTopDividendEntity = new BSETopDividendEntity();

        bseTopDividendEntity.setStockName("test-company-" + new Date().getTime());
        bseTopDividendEntity.setLastPrice("23");

        bseTopDividendEntity.setLatestDividendPercentage("4");
        bseTopDividendEntity.setDividendYieldPercentage52High("23");
        bseTopDividendEntity.setDividendYieldPercentage52Low("32");
        bseTopDividendEntity.setDividendYieldPercentageAtCurrent("23");

        Date toDate = new Date();
        bseTopDividendEntity.setCreatedDate(toDate);
        bseTopDividendEntity.setModifiedDate(toDate);
        bseTopDividendEntity.setCreatedBy("SYSTEM");
        bseTopDividendEntity.setModifiedBy("SYSTEM");

        BSETopDividendDataAccess bseTopDividendDataAccess = new BSETopDividendDataAccess(BSETopDividendEntity.class);


        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getLatestDividendPercentage());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getDividendYieldPercentage52High());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getDividendYieldPercentage52Low());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getDividendYieldPercentageAtCurrent());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseTopDividendEntity.getModifiedBy());

        bseTopDividendDataAccess.save(bseTopDividendEntity);
        BSETopDividendEntity returnElement = bseTopDividendDataAccess.findBy(bseTopDividendEntity.getStockName());
        assertNotNull(returnElement);
    }

}
