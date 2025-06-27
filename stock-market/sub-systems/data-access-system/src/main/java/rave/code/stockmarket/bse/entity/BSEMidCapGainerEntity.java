package rave.code.stockmarket.bse.entity;

import lombok.Data;
import rave.code.stockmarket.AbstractEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "bse_mid_cap_gainer")
@Entity
@Data
@Table(name = "bse_mid_cap_gainer")
public class BSEMidCapGainerEntity extends AbstractEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    protected Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    protected Date modifiedDate;
    @Column(name = "created_by")
    protected String createdBy;
    @Column(name = "modified_by")
    protected String modifiedBy;
    @Id
    @Column(name = "stock_name")
    private String stockName;
    @Column(name = "high")
    private String high;
    @Column(name = "low")
    private String low;
    @Column(name = "last_price")
    private String lastPrice;
    @Column(name = "previous_close")
    private String previousClose;
    @Column(name = "variation")
    private String variation;
    @Column(name = "percentage_gain")
    private String percentageGain;
    @Column(name = "average_volume_5d")
    private String averageVolume5Days;
    @Column(name = "average_volume_10d")
    private String averageVolume10Days;
    @Column(name = "average_volume_30d")
    private String averageVolume30Days;
    @Column(name = "displaced_moving_average_30d")
    private String displacedMovingAverage30Days;
    @Column(name = "displaced_moving_average_50d")
    private String displacedMovingAverage50Days;
    @Column(name = "displaced_moving_average_150d")
    private String displacedMovingAverage150Days;
    @Column(name = "displaced_moving_average_200d")
    private String displacedMovingAverage200Days;
    @Column(name = "price_to_earning_ratio")
    private String priceToEarningRatio;
    @Column(name = "price_to_book_ratio")
    private String priceToBookRatio;
    @Column(name = "lower_circuit")
    private String lowerCircuit;
    @Column(name = "upper_circuit")
    private String upperCircuit;
    @Column(name = "volume_weighted_average_price")
    private String volumeWeightedAveragePrice;

    public BSEMidCapGainerEntity() {
        super();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getPercentageGain() {
        return percentageGain;
    }

    public void setPercentageGain(String percentageGain) {
        this.percentageGain = percentageGain;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}