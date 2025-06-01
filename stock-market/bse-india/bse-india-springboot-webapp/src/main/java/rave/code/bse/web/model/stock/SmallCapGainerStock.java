package rave.code.bse.web.model.stock;

public class SmallCapGainerStock extends Stock{

    private double high;
    private double low;
    private double previousClose;
    private double variation;
    private double percentageGain;

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public double getPercentageGain() {
        return percentageGain;
    }

    public void setPercentageGain(double percentageGain) {
        this.percentageGain = percentageGain;
    }
}
