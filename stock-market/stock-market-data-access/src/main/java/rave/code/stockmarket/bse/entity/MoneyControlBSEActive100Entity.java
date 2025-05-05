package rave.code.stockmarket.bse.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "money-control-bse-active-100")
@Entity
@Data
@Table(name = "moneycontrol_bse_active_100")
public class MoneyControlBSEActive100Entity {

    @Id
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "companyname")
    private String companyName;

    @XmlElement(name = "high")
    private String high;

    @XmlElement(name = "low")
    private String low;

    @XmlElement(name = "lastprice")
    private String lastPrice;

    @XmlElement(name = "previousclose")
    private String previousClose;

    @XmlElement(name = "change")
    private String change;

    @XmlElement(name = "percentagegain")
    private String percentageGain;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlElement(name = "createddate")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlElement(name = "modifieddate")
    private Date modifiedDate;

    @XmlElement(name = "createdby")
    private String createdBy;

    @XmlElement(name = "modifiedby")
    private String modifiedBy;

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

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
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
