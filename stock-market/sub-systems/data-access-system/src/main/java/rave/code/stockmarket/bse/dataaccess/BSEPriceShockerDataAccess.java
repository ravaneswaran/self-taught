package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEPriceShockerEntity;

import java.util.List;

public class BSEPriceShockerDataAccess extends StockMarketHistoryEnabledDataAccess<BSEPriceShockerEntity> {

    public BSEPriceShockerDataAccess(){
        this(BSEPriceShockerEntity.class);
    }

    public BSEPriceShockerDataAccess(Class<BSEPriceShockerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEPriceShockerEntity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

}
