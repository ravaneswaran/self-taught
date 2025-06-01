package rave.code.bse.web.service;

import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.model.stock.Stock;
import rave.code.stockmarket.bse.dataaccess.MoneyControlBSEActive200DataAccess;
import rave.code.stockmarket.bse.entity.MoneyControlBSEActive200Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Active200Service extends AbstractService<MoneyControlBSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(Active100Service.class.getName());

    public WebPage getPageModel() {
        WebPage active200Page = new WebPage();
        active200Page.setActive200LinkStyle("font-weight: bold;");

        List<MoneyControlBSEActive200Entity> entities = this.getEntities();
        active200Page.setStocks(this.getStocks(entities));

        return active200Page;
    }

    public List<MoneyControlBSEActive200Entity> getEntities() {
        MoneyControlBSEActive200DataAccess moneyControlBSEActive200DataAccess = new MoneyControlBSEActive200DataAccess();
        return moneyControlBSEActive200DataAccess.findAll();
    }

    public List<Stock> getStocks(List<MoneyControlBSEActive200Entity> entities) {

        List<Stock> stocks = new ArrayList<>();
        for (MoneyControlBSEActive200Entity entity : entities) {
            Stock stock = new Stock();

            stock.setId(entity.getId());
            stock.setCompanyName(entity.getCompanyName());
            stock.setCategory(entity.getCategory());

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
                String upperCircuit = entity.getUpperCircuit();
                if (null != upperCircuit) {
                    stock.setUpperCircuit(Double.parseDouble(upperCircuit));
                } else {
                    stock.setUpperCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setUpperCircuit(0.0);
            }
            try {
                String lowerCircuit = entity.getLowerCircuit();
                if (null != lowerCircuit) {
                    stock.setLowerCircuit(Double.parseDouble(lowerCircuit));
                } else {
                    stock.setLowerCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLowerCircuit(0.0);
            }
            try {
                String percentageChange = entity.getPercentageChange();
                if (null != percentageChange) {
                    stock.setPercentageChange(Double.parseDouble(percentageChange));
                } else {
                    stock.setPercentageChange(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPercentageChange(0.0);
            }
            try {
                String averageVolume5D = entity.getAverageVolume5Days();
                if (null != averageVolume5D) {
                    stock.setAverageVolume5D(Double.parseDouble(averageVolume5D));
                } else {
                    stock.setAverageVolume5D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume5D(0.0);
            }
            try {
                String averageVolume10D = entity.getAverageVolume10Days();
                if (null != averageVolume10D) {
                    stock.setAverageVolume10D(Double.parseDouble(averageVolume10D));
                } else {
                    stock.setAverageVolume10D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume10D(0.0);
            }
            try {
                String averageVolume30D = entity.getAverageVolume30Days();
                if (null != averageVolume30D) {
                    stock.setAverageVolume30D(Double.parseDouble(entity.getAverageVolume30Days()));
                } else {
                    stock.setAverageVolume30D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume30D(0.0);
            }
            try {
                String displacedMovingAverage30D = entity.getDisplacedMovingAverage30D();
                if (null != displacedMovingAverage30D) {
                    stock.setDisplacedMovingAverage30D(Double.parseDouble(displacedMovingAverage30D));
                } else {
                    stock.setDisplacedMovingAverage30D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage30D(0.0);
            }
            try {
                String displacedMovingAverage50D = entity.getDisplacedMovingAverage50D();
                if (null != entity.getDisplacedMovingAverage50D()) {
                    stock.setDisplacedMovingAverage50D(Double.parseDouble(displacedMovingAverage50D));
                } else {
                    stock.setDisplacedMovingAverage50D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage50D(0.0);
            }
            try {
                String displacedMovingAverage150D = entity.getDisplacedMovingAverage150D();
                if (null != displacedMovingAverage150D) {
                    stock.setDisplacedMovingAverage150D(Double.parseDouble(displacedMovingAverage150D));
                } else {
                    stock.setDisplacedMovingAverage150D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage150D(0.0);
            }
            try {
                String displacedMovingAverage200D = entity.getDisplacedMovingAverage200D();
                if (null != displacedMovingAverage200D) {
                    stock.setDisplacedMovingAverage200D(Double.parseDouble(displacedMovingAverage200D));
                } else {
                    stock.setDisplacedMovingAverage200D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage200D(0.0);
            }
            try {
                String peRatio = entity.getPriceToEarningRatio();
                if (null != peRatio) {
                    stock.setPriceToEarningRatio(Double.parseDouble(peRatio));
                } else {
                    stock.setPriceToEarningRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToEarningRatio(0.0);
            }
            try {
                String pbRatio = entity.getPriceToBookRatio();
                if (null != pbRatio) {
                    stock.setPriceToBookRatio(Double.parseDouble(pbRatio));
                } else {
                    stock.setPriceToBookRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToBookRatio(0.0);
            }
            try {
                String vwap = entity.getVolumeWeightedAveragePrice();
                if (null != vwap) {
                    stock.setVolumeWeightedAveragePrice(Double.parseDouble(vwap));
                } else {
                    stock.setVolumeWeightedAveragePrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVolumeWeightedAveragePrice(0.0);
            }
            try {
                String valueInCrores = entity.getValueInCrores();
                if (null != valueInCrores) {
                    stock.setValueInCrores(Double.parseDouble(valueInCrores));
                } else {
                    stock.setValueInCrores(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setValueInCrores(0.0);
            }
            stocks.add(stock);
        }
        return stocks;
    }

}
