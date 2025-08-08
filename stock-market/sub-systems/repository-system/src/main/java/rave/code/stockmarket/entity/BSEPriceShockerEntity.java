package rave.code.stockmarket.entity;

import rave.code.stockmarket.entity.StockMarketShockerEntity;

import javax.persistence.*;

@Entity
@Table(name = "bse_price_shockers")
@Access(AccessType.PROPERTY)
public class BSEPriceShockerEntity extends StockMarketShockerEntity {

    private String previousPrice;
    private String currentPrice;
    private String currentPriceMovement;

    @Column(name = "current_price")
    public String getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Column(name = "current_price_movement")
    public String getCurrentPriceMovement() {
        return currentPriceMovement;
    }
    public void setCurrentPriceMovement(String currentPriceMovement) {
        this.currentPriceMovement = currentPriceMovement;
    }

    @Column(name = "previous_price")
    public String getPreviousPrice() {return previousPrice;}
    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }
}
