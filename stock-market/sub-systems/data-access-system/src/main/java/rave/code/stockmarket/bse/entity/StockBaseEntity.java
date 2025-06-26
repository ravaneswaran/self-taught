package rave.code.stockmarket.bse.entity;

import lombok.Data;
import rave.code.stockmarket.AbstractEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "stock-base")
@Entity
@Data
@Table(name = "stock_base")
public class StockBaseEntity extends AbstractEntity {

    @Id
    @Column(name = "stock_name")
    private String stockName;
    @Column(name = "bse_base_price")
    private String BSEBasePrice;
    @Column(name = "nse_base_price")
    private String NSEBasePrice;
    @Column(name = "nse")
    private int NSE;
    @Column(name = "bse")
    private int BSE;
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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getBSEBasePrice() {
        return BSEBasePrice;
    }

    public void setBSEBasePrice(String BSEBasePrice) {
        this.BSEBasePrice = BSEBasePrice;
    }

    public String getNSEBasePrice() {
        return NSEBasePrice;
    }

    public void setNSEBasePrice(String NSEBasePrice) {
        this.NSEBasePrice = NSEBasePrice;
    }

    public int getNSE() {
        return NSE;
    }

    public void setNSE(int NSE) {
        this.NSE = NSE;
    }

    public int getBSE() {
        return BSE;
    }

    public void setBSE(int BSE) {
        this.BSE = BSE;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        StockBaseEntity that = (StockBaseEntity) obj;
        return this.stockName.equals(that.getStockName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.stockName);
    }
}
