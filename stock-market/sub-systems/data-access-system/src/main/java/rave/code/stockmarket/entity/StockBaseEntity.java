package rave.code.stockmarket.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stock_base")
@Access(AccessType.PROPERTY)
public class StockBaseEntity extends StockMarketEntity {

    private String BSEBasePrice;
    private String NSEBasePrice;
    private int NSE;
    private int BSE;

    @Column(name = "bse_base_price")
    public String getBSEBasePrice() {
        return BSEBasePrice;
    }
    public void setBSEBasePrice(String BSEBasePrice) {
        this.BSEBasePrice = BSEBasePrice;
    }

    @Column(name = "nse_base_price")
    public String getNSEBasePrice() {
        return NSEBasePrice;
    }
    public void setNSEBasePrice(String NSEBasePrice) {
        this.NSEBasePrice = NSEBasePrice;
    }

    @Column(name = "nse")
    public int getNSE() {
        return NSE;
    }
    public void setNSE(int NSE) {
        this.NSE = NSE;
    }

    @Column(name = "bse")
    public int getBSE() {
        return BSE;
    }
    public void setBSE(int BSE) {
        this.BSE = BSE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        StockBaseEntity that = (StockBaseEntity) obj;
        return this.getStockName().equals(that.getStockName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getStockName());
    }
}
