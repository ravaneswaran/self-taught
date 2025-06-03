package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSETopDividendEntity;

public class MoneyControlBSETopDividendDataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSETopDividendEntity> {

    public MoneyControlBSETopDividendDataAccess(){
        this(MoneyControlBSETopDividendEntity.class);
    }

    public MoneyControlBSETopDividendDataAccess(Class<MoneyControlBSETopDividendEntity> type) {
        super(type);
    }

}
