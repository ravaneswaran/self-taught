package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500Entity;

import java.util.List;

public class MoneyControlBSEActive500DataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSEActive500Entity> {

    public MoneyControlBSEActive500DataAccess(){
        this(MoneyControlBSEActive500Entity.class);
    }

    public MoneyControlBSEActive500DataAccess(Class<MoneyControlBSEActive500Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<MoneyControlBSEActive500Entity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

}
