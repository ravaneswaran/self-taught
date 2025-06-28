package rave.code.stockmarket.entity;

import rave.code.stockmarket.entity.StockMarketActiveHistoryEntity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "bse_active_500_history")
public class BSEActive500HistoryEntity extends StockMarketActiveHistoryEntity {}