package rave.code.quartz.job.moneycontrol.history;

import rave.code.stockmarket.repository.StockMarketHistoryEnabledRepository;
import rave.code.stockmarket.entity.BSEActive200Entity;
import rave.code.stockmarket.entity.BSEActive200HistoryEntity;

public class BSEActive200HistoryJob extends AbstractHistoryEntityMakerJob<BSEActive200Entity, BSEActive200HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_active_200_history(SELECT * FROM bse_active_200)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_active_200";
        StockMarketHistoryEnabledRepository stockMarketHistoryEnabledRepository = new StockMarketHistoryEnabledRepository(BSEActive200HistoryEntity.class);

        stockMarketHistoryEnabledRepository.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
