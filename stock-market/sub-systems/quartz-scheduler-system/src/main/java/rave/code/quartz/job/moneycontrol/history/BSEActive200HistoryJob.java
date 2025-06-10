package rave.code.quartz.job.moneycontrol.history;

import rave.code.quartz.job.moneycontrol.AbstractHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEActive200Entity;
import rave.code.stockmarket.bse.entity.BSEActive200HistoryEntity;

public class BSEActive200HistoryJob extends AbstractHistoryJob<BSEActive200Entity, BSEActive200HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO moneycontrol_bse_active_200_history(SELECT * FROM moneycontrol_bse_active_200)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM moneycontrol_bse_active_200";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(BSEActive200HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
