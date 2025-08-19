package rave.code.stockmarket.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NSE")
public class NSEStockBaseEntity extends StockBaseEntity {
}

