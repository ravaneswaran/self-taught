package rave.code.stockmarket.bse.entity;

import rave.code.stockmarket.StockMarketActiveEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_sensex")
@Access(AccessType.PROPERTY)
public class BSESensexEntity extends StockMarketActiveEntity {}
