package rave.code.moneycontrol.bse.quartz.job.history;

import rave.code.moneycontrol.bse.quartz.job.AbstractMoneyControlHistoryJob;
import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive200DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive100HistoryEntity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200HistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSEActive200HistoryJob extends AbstractMoneyControlHistoryJob<MoneyControlBSEActive200Entity, MoneyControlBSEActive200HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO moneycontrol_bse_active_200_history(SELECT * FROM moneycontrol_bse_active_200)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM moneycontrol_bse_active_200";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(MoneyControlBSEActive200HistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
