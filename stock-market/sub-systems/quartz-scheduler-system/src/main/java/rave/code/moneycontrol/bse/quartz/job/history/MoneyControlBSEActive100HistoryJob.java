package rave.code.moneycontrol.bse.quartz.job.history;

import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100HistoryEntity;

public class MoneyControlBSEActive100HistoryJob extends AbstractMoneyControlHistoryJob<MoneyControlBSEActive100Entity, MoneyControlBSEActive100HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO moneycontrol_bse_active_100_history(SELECT * FROM moneycontrol_bse_active_100)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM moneycontrol_bse_active_100";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(MoneyControlBSEActive100HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
