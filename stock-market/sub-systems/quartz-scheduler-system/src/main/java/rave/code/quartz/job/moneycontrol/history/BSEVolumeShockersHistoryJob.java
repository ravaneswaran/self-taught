package rave.code.quartz.job.moneycontrol.history;

import rave.code.stockmarket.dataaccess.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.entity.BSEVolumeShockerEntity;
import rave.code.stockmarket.entity.BSEVolumeShockerHistoryEntity;

public class BSEVolumeShockersHistoryJob extends AbstractHistoryEntityMakerJob<BSEVolumeShockerEntity, BSEVolumeShockerHistoryEntity>{

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_volume_shockers_history(SELECT * FROM bse_volume_shockers)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_volume_shockers";
        StockMarketHistoryEnabledDataAccess stockMarketHistoryEnabledDataAccess = new StockMarketHistoryEnabledDataAccess(BSEVolumeShockerHistoryEntity.class);

        stockMarketHistoryEnabledDataAccess.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
