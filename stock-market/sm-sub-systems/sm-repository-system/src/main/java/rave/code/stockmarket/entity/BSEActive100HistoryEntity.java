package rave.code.stockmarket.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "bse_active_100_history")
public class BSEActive100HistoryEntity extends StockMarketActiveHistoryEntity {}