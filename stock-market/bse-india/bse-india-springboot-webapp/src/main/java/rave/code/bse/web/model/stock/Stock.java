package rave.code.bse.web.model.stock;

public class Stock {

    private String id;
    private String companyName;
    private double lastPrice;
    private String category;

    private String titleCssStyle = "right-container-company-title-div";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitleCssStyle() {
        return titleCssStyle;
    }

    public void setTitleCssStyle(String titleCssStyle) {
        this.titleCssStyle = titleCssStyle;
    }
}
