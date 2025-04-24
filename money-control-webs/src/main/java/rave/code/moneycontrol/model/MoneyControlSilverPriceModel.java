package rave.code.moneycontrol.model;

public class MoneyControlSilverPriceModel {

    private String quantityStr;
    private String todayPriceStr;
    private String yesterdayPriceStr;
    private String priceDifferenceStr;

    public String getQuantityStr() {
        return quantityStr;
    }

    public void setQuantityStr(String quantityStr) {
        this.quantityStr = quantityStr;
    }

    public String getTodayPriceStr() {
        return todayPriceStr;
    }

    public void setTodayPriceStr(String todayPriceStr) {
        this.todayPriceStr = todayPriceStr;
    }

    public String getYesterdayPriceStr() {
        return yesterdayPriceStr;
    }

    public void setYesterdayPriceStr(String yesterdayPriceStr) {
        this.yesterdayPriceStr = yesterdayPriceStr;
    }

    public String getPriceDifferenceStr() {
        return priceDifferenceStr;
    }

    public void setPriceDifferenceStr(String priceDifferenceStr) {
        this.priceDifferenceStr = priceDifferenceStr;
    }
}
