package rave.code.moneycontrol.website.data.model;

public class MoneyControlPriceShockerModel extends MoneyControlGenericBSEActiveModel{

    private String sector;
    private String currentPrice;
    private String previousPrice;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }
}
