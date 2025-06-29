package rave.code.bse.web.service.decorators;

import rave.code.bse.web.model.stock.ActiveStock;
import rave.code.bse.web.model.stock.CapitalGainerStock;
import rave.code.bse.web.model.stock.Stock;

public class StockPBRatioDecorator implements Decorator {

    @Override
    public Stock decorate(Stock stock) {
        double pbRatio = 0;

        if (stock instanceof ActiveStock) {
            pbRatio = ((ActiveStock) stock).getPriceToBookRatio() * 100;;
        } else if (stock instanceof CapitalGainerStock) {
            pbRatio = ((CapitalGainerStock) stock).getPriceToBookRatio() * 100;;
        }

        int pbRatioPercentage = 0;
        if (pbRatio <= 0) {
            pbRatioPercentage = 25;
        } else if (pbRatio >= 0 && pbRatio <= 25) {
            pbRatioPercentage = 25;
        } else if (pbRatio >= 26 && pbRatio <= 50) {
            pbRatioPercentage = 50;
        } else if (pbRatio >= 51 && pbRatio <= 75) {
            pbRatioPercentage = 75;
        } else if (pbRatio >= 76 && pbRatio <= 100) {
            pbRatioPercentage = 100;
        } else {
            pbRatioPercentage = 200;
        }

        switch (pbRatioPercentage) {
            case 25:
                stock.setTitleCssStyle(String.format("%s %s", stock.getTitleCssStyle(), "green-under-valued"));
                break;
            case 50:
                stock.setTitleCssStyle(String.format("%s %s", stock.getTitleCssStyle(), "yellow-under-valued"));
                break;
            case 75:
                stock.setTitleCssStyle(String.format("%s %s", stock.getTitleCssStyle(), "orange-under-valued"));
                break;
            case 100:
                stock.setTitleCssStyle(String.format("%s %s", stock.getTitleCssStyle(), "white-equally-valued"));
                break;
            default:
                stock.setTitleCssStyle(String.format("%s %s", stock.getTitleCssStyle(), "red-over-valued"));
                break;
        }

        return stock;
    }
}
