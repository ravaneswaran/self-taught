package rave.code.stockmarket.bse.entity;

import rave.code.stockmarket.StockMarketActiveHistoryEntity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "bse_active_500_history")
public class BSEActive500HistoryEntity extends StockMarketActiveHistoryEntity {}