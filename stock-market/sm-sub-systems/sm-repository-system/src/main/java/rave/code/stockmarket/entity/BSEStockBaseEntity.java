package rave.code.stockmarket.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BSE")
public class BSEStockBaseEntity extends StockBaseEntity{}
