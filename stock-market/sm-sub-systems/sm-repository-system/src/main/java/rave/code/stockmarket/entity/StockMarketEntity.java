package rave.code.stockmarket.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class StockMarketEntity extends AbstractStockEntity {

    private boolean newEntity;
    protected String stockName;

    public StockMarketEntity() {
        this.setNewEntity(true);
    }

    @Id
    @Column(name = "stock_name")
    public String getStockName() {
        return stockName;
    }
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Transient
    public boolean isNewEntity() {
        return newEntity;
    }
    public void setNewEntity(boolean newEntity) {
        this.newEntity = newEntity;
    }

}
