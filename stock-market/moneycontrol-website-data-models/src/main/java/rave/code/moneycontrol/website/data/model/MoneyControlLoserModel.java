package rave.code.moneycontrol.website.data.model;

public class MoneyControlLoserModel {

    private String companyName;
    private String high;
    private String low;
    private String lastPrice;
    private String previousClose;
    private String change;
    private String percentageGain;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getPercentageGain() {
        return percentageGain;
    }

    public void setPercentageGain(String percentageGain) {
        this.percentageGain = percentageGain;
    }
}
