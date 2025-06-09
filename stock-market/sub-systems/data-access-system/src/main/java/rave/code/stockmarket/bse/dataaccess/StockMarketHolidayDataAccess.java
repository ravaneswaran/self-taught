package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.entity.StockMarketHolidayEntity;

import java.util.List;

public class StockMarketHolidayDataAccess extends StockMarketDataAccess<StockMarketHolidayEntity> {

    public StockMarketHolidayDataAccess() {
        this(StockMarketHolidayEntity.class);
    }

    public StockMarketHolidayDataAccess(Class<StockMarketHolidayEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<StockMarketHolidayEntity> entities) {
        throw new RuntimeException("Implementation not required....");
    }
}