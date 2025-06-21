package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.BSEPriceShockerEntity;
import rave.code.stockmarket.bse.entity.BSEVolumeShockerEntity;

import java.util.List;

public class BSEVolumeShockerDataAccess extends StockMarketHistoryEnabledDataAccess<BSEVolumeShockerEntity> {

    public BSEVolumeShockerDataAccess() {
        this(BSEVolumeShockerEntity.class);
    }

    public BSEVolumeShockerDataAccess(Class<BSEVolumeShockerEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEVolumeShockerEntity> entities) {
        throw new RuntimeException("Yet to implement....");
    }

}
