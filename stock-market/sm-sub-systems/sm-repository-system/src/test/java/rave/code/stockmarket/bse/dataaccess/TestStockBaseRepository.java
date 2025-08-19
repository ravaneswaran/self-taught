package rave.code.stockmarket.bse.dataaccess;

import junit.framework.TestCase;
import rave.code.stockmarket.entity.NSEStockBaseEntity;
import rave.code.stockmarket.entity.StockBaseEntity;
import rave.code.stockmarket.repository.StockBaseRepository;

import java.util.Date;
import java.util.UUID;

public class TestStockBaseRepository extends TestCase {

    public void testSaveMethod() {;

        NSEStockBaseEntity nseStockBaseEntity = new NSEStockBaseEntity();

        String id = UUID.randomUUID().toString();
        nseStockBaseEntity.setId(id);
        nseStockBaseEntity.setMkt("N");
        nseStockBaseEntity.setSeries("");
        nseStockBaseEntity.setStockSymbol("TEST");
        nseStockBaseEntity.setStockName("Test Ltd");
        nseStockBaseEntity.setOpenPrice("234.00");
        nseStockBaseEntity.setHighPrice("232.00");
        nseStockBaseEntity.setLowPrice("230.00");
        nseStockBaseEntity.setClosePrice("231.00");
        nseStockBaseEntity.setPreviousClosePrice("243.00");
        nseStockBaseEntity.setNetTradedValue("833496579228.01");
        nseStockBaseEntity.setNetTradedQuantity("3186446020");
        nseStockBaseEntity.setIndexOrSecurity("Y");
        nseStockBaseEntity.setCorpIndex("");
        nseStockBaseEntity.setTrades("29004891");
        nseStockBaseEntity.setHigh52Week("26277.35");
        nseStockBaseEntity.setLow52Week("21743.65");
        nseStockBaseEntity.setDailyClosePrice("231.00");
        Date toDate = new Date();
        nseStockBaseEntity.setCreatedDate(toDate);
        nseStockBaseEntity.setModifiedDate(toDate);
        nseStockBaseEntity.setCreatedBy("SYSTEM");
        nseStockBaseEntity.setModifiedBy("SYSTEM");


        StockBaseRepository stockBaseRepository = new StockBaseRepository();
        stockBaseRepository.save(nseStockBaseEntity);
        StockBaseEntity returnElement = stockBaseRepository.findBy(StockBaseEntity.class, nseStockBaseEntity);
        assertNotNull(returnElement);
    }
}
