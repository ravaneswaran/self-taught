package rave.code.bse.web.service;

import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.model.stock.CapitalGainerStock;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEMidCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEMidCapGainerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MidCapGainerService extends AbstractService<MoneyControlBSEMidCapGainerEntity, CapitalGainerStock> {

    private static final Logger LOGGER = Logger.getLogger(MidCapGainerService.class.getName());

    @Override
    public WebPage getPageModel() {
        WebPage webPage = super.getPageModel();
        webPage.setMidCapGainerLinkStyle("font-weight: bold;");
        return webPage;
    }

    @Override
    public List<MoneyControlBSEMidCapGainerEntity> getEntities() {
        return new MoneyControlBSEMidCapGainerDataAccess().findAll();
    }

    @Override
    public List<CapitalGainerStock> getStocks(List<MoneyControlBSEMidCapGainerEntity> entities) {
        List<CapitalGainerStock> stocks = new ArrayList<>();
        for (MoneyControlBSEMidCapGainerEntity entity : entities) {
            CapitalGainerStock stock = new CapitalGainerStock();

            stock.setId(entity.getId());
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
        return stocks;
    }
}
