package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEPriceShockerEntity;

public class MoneyControlBSEPriceShockerDataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSEPriceShockerEntity> {

    public MoneyControlBSEPriceShockerDataAccess(){
        this(MoneyControlBSEPriceShockerEntity.class);
    }

    public MoneyControlBSEPriceShockerDataAccess(Class<MoneyControlBSEPriceShockerEntity> type) {
        super(type);
    }

}
