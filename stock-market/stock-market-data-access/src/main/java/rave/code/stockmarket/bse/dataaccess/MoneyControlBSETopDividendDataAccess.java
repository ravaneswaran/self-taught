package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSETopDividendEntity;

public class MoneyControlBSETopDividendDataAccess extends StockMarketDataAccess<MoneyControlBSETopDividendEntity> {

    public MoneyControlBSETopDividendDataAccess(){
        this(MoneyControlBSETopDividendEntity.class);
    }

    public MoneyControlBSETopDividendDataAccess(Class<MoneyControlBSETopDividendEntity> type) {
        super(type);
    }
}
