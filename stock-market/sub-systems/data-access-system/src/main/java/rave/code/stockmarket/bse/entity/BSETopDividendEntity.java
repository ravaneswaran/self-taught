package rave.code.stockmarket.bse.entity;

import lombok.Data;
import rave.code.stockmarket.AbstractEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "bse-top-dividend")
@Entity
@Data
@Table(name = "bse_top_dividend")
public class BSETopDividendEntity extends AbstractEntity {

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
    @Column(name = "last_price")
    private String lastPrice;
    @Column(name = "latest_dividend_percentage")
    private String latestDividendPercentage;
    @Column(name = "dividend_yield_percentage_52_high")
    private String dividendYieldPercentage52High;
    @Column(name = "dividend_yield_percentage_52_low")
    private String dividendYieldPercentage52Low;
    @Column(name = "dividend_yield_percentage_at_current")
    private String dividendYieldPercentageAtCurrent;

    public BSETopDividendEntity() {
        super();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getLatestDividendPercentage() {
        return latestDividendPercentage;
    }

    public void setLatestDividendPercentage(String latestDividendPercentage) {
        this.latestDividendPercentage = latestDividendPercentage;
    }

    public String getDividendYieldPercentage52High() {
        return dividendYieldPercentage52High;
    }

    public void setDividendYieldPercentage52High(String dividendYieldPercentage52High) {
        this.dividendYieldPercentage52High = dividendYieldPercentage52High;
    }

    public String getDividendYieldPercentage52Low() {
        return dividendYieldPercentage52Low;
    }

    public void setDividendYieldPercentage52Low(String dividendYieldPercentage52Low) {
        this.dividendYieldPercentage52Low = dividendYieldPercentage52Low;
    }

    public String getDividendYieldPercentageAtCurrent() {
        return dividendYieldPercentageAtCurrent;
    }

    public void setDividendYieldPercentageAtCurrent(String dividendYieldPercentageAtCurrent) {
        this.dividendYieldPercentageAtCurrent = dividendYieldPercentageAtCurrent;
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