package rave.code.bse.web.model.stock;

public class Stock {

    public static final String TITLE_CONTAINER_CSS_STYLE = "right-container-company-title-container %s";
    public static final String TITLE_CSS_STYLE = "right-container-company-title-div %s";
    public static final String STOCK_MARKET_IMAGE_DIV_CSS_STYLE = "right-container-company-stock-market-chart-div %s";

    public static final String GREEN_BG_CSS_STYLE = "color: black; background: #0BDA51; font-weight:bold;";
    public static final String MAUVE_PINK_BG_CSS_STYLE = "color: black; background: #E0B0FF; font-weight:bold;";
    public static final String RED_BG_CSS_STYLE = "color: black; background:#FA5053; font-weight:bold;";

    public static final String TURNING_RED_GRADIANT_CSS_STYLE = "background: #e81c1f;background: linear-gradient(90deg,rgba(232, 28, 31, 1) 0%, rgba(245, 83, 94, 0.27) %s %, rgba(7, 140, 29, 0.98) %s %); color:#353839;";
    public static final String TURNING_GREEN_GRADIANT_CSS_STYLE = "background: #e81c1f;background: linear-gradient(90deg,rgba(232, 28, 31, 1) 0%, rgba(245, 83, 94, 0.27) %s %, rgba(7, 140, 29, 0.98) %s %); color:#353839;";

    public static final String STOCK_MARKET_CHART_IMAGE_SOURCE = "/images/icons/stock-market-chart.png";

    private String id;
    private String displayName;
    private String toolTip;
    private double lastPrice;
    private String category;

    private String titleContainerCssStyle;
    private String titleCssStyle;
    private String stockMarketChartImageDivCssStyle;

    private String lastPriceCssStyle = MAUVE_PINK_BG_CSS_STYLE;
    private String percentageGainCssStyle = RED_BG_CSS_STYLE;
    private String tradingStatisticsCssStyle = "";

    private String stockMarketChartImageSrc = STOCK_MARKET_CHART_IMAGE_SOURCE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        if (null != displayName && displayName.length() > 15) {
            this.displayName = displayName.substring(0, 15);
        }
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

    public String getTitleContainerCssStyle() {
        return titleContainerCssStyle;
    }

    public String getStockMarketChartImageDivCssStyle() {
        return stockMarketChartImageDivCssStyle;
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

    public String getToolTip() {
        return toolTip;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public String getStockDivId() {
        return String.format("%s-%s-%s", getToolTip().toLowerCase(), "stock", "div").replaceAll(" ", "-");
    }

    public String getStockStatDivId() {
        return String.format("%s-%s-%s", getToolTip().toLowerCase(), "stock-stat", "div").replaceAll(" ", "-");
    }

    public String getTradingStatisticsJSFunction() {
        return String.format("javascript: hideAndShow('%s', '%s');", this.getStockDivId(), this.getStockStatDivId());
    }

    public String getStockMarketChartImageSrc() {
        return this.stockMarketChartImageSrc;
    }

    public void applyCssStyleBasedOnGroup(String category) {
        if (category.startsWith("A")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "a-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "a-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "a-group-stock");
        } else if (category.startsWith("B")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "b-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "b-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "b-group-stock");
        } else if (category.startsWith("F")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "f-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "f-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "f-group-stock");
        } else if (category.startsWith("S")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "s-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "s-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "s-group-stock");
        } else if (category.startsWith("T")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "t-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "t-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "t-group-stock");
        } else if (category.startsWith("X")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "x-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "x-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "x-group-stock");
        } else if (category.startsWith("Z")) {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "z-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "z-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "z-group-stock");
        } else {
            this.titleContainerCssStyle = String.format(TITLE_CONTAINER_CSS_STYLE, "no-group-stock");
            this.titleCssStyle = String.format(TITLE_CSS_STYLE, "no-group-stock");
            this.stockMarketChartImageDivCssStyle = String.format(STOCK_MARKET_IMAGE_DIV_CSS_STYLE, "no-group-stock");
        }
    }

    public void applyCssStyleBasedOnUnderOrOverValuedPercentage(int percentage){
        switch (percentage){
            case 25:
                this.titleCssStyle = String.format("%s %s", this.titleCssStyle, "green-under-valued");
                break;
            case 50:
                this.titleCssStyle = String.format("%s %s", this.titleCssStyle, "yellow-under-valued");
                break;
            case 75:
                this.titleCssStyle = String.format("%s %s", this.titleCssStyle, "orange-under-valued");
                break;
            case 100:
                this.titleCssStyle = String.format("%s %s", this.titleCssStyle, "white-equally-valued");
                break;
            default:
                this.titleCssStyle = String.format("%s %s", this.titleCssStyle, "red-over-valued");
                break;
        }
    }
}
