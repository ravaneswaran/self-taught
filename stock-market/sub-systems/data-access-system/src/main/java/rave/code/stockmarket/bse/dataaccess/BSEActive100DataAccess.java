package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive100Entity;

import java.util.List;

public class BSEActive100DataAccess extends StockMarketHistoryEnabledDataAccess<BSEActive100Entity> {

    public BSEActive100DataAccess() {
        this(BSEActive100Entity.class);
    }

    public BSEActive100DataAccess(Class<BSEActive100Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive100Entity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

}
