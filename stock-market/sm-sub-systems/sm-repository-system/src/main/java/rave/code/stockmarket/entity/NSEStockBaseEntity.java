package rave.code.stockmarket.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@DiscriminatorValue("NSE")
public class NSEStockBaseEntity extends StockBaseEntity {

    public NSEStockBaseEntity(){
        this.setId(UUID.randomUUID().toString());
    }
}

