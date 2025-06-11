package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketDataAccess;
import rave.code.stockmarket.bse.entity.HolidayEntity;

import java.util.List;

public class HolidayDataAccess extends StockMarketDataAccess<HolidayEntity> {

    public HolidayDataAccess() {
        this(HolidayEntity.class);
    }

    public HolidayDataAccess(Class<HolidayEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<HolidayEntity> entities) {
        throw new RuntimeException("Implementation not required....");
    }
}