package rave.code.moneycontrol.model;

public class MoneyControlDividendModel {

    private String companyName;
    private String lastPrice;
    private String latestDividendPercentage;
    private String dividendYieldPercentAt52High;
    private String dividendYieldPercentAt52Low;
    private String dividendYieldPercentAtCurrent;

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLastPrice() {
        return this.lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLatestDividendPercentage() {
        return this.latestDividendPercentage;
    }

    public void setLatestDividendPercentage(String latestDividendPercentage) {
        this.latestDividendPercentage = latestDividendPercentage;
    }

    public String getDividendYieldPercentAt52High() {
        return this.dividendYieldPercentAt52High;
    }

    public void setDividendYieldPercentAt52High(String dividendYieldPercentAt52High) {
        this.dividendYieldPercentAt52High = dividendYieldPercentAt52High;
    }

    public String getDividendYieldPercentAt52Low() {
        return this.dividendYieldPercentAt52Low;
    }

    public void setDividendYieldPercentAt52Low(String dividendYieldPercentAt52Low) {
        this.dividendYieldPercentAt52Low = dividendYieldPercentAt52Low;
    }

    public String getDividendYieldPercentAtCurrent() {
        return this.dividendYieldPercentAtCurrent;
    }

    public void setDividendYieldPercentAtCurrent(String dividendYieldPercentAtCurrent) {
        this.dividendYieldPercentAtCurrent = dividendYieldPercentAtCurrent;
    }
}
