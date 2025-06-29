package rave.code.bse.web.service.decorators;

import rave.code.bse.web.model.stock.Stock;

public class StockLastPriceDecorator implements Decorator{

    @Override
    public Stock decorate(Stock stock) {
        stock.setLastPriceCssStyle(Stock.MAUVE_PINK_BG_CSS_STYLE);
        return stock;
    }
}
