package rave.code.stockmarket.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class StockMarketDividendEntity extends StockMarketEntity {

    protected String lastPrice;
    protected String latestDividendPercentage;
    protected String dividendYieldPercentage52High;
    protected String dividendYieldPercentage52Low;
    protected String dividendYieldPercentageAtCurrent;

    @Column(name = "last_price")
    public String getLastPrice() {return lastPrice;}
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    @Column(name = "latest_dividend_percentage")
    public String getLatestDividendPercentage() {
        return latestDividendPercentage;
    }
    public void setLatestDividendPercentage(String latestDividendPercentage) {
        this.latestDividendPercentage = latestDividendPercentage;
    }

    @Column(name = "dividend_yield_percentage_52_high")
    public String getDividendYieldPercentage52High() {
        return dividendYieldPercentage52High;
    }
    public void setDividendYieldPercentage52High(String dividendYieldPercentage52High) {
        this.dividendYieldPercentage52High = dividendYieldPercentage52High;
    }

    @Column(name = "dividend_yield_percentage_52_low")
    public String getDividendYieldPercentage52Low() {
        return dividendYieldPercentage52Low;
    }
    public void setDividendYieldPercentage52Low(String dividendYieldPercentage52Low) {
        this.dividendYieldPercentage52Low = dividendYieldPercentage52Low;
    }

    @Column(name = "dividend_yield_percentage_at_current")
    public String getDividendYieldPercentageAtCurrent() {
        return dividendYieldPercentageAtCurrent;
    }
    public void setDividendYieldPercentageAtCurrent(String dividendYieldPercentageAtCurrent) {
        this.dividendYieldPercentageAtCurrent = dividendYieldPercentageAtCurrent;
    }
}
