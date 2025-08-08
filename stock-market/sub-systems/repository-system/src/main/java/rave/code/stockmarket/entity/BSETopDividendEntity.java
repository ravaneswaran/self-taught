package rave.code.stockmarket.entity;

import rave.code.stockmarket.entity.StockMarketDividendEntity;

import javax.persistence.*;

@Entity
@Table(name = "bse_top_dividend")
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BSETopDividendEntity extends StockMarketDividendEntity {}