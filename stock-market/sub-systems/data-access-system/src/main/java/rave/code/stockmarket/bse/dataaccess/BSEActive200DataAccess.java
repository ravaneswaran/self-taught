package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive200Entity;

import java.util.List;
import java.util.logging.Logger;

public class BSEActive200DataAccess extends StockMarketHistoryEnabledDataAccess<BSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive200DataAccess.class.getName());

    public BSEActive200DataAccess() {
        this(BSEActive200Entity.class);
    }

    public BSEActive200DataAccess(Class<BSEActive200Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive200Entity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

    @Override
    public BSEActive200Entity findBy(String primaryKey) {
        BSEActive200Entity bseActive200Entity = super.findBy(primaryKey);
        if (null != bseActive200Entity) {
            bseActive200Entity.setNewEntity(false);
        }
        return bseActive200Entity;
    }

}
