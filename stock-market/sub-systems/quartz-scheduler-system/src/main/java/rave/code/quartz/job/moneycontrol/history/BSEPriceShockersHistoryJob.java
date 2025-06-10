package rave.code.quartz.job.moneycontrol.history;

import rave.code.quartz.job.moneycontrol.AbstractHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive500Entity;
import rave.code.stockmarket.bse.entity.BSEActive500HistoryEntity;

public class BSEPriceShockersHistoryJob extends AbstractHistoryJob<BSEActive500Entity, BSEActive500HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO moneycontrol_bse_price_shockers_history(SELECT * FROM moneycontrol_bse_price_shockers)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM moneycontrol_bse_price_shockers";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(BSEActive500HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
