package rave.code.bse.web.service.decorators;

import rave.code.bse.web.model.stock.Stock;

public interface Decorator {

    public Stock decorate(Stock stock);

}
