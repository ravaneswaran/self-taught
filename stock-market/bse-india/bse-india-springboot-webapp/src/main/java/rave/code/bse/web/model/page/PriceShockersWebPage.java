package rave.code.bse.web.model.page;

import rave.code.bse.web.model.stock.PriceShockerStock;

import java.util.List;

public class PriceShockersWebPage extends WebPage {

    private List<PriceShockerStock> priceShockerStocks;

    public List<PriceShockerStock> getPriceShockerStocks() {
        return priceShockerStocks;
    }

    public void setPriceShockerStocks(List<PriceShockerStock> priceShockerStocks) {
        this.priceShockerStocks = priceShockerStocks;
    }
}
