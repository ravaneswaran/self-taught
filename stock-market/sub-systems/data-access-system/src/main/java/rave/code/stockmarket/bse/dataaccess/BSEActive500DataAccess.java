package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive500Entity;

import java.util.List;

public class BSEActive500DataAccess extends StockMarketHistoryEnabledDataAccess<BSEActive500Entity> {

    public BSEActive500DataAccess() {
        this(BSEActive500Entity.class);
    }

    public BSEActive500DataAccess(Class<BSEActive500Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive500Entity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

    @Override
    public BSEActive500Entity findBy(String primaryKey) {
        BSEActive500Entity bseActive500Entity = super.findBy(primaryKey);
        if (null != bseActive500Entity) {
            bseActive500Entity.setNewEntity(false);
        }
        return bseActive500Entity;
    }
}
