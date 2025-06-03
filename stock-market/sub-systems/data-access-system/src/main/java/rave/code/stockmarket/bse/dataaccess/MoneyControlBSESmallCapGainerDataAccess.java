package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.StockMarketHistoryEnabledDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;

public class MoneyControlBSESmallCapGainerDataAccess extends StockMarketHistoryEnabledDataAccess<MoneyControlBSESmallCapGainerEntity> {

    public MoneyControlBSESmallCapGainerDataAccess(){
        this(MoneyControlBSESmallCapGainerEntity.class);
    }

    public MoneyControlBSESmallCapGainerDataAccess(Class<MoneyControlBSESmallCapGainerEntity> type) {
        super(type);
    }

}
