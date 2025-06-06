package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;

import java.util.List;

public class MoneyControlBSEActive100DataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSEActive100Entity> {

    public MoneyControlBSEActive100DataAccess() {
        this(MoneyControlBSEActive100Entity.class);
    }

    public MoneyControlBSEActive100DataAccess(Class<MoneyControlBSEActive100Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<MoneyControlBSEActive100Entity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

}
