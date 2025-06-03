package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEMidCapGainerEntity;

public class MoneyControlBSEMidCapGainerDataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSEMidCapGainerEntity> {

    public MoneyControlBSEMidCapGainerDataAccess(){
        this(MoneyControlBSEMidCapGainerEntity.class);
    }

    public MoneyControlBSEMidCapGainerDataAccess(Class<MoneyControlBSEMidCapGainerEntity> type) {
        super(type);
    }

}
