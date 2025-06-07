package rave.code.bse.web.model.stock;

public class Stock {

    private String id;
    private String companyName;
    private double lastPrice;
    private String category;

    private String titleCssStyle = "right-container-company-title-div";
    private String lastPriceCssStyle = "color: black; background: #0BDA51; font-weight:bold;";
    private String percentageGainCssStyle = "color: black; background:#FA5053; font-weight:bold;";


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

    public String getLastPriceCssStyle() {
        return lastPriceCssStyle;
    }

    public void setLastPriceCssStyle(String lastPriceCssStyle) {
        this.lastPriceCssStyle = lastPriceCssStyle;
    }

    public String getPercentageGainCssStyle() {
        return percentageGainCssStyle;
    }

    public void setPercentageGainCssStyle(String percentageGainCssStyle) {
        this.percentageGainCssStyle = percentageGainCssStyle;
    }
}
