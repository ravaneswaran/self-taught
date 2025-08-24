package rave.code.stockmarket.entity;

import javax.persistence.DiscriminatorValue;
import java.util.UUID;

@DiscriminatorValue("BSE")
public class BSEStockBaseEntity extends StockBaseEntity{

    public BSEStockBaseEntity(){
        this.setId(UUID.randomUUID().toString());
    }

}
