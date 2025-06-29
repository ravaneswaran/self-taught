package rave.code.stockmarket.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class StockMarketGainerEntity extends StockMarketEntity {

    protected String high;
    protected String low;
    protected String lastPrice;
    protected String variation;
    protected String previousClose;
    protected String percentageGain;
    protected String averageVolume5Days;
    protected String averageVolume10Days;
    protected String averageVolume30Days;
    protected String priceToEarningRatio;
    protected String priceToBookRatio;
    protected String upperCircuit;
    protected String lowerCircuit;
    protected String volumeWeightedAveragePrice;
    protected String displacedMovingAverage30D;
    protected String displacedMovingAverage50D;
    protected String displacedMovingAverage150D;
    protected String displacedMovingAverage200D;


    @Column(name = "high")
    public String getHigh() {
        return high;
    }
    public void setHigh(String high) {
        this.high = high;
    }

    @Column(name = "low")
    public String getLow() {
        return low;
    }
    public void setLow(String low) {
        this.low = low;
    }

    @Column(name = "last_price")
    public String getLastPrice() {
        return lastPrice;
    }
    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    @Column(name = "variation")
    public String getVariation() {
        return variation;
    }
    public void setVariation(String variation) {
        this.variation = variation;
    }

    @Column(name = "previous_close")
    public String getPreviousClose() {
        return previousClose;
    }
    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    @Column(name = "percentage_gain")
    public String getPercentageGain() {
        return percentageGain;
    }
    public void setPercentageGain(String percentageGain) {
        this.percentageGain = percentageGain;
    }

    @Column(name = "average_volume_5d")
    public String getAverageVolume5Days() {
        return averageVolume5Days;
    }
    public void setAverageVolume5Days(String averageVolume5Days) {
        this.averageVolume5Days = averageVolume5Days;
    }

    @Column(name = "average_volume_10d")
    public String getAverageVolume10Days() {return averageVolume10Days;}
    public void setAverageVolume10Days(String averageVolume10Days) {
        this.averageVolume10Days = averageVolume10Days;
    }

    @Column(name = "average_volume_30d")
    public String getAverageVolume30Days() {
        return averageVolume30Days;
    }
    public void setAverageVolume30Days(String averageVolume30Days) {
        this.averageVolume30Days = averageVolume30Days;
    }

    @Column(name = "price_to_earning_ratio")
    public String getPriceToEarningRatio() {
        return priceToEarningRatio;
    }
    public void setPriceToEarningRatio(String priceToEarningRatio) {
        this.priceToEarningRatio = priceToEarningRatio;
    }

    @Column(name = "price_to_book_ratio")
    public String getPriceToBookRatio() {
        return priceToBookRatio;
    }
    public void setPriceToBookRatio(String priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }

    @Column(name = "upper_circuit")
    public String getUpperCircuit() {
        return upperCircuit;
    }
    public void setUpperCircuit(String upperCircuit) {
        this.upperCircuit = upperCircuit;
    }

    @Column(name = "lower_circuit")
    public String getLowerCircuit() {
        return lowerCircuit;
    }
    public void setLowerCircuit(String lowerCircuit) {
        this.lowerCircuit = lowerCircuit;
    }

    @Column(name = "volume_weighted_average_price")
    public String getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }
    public void setVolumeWeightedAveragePrice(String volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }

    @Column(name = "displaced_moving_average_30d")
    public String getDisplacedMovingAverage30D() {
        return displacedMovingAverage30D;
    }
    public void setDisplacedMovingAverage30D(String displacedMovingAverage30D) {
        this.displacedMovingAverage30D = displacedMovingAverage30D;
    }

    @Column(name = "displaced_moving_average_50d")
    public String getDisplacedMovingAverage50D() {
        return displacedMovingAverage50D;
    }
    public void setDisplacedMovingAverage50D(String displacedMovingAverage50D) {
        this.displacedMovingAverage50D = displacedMovingAverage50D;
    }

    @Column(name = "displaced_moving_average_150d")
    public String getDisplacedMovingAverage150D() {
        return displacedMovingAverage150D;
    }
    public void setDisplacedMovingAverage150D(String displacedMovingAverage150D) {
        this.displacedMovingAverage150D = displacedMovingAverage150D;
    }

    @Column(name = "displaced_moving_average_200d")
    public String getDisplacedMovingAverage200D() {
        return displacedMovingAverage200D;
    }
    public void setDisplacedMovingAverage200D(String displacedMovingAverage200D) {
        this.displacedMovingAverage200D = displacedMovingAverage200D;
    }
}
