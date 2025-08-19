package rave.code.stockmarket.entity;

import javax.persistence.*;

@Entity
@Table(name = "bse_top_dividend")
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BSETopDividendEntity extends StockMarketDividendEntity {}