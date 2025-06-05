package rave.code.bse.web.service;

import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.model.stock.CapitalGainerStock;
import rave.code.bse.web.service.algorithms.sort.LastPriceComparator;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSESmallCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSESmallCapGainerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmallCapGainerService extends AbstractService<MoneyControlBSESmallCapGainerEntity, CapitalGainerStock> {

    private static final Logger LOGGER = Logger.getLogger(SmallCapGainerService.class.getName());

    @Override
    public WebPage getPageModel() {
        WebPage webPage = super.getPageModel();
        webPage.setSmallCapGainerLinkStyle("font-weight: bold;");
        return webPage;
    }

    @Override
    public List<MoneyControlBSESmallCapGainerEntity> getEntities() {
        return new MoneyControlBSESmallCapGainerDataAccess().findAll();
    }

    @Override
    public List<CapitalGainerStock> getStocks(List<MoneyControlBSESmallCapGainerEntity> entities) {

        List<CapitalGainerStock> stocks = new ArrayList<>();
        for (MoneyControlBSESmallCapGainerEntity entity : entities) {
            CapitalGainerStock stock = new CapitalGainerStock();

            stock.setCompanyName(entity.getCompanyName());

            try {
                String high = entity.getHigh();
                if (null != high) {
                    stock.setHigh(Double.parseDouble(high));
                } else {
                    stock.setHigh(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setHigh(0.0);
            }
            try {
                String low = entity.getLow();
                if (null != low) {
                    stock.setLow(Double.parseDouble(low));
                } else {
                    stock.setLow(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLow(0.0);
            }
            try {
                String lastPrice = entity.getLastPrice();
                if (null != lastPrice) {
                    stock.setLastPrice(Double.parseDouble(lastPrice));
                } else {
                    stock.setLastPrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLastPrice(0.0);
            }
            try {
                String previousClose = entity.getPreviousClose();
                if (null != previousClose) {
                    stock.setPreviousClose(Double.parseDouble(previousClose));
                } else {
                    stock.setPreviousClose(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPreviousClose(0.0);
            }
            try {
                String variation = entity.getVariation();
                if (null != variation) {
                    stock.setVariation(Double.parseDouble(variation));
                } else {
                    stock.setVariation(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVariation(0.0);
            }
            try {
                String percentageGain = entity.getPercentageGain();
                if (null != percentageGain) {
                    stock.setPercentageGain(Double.parseDouble(percentageGain));
                } else {
                    stock.setPercentageGain(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPercentageGain(0.0);
            }
            stocks.add(stock);
        }
        Collections.sort(stocks, new LastPriceComparator());
        return stocks;
    }

}
