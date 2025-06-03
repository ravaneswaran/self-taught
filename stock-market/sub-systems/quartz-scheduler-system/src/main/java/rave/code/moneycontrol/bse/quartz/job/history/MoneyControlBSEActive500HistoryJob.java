package rave.code.moneycontrol.bse.quartz.job.history;

import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive500HistoryEntity;

public class MoneyControlBSEActive500HistoryJob extends AbstractMoneyControlHistoryJob<MoneyControlBSEActive500Entity, MoneyControlBSEActive500HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO moneycontrol_bse_active_500_history(SELECT * FROM moneycontrol_bse_active_500)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM moneycontrol_bse_active_500";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(MoneyControlBSEActive500HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
