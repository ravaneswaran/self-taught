package rave.code.stockmarket.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_active_200")
@Access(AccessType.PROPERTY)
public class BSEActive200Entity extends StockMarketActiveEntity {}