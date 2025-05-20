package rave.code.stockmarket.bse.dataaccess;

import rave.code.stockmarket.AbstractDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;

import java.util.logging.Logger;

public class MoneyControlBSEActive200DataAccess extends AbstractDataAccess<MoneyControlBSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive200DataAccess.class.getName());

    public MoneyControlBSEActive200DataAccess(Class<MoneyControlBSEActive200Entity> type) {
        super(type);
    }
}
