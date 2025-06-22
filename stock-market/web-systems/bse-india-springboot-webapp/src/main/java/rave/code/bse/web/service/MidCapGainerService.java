package rave.code.bse.web.service;

import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.model.stock.CapitalGainerStock;
import rave.code.bse.web.service.algorithms.sort.LastPriceComparator;
import rave.code.stockmarket.bse.dataaccess.BSEMidCapGainerDataAccess;
import rave.code.stockmarket.bse.entity.BSEMidCapGainerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MidCapGainerService extends AbstractService<BSEMidCapGainerEntity, CapitalGainerStock> {

    private static final Logger LOGGER = Logger.getLogger(MidCapGainerService.class.getName());

    @Override
    public WebPage getPageModel() {
        WebPage webPage = super.getPageModel();
        webPage.setMidCapGainerLinkStyle("font-weight: bold;");
        return webPage;
    }

    @Override
    public List<BSEMidCapGainerEntity> getEntities() {
        return new BSEMidCapGainerDataAccess().findAll();
    }

    @Override
    public List<CapitalGainerStock> getStocks(List<BSEMidCapGainerEntity> entities) {
        List<CapitalGainerStock> stocks = new ArrayList<>();
        for (BSEMidCapGainerEntity entity : entities) {
            CapitalGainerStock stock = new CapitalGainerStock();

            stock.setDisplayName(entity.getCompanyName());
            String toolTip = String.format("%s", entity.getCompanyName());
            stock.setToolTip(toolTip);
            stock.applyCssStyleBasedOnGroup("A");

            String value = "";
            try {
                value = entity.getHigh();
                if (null != value) {
                    stock.setHigh(Double.parseDouble(value));
                } else {
                    stock.setHigh(0.0);
                }
                ;
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setHigh(0.0);
            }
            try {
                value = entity.getLow();
                if (null != value) {
                    stock.setLow(Double.parseDouble(value));
                } else {
                    stock.setLow(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLow(0.0);
            }
            try {
                value = entity.getLastPrice();
                if (null != value) {
                    stock.setLastPrice(Double.parseDouble(value));
                } else {
                    stock.setLastPrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLastPrice(0.0);
            }
            try {
                value = entity.getPreviousClose();
                if (null != value) {
                    stock.setPreviousClose(Double.parseDouble(value));
                } else {
                    stock.setPreviousClose(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPreviousClose(0.0);
            }
            try {
                value = entity.getVariation();
                if (null != value) {
                    stock.setVariation(Double.parseDouble(value));
                } else {
                    stock.setVariation(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVariation(0.0);
            }
            try {
                value = entity.getPercentageGain();
                if (null != value) {
                    stock.setPercentageGain(Double.parseDouble(value));
                } else {
                    stock.setPercentageGain(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPercentageGain(0.0);
            }
            //---------------------------------------
            try {
                value = entity.getAverageVolume5Days();
                if (null != value) {
                    stock.setAverageVolume5Days(Double.parseDouble(value));
                } else {
                    stock.setAverageVolume5Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume5Days(0.0);
            }
            try {
                value = entity.getAverageVolume10Days();
                if (null != value) {
                    stock.setAverageVolume10Days(Double.parseDouble(value));
                } else {
                    stock.setAverageVolume10Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume10Days(0.0);
            }
            try {
                value = entity.getAverageVolume30Days();
                if (null != value) {
                    stock.setAverageVolume30Days(Double.parseDouble(value));
                } else {
                    stock.setAverageVolume30Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume30Days(0.0);
            }
            try {
                value = entity.getPriceToEarningRatio();
                if (null != value) {
                    stock.setPriceToEarningRatio(Double.parseDouble(value));
                } else {
                    stock.setPriceToEarningRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToEarningRatio(0.0);
            }
            try {
                value = entity.getPriceToBookRatio();
                if (null != value) {
                    stock.setPriceToBookRatio(Double.parseDouble(value));
                } else {
                    stock.setPriceToBookRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToBookRatio(0.0);
            }
            try {
                value = entity.getLowerCircuit();
                if (null != value) {
                    stock.setLowerCircuit(Double.parseDouble(value));
                } else {
                    stock.setLowerCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLowerCircuit(0.0);
            }
            try {
                value = entity.getUpperCircuit();
                if (null != value) {
                    stock.setUpperCircuit(Double.parseDouble(value));
                } else {
                    stock.setUpperCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setUpperCircuit(0.0);
            }
            try {
                value = entity.getVolumeWeightedAveragePrice();
                if (null != value) {
                    stock.setVolumeWeightedAveragePrice(Double.parseDouble(value));
                } else {
                    stock.setVolumeWeightedAveragePrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVolumeWeightedAveragePrice(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage30Days();
                if (null != value) {
                    stock.setDisplacedMovingAverage30Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage30Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage30Days(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage50Days();
                if (null != value) {
                    stock.setDisplacedMovingAverage50Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage50Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage50Days(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage150Days();
                if (null != value) {
                    stock.setDisplacedMovingAverage150Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage150Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage150Days(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage200Days();
                if (null != value) {
                    stock.setDisplacedMovingAverage150Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage150Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage150Days(0.0);
            }

            stocks.add(stock);
        }
        Collections.sort(stocks, new LastPriceComparator());
        return stocks;
    }
}
