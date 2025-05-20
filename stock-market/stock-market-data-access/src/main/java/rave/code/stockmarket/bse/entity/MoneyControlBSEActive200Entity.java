package rave.code.stockmarket.bse.entity;

import lombok.Data;
import rave.code.stockmarket.AbstractEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "money-control-bse-active-200")
@Entity
@Data
@Table(name = "moneycontrol_bse_active_200")
public class MoneyControlBSEActive200Entity extends AbstractEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "category")
    private String category;

    @Column(name = "high")
    private String high;

    @Column(name = "low")
    private String low;

    @Column(name = "last_price")
    private String lastPrice;

    @Column(name = "percentage_change")
    private String percentageChange;

    @Column(name = "value_in_crores")
    private String valueInCrores;

    @Column(name = "average_volume_5d")
    private String averageVolume5Days;

    @Column(name = "average_volume_10d")
    private String averageVolume10Days;

    @Column(name = "average_volume_30d")
    private String averageVolume30Days;

    @Column(name = "price_to_earning_ratio")
    private String priceToEarningRatio;

    @Column(name = "price_to_book_ratio")
    private String priceToBookRatio;

    @Column(name = "upper_circuit")
    private String upperCircuit;

    @Column(name = "lower_circuit")
    private String lowerCircuit;

    @Column(name = "volume_weighted_average_price")
    private String volumeWeightedAveragePrice;

    @Column(name = "displaced_moving_average_30d")
    private String displacedMovingAverage30D;

    @Column(name = "displaced_moving_average_50d")
    private String displacedMovingAverage50D;

    @Column(name = "displaced_moving_average_150")
    private String displacedMovingAverage150D;

    @Column(name = "displaced_moving_average_200")
    private String displacedMovingAverage200D;

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

    public MoneyControlBSEActive200Entity() {
        super();
        this.setId(UUID.randomUUID().toString());
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(String percentageChange) {
        this.percentageChange = percentageChange;
    }

    public String getValueInCrores() {
        return valueInCrores;
    }

    public void setValueInCrores(String valueInCrores) {
        this.valueInCrores = valueInCrores;
    }

    public String getAverageVolume5Days() {
        return averageVolume5Days;
    }

    public void setAverageVolume5Days(String averageVolume5Days) {
        this.averageVolume5Days = averageVolume5Days;
    }

    public String getAverageVolume10Days() {
        return averageVolume10Days;
    }

    public void setAverageVolume10Days(String averageVolume10Days) {
        this.averageVolume10Days = averageVolume10Days;
    }

    public String getAverageVolume30Days() {
        return averageVolume30Days;
    }

    public void setAverageVolume30Days(String averageVolume30Days) {
        this.averageVolume30Days = averageVolume30Days;
    }

    public String getPriceToEarningRatio() {
        return priceToEarningRatio;
    }

    public void setPriceToEarningRatio(String priceToEarningRatio) {
        this.priceToEarningRatio = priceToEarningRatio;
    }

    public String getPriceToBookRatio() {
        return priceToBookRatio;
    }

    public void setPriceToBookRatio(String priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }

    public String getUpperCircuit() {
        return upperCircuit;
    }

    public void setUpperCircuit(String upperCircuit) {
        this.upperCircuit = upperCircuit;
    }

    public String getLowerCircuit() {
        return lowerCircuit;
    }

    public void setLowerCircuit(String lowerCircuit) {
        this.lowerCircuit = lowerCircuit;
    }

    public String getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    public void setVolumeWeightedAveragePrice(String volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }

    public String getDisplacedMovingAverage30D() {
        return displacedMovingAverage30D;
    }

    public void setDisplacedMovingAverage30D(String displacedMovingAverage30D) {
        this.displacedMovingAverage30D = displacedMovingAverage30D;
    }

    public String getDisplacedMovingAverage50D() {
        return displacedMovingAverage50D;
    }

    public void setDisplacedMovingAverage50D(String displacedMovingAverage50D) {
        this.displacedMovingAverage50D = displacedMovingAverage50D;
    }

    public String getDisplacedMovingAverage150D() {
        return displacedMovingAverage150D;
    }

    public void setDisplacedMovingAverage150D(String displacedMovingAverage150D) {
        this.displacedMovingAverage150D = displacedMovingAverage150D;
    }

    public String getDisplacedMovingAverage200D() {
        return displacedMovingAverage200D;
    }

    public void setDisplacedMovingAverage200D(String displacedMovingAverage200D) {
        this.displacedMovingAverage200D = displacedMovingAverage200D;
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