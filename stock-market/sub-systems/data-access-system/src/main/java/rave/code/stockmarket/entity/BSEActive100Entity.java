package rave.code.stockmarket.entity;

import rave.code.stockmarket.entity.StockMarketActiveEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bse_active_100")
@Access(AccessType.PROPERTY)
public class BSEActive100Entity extends StockMarketActiveEntity {}