package rave.code.quartz.job.moneycontrol.history;

import rave.code.stockmarket.dataaccess.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.entity.BSEPriceShockerEntity;
import rave.code.stockmarket.entity.BSEPriceShockerHistoryEntity;

public class BSEPriceShockersHistoryJob extends AbstractHistoryEntityMakerJob<BSEPriceShockerEntity, BSEPriceShockerHistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_price_shockers_history(SELECT * FROM bse_price_shockers)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_price_shockers";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(BSEPriceShockerHistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
