package rave.code.bse.web.model.stock;

public class Stock {

    public static final String TITLE_CSS_STYLE = "right-container-company-title-div";
    public static final String GREEN_BG_CSS_STYLE = "color: black; background: #0BDA51; font-weight:bold;";
    public static final String MAUVE_PINK_BG_CSS_STYLE = "color: black; background: #E0B0FF; font-weight:bold;";
    public static final String RED_BG_CSS_STYLE = "color: black; background:#FA5053; font-weight:bold;";
    public static final String RED_2_GREEN_GRADIANT_CSS_STYLE = "background: #e81c1f;background: linear-gradient(90deg,rgba(232, 28, 31, 1) 0%, rgba(245, 83, 94, 0.27) %s %, rgba(7, 140, 29, 0.98) %s %); color:#353839;";

    private String id;
    private String companyName;
    private double lastPrice;
    private String category;

    private String titleCssStyle = TITLE_CSS_STYLE;
    private String lastPriceCssStyle = MAUVE_PINK_BG_CSS_STYLE;
    private String percentageGainCssStyle = RED_BG_CSS_STYLE;
    private String tradingStatisticsCssStyle  = "";


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

    public String getTradingStatisticsCssStyle() {
        return tradingStatisticsCssStyle;
    }

    public void setTradingStatisticsCssStyle(String tradingStatisticsCssStyle) {
        this.tradingStatisticsCssStyle = tradingStatisticsCssStyle;
    }
}
