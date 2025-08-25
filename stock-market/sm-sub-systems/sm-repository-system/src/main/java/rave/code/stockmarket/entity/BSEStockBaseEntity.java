package rave.code.stockmarket.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@DiscriminatorValue("BSE")
public class BSEStockBaseEntity extends StockBaseEntity{

    public BSEStockBaseEntity(){
        this.setId(UUID.randomUUID().toString());
    }

}
