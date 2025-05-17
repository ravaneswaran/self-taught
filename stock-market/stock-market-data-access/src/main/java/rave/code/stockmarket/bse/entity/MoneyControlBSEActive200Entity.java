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
    protected String id;

    @Column(name = "company_name")
    private String companyName;

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

    public MoneyControlBSEActive200Entity(){
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