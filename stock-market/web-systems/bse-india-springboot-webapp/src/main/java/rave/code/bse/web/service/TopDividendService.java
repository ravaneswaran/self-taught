package rave.code.bse.web.service;

import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.model.stock.TopDividendStock;
import rave.code.bse.web.service.algorithms.sort.LastPriceComparator;
import rave.code.stockmarket.bse.dataaccess.BSETopDividendDataAccess;
import rave.code.stockmarket.bse.entity.BSETopDividendEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TopDividendService extends AbstractService<BSETopDividendEntity, TopDividendStock> {

    private static final Logger LOGGER = Logger.getLogger(TopDividendService.class.getName());

    @Override
    public WebPage getPageModel() {
        WebPage webPage = super.getPageModel();
        webPage.setTopDividendLinkStyle("font-weight: bold;");
        return webPage;
    }

    @Override
    public List<BSETopDividendEntity> getEntities() {
        BSETopDividendDataAccess moneyControlBSETopDividendDataAccess = new BSETopDividendDataAccess();
        return moneyControlBSETopDividendDataAccess.findAll();
    }

    @Override
    public List<TopDividendStock> getStocks(List<BSETopDividendEntity> entities) {

        List<TopDividendStock> stocks = new ArrayList<>();
        for (BSETopDividendEntity entity : entities) {
            TopDividendStock stock = new TopDividendStock();

            stock.setCompanyName(entity.getCompanyName());
            stock.setToolTip(entity.getCompanyName());

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
                String dividendYieldPercentage52High = entity.getDividendYieldPercentage52High();
                if (null != dividendYieldPercentage52High) {
                    stock.setDividendYieldPercentage52High(Double.parseDouble(dividendYieldPercentage52High));
                } else {
                    stock.setDividendYieldPercentage52High(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDividendYieldPercentage52High(0.0);
            }
            try {
                String dividendYieldPercentage52Low = entity.getDividendYieldPercentage52Low();
                if (null != dividendYieldPercentage52Low) {
                    stock.setDividendYieldPercentage52Low(Double.parseDouble(dividendYieldPercentage52Low));
                } else {
                    stock.setDividendYieldPercentage52Low(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDividendYieldPercentage52Low(0.0);
            }
            try {
                String dividendYieldPercentageAtCurrent = entity.getDividendYieldPercentageAtCurrent();
                if (null != dividendYieldPercentageAtCurrent) {
                    stock.setDividendYieldPercentageAtCurrent(Double.parseDouble(dividendYieldPercentageAtCurrent));
                } else {
                    stock.setDividendYieldPercentageAtCurrent(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDividendYieldPercentageAtCurrent(0.0);
            }

            stocks.add(stock);
        }

        Collections.sort(stocks, new LastPriceComparator());
        return stocks;
    }
}
