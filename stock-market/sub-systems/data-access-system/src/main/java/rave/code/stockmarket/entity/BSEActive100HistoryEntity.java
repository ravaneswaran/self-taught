package rave.code.stockmarket.entity;

import rave.code.stockmarket.entity.StockMarketActiveHistoryEntity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "bse_active_100_history")
public class BSEActive100HistoryEntity extends StockMarketActiveHistoryEntity {}