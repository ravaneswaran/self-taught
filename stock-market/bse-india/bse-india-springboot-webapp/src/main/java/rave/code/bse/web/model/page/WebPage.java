package rave.code.bse.web.model.page;

import rave.code.bse.web.model.stock.Stock;

import java.util.List;

public class WebPage {

    private String active100LinkStyle = "";
    private String active200LinkStyle = "";
    private String active500LinkStyle = "";
    private String priceShockersLinkStyle = "";
    private String topDividendLinkStyle = "";
    private String smallCapGainerLinkStyle = "";
    private List<Stock> stocks;

    public String getActive100LinkStyle() {
        return active100LinkStyle;
    }

    public void setActive100LinkStyle(String active100LinkStyle) {
        this.active100LinkStyle = active100LinkStyle;
    }

    public String getActive200LinkStyle() {
        return active200LinkStyle;
    }

    public void setActive200LinkStyle(String active200LinkStyle) {
        this.active200LinkStyle = active200LinkStyle;
    }

    public String getActive500LinkStyle() {
        return active500LinkStyle;
    }

    public void setActive500LinkStyle(String active500LinkStyle) {
        this.active500LinkStyle = active500LinkStyle;
    }

    public String getPriceShockersLinkStyle() {
        return priceShockersLinkStyle;
    }

    public void setPriceShockersLinkStyle(String priceShockersLinkStyle) {
        this.priceShockersLinkStyle = priceShockersLinkStyle;
    }
    
    public String getTopDividendLinkStyle() {
        return topDividendLinkStyle;
    }

    public void setTopDividendLinkStyle(String topDividendLinkStyle) {
        this.topDividendLinkStyle = topDividendLinkStyle;
    }

    public String getSmallCapGainerLinkStyle() {
        return smallCapGainerLinkStyle;
    }

    public void setSmallCapGainerLinkStyle(String smallCapGainerLinkStyle) {
        this.smallCapGainerLinkStyle = smallCapGainerLinkStyle;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }


}
