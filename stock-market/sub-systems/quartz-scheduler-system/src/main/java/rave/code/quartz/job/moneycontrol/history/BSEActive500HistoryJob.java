package rave.code.quartz.job.moneycontrol.history;

import rave.code.quartz.job.moneycontrol.AbstractHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive500Entity;
import rave.code.stockmarket.bse.entity.BSEActive500HistoryEntity;

public class BSEActive500HistoryJob extends AbstractHistoryJob<BSEActive500Entity, BSEActive500HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_active_500_history(SELECT * FROM bse_active_500)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_active_500";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(BSEActive500HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
