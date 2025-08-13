package rave.code.bse.web.service;

import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.model.stock.Stock;

import java.util.List;

public abstract class AbstractService<S, T> {

    public WebPage getPageModel() {
        WebPage webPage = new WebPage();

        List<S> entities = this.getEntities();
        webPage.setStocks((List<Stock>) this.getStocks(entities));

        return webPage;
    }

    public abstract List<S> getEntities();

    public abstract List<T> getStocks(List<S> entities);
}
