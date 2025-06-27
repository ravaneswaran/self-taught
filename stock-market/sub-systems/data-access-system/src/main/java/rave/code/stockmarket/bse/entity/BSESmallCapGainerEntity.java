package rave.code.stockmarket.bse.entity;

import rave.code.stockmarket.StockMarketGainerEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_small_cap_gainer")
@Access(AccessType.PROPERTY)
public class BSESmallCapGainerEntity extends StockMarketGainerEntity {}