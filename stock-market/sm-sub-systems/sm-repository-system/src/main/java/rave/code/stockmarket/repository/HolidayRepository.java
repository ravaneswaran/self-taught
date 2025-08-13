package rave.code.stockmarket.repository;

import rave.code.stockmarket.entity.HolidayEntity;

import java.util.List;

public class HolidayRepository extends StockMarketRepository<HolidayEntity> {

    public HolidayRepository() {
        this(HolidayEntity.class);
    }

    public HolidayRepository(Class<HolidayEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<HolidayEntity> entities) {
        throw new RuntimeException("Implementation not required....");
    }
}