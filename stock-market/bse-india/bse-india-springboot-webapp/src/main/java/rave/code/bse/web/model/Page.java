package rave.code.bse.web.model;

import java.util.List;

public class Page {

    private boolean active100Link;

    private boolean active200Link;

    private boolean active500Link;

    private boolean priceShockersLink;

    private List<Stock> stocks;

    public boolean isActive100Link() {
        return active100Link;
    }

    public void setActive100Link(boolean active100Link) {
        this.active100Link = active100Link;
    }

    public boolean isActive200Link() {
        return active200Link;
    }

    public void setActive200Link(boolean active200Link) {
        this.active200Link = active200Link;
    }

    public boolean isActive500Link() {
        return active500Link;
    }

    public void setActive500Link(boolean active500Link) {
        this.active500Link = active500Link;
    }

    public boolean isPriceShockersLink() {
        return priceShockersLink;
    }

    public void setPriceShockersLink(boolean priceShockersLink) {
        this.priceShockersLink = priceShockersLink;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

}
