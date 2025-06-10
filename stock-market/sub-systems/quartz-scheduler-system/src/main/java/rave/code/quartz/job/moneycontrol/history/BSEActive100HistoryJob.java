package rave.code.quartz.job.moneycontrol.history;

import rave.code.quartz.job.moneycontrol.AbstractHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive100Entity;
import rave.code.stockmarket.bse.entity.BSEActive100HistoryEntity;

public class BSEActive100HistoryJob extends AbstractHistoryJob<BSEActive100Entity, BSEActive100HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO moneycontrol_bse_active_100_history(SELECT * FROM moneycontrol_bse_active_100)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM moneycontrol_bse_active_100";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(BSEActive100HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
