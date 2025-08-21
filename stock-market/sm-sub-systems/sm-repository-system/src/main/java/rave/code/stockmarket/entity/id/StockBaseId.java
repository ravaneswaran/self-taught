package rave.code.stockmarket.entity.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StockBaseId {

    private String source;
    private String symbol;

    @Column(name = "source")
    public String getSource() {return source;}
    public void setSource(String source) {this.source = source;}

    @Column(name = "symbol")
    public String getSymbol() {return symbol;}
    public void setSymbol(String symbol) {this.symbol = symbol;}
}
