package rave.code.stockmarket.entity;

import rave.code.stockmarket.entity.StockMarketActiveHistoryEntity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "bse_active_200_history")
public class BSEActive200HistoryEntity extends StockMarketActiveHistoryEntity {}