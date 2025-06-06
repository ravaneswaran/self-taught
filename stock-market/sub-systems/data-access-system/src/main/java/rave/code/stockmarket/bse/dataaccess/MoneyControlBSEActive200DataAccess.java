package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;

import java.util.List;
import java.util.logging.Logger;

public class MoneyControlBSEActive200DataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive200DataAccess.class.getName());

    public MoneyControlBSEActive200DataAccess(){
        this(MoneyControlBSEActive200Entity.class);
    }

    public MoneyControlBSEActive200DataAccess(Class<MoneyControlBSEActive200Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<MoneyControlBSEActive200Entity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

}
