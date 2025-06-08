package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlPriceShockerModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEPriceShockersParser extends HTMLSourceParser<MoneyControlPriceShockerModel> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEPriceShockersParser.class.getName());

    public MoneyControlBSEPriceShockersParser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse_pshockers/index.php
        super("https://www.moneycontrol.com/stocks/marketstats/bse_pshockers/index.php");
    }

    @Override
    public List<MoneyControlPriceShockerModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
                this.parse();
            }

            List<MoneyControlPriceShockerModel> moneyControlPriceShockerModels = new ArrayList<>();

            if (document != null) {
                Element table = document.select("table").get(1);
                Element tableBody = table.select("tbody").get(0);
                Elements tableRows = tableBody.select("tr");

                for (Element tr : tableRows) {
                    Elements tableData = tr.select("td");

                    // the reason why we check this condition is to make sure that we have more or equal to 24 <td>s for the data to be parsed for our need.
                    if (tableData.size() >= 22) {
                        Elements companyNameAnchorElements = tableData.get(0).select("a");

                        String companyName = "COMPANY-NAME : SOURCE DATA ERROR";
                        if (companyNameAnchorElements.size() > 0) {
                            companyName = companyNameAnchorElements.get(0).text();
                        }

                        String group = tableData.get(1).text();
                        String sector = tableData.get(2).text();
                        String currentPrice = tableData.get(3).text();
                        String previousPrice = tableData.get(4).text();
                        String percentageChange = tableData.get(5).text();

                        Elements averageVolumeTables = tableData.get(6).select("table");
                        String averageVolume5Days = "0.00";
                        String averageVolume10Days = "0.00";
                        String averageVolume30Days = "0.00";

                        if (averageVolumeTables.size() > 0) {
                            Element averageVolumeTable = tableData.get(6).select("table").get(0);
                            Element averageVolumeTableBody = averageVolumeTable.select("tbody").get(0);

                            Element averageVolume5DaysTableRow = averageVolumeTableBody.select("tr").get(0);
                            Element averageVolume10DaysTableRow = averageVolumeTableBody.select("tr").get(1);
                            Element averageVolume30DaysTableRow = averageVolumeTableBody.select("tr").get(2);

                            averageVolume5Days = averageVolume5DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume10Days = averageVolume10DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume30Days = averageVolume30DaysTableRow.select("td").get(1).select("strong").get(0).text();
                        }

                        String displacedMovingAverage30Days = tableData.get(13).text();
                        String displacedMovingAverage50Days = tableData.get(14).text();
                        String displacedMovingAverage150Days = tableData.get(15).text();
                        String displacedMovingAverage200Days = tableData.get(16).text();

                        String priceToEarningRatio = tableData.get(17).text();
                        String priceToBookRatio = tableData.get(18).text();
                        String upperCircuit = tableData.get(21).text();
                        String lowerCircuit = tableData.get(22).text();
                        String volumeWeightedAveragePrice = "NO_DATA";

                        MoneyControlPriceShockerModel moneyControlPriceShockerModel = new MoneyControlPriceShockerModel();
                        moneyControlPriceShockerModel.setCompanyName(companyName);
                        moneyControlPriceShockerModel.setGroup(group);
                        moneyControlPriceShockerModel.setSector(sector);
                        moneyControlPriceShockerModel.setCurrentPrice(currentPrice);
                        moneyControlPriceShockerModel.setPreviousPrice(previousPrice);
                        moneyControlPriceShockerModel.setPercentageChange(percentageChange);
                        moneyControlPriceShockerModel.setAverageVolume5Days(averageVolume5Days);
                        moneyControlPriceShockerModel.setAverageVolume10Days(averageVolume10Days);
                        moneyControlPriceShockerModel.setAverageVolume30Days(averageVolume30Days);
                        moneyControlPriceShockerModel.setPriceToEarningRatio(priceToEarningRatio);
                        moneyControlPriceShockerModel.setPriceToBookRatio(priceToBookRatio);
                        moneyControlPriceShockerModel.setUpperCircuit(upperCircuit);
                        moneyControlPriceShockerModel.setLowerCircuit(lowerCircuit);
                        moneyControlPriceShockerModel.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                        moneyControlPriceShockerModel.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                        moneyControlPriceShockerModel.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                        moneyControlPriceShockerModel.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                        moneyControlPriceShockerModel.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                        moneyControlPriceShockerModels.add(moneyControlPriceShockerModel);
                    }
                }
            }
            return moneyControlPriceShockerModels;
        } catch (SocketTimeoutException socketTimeoutException) {
            LOGGER.log(Level.SEVERE, socketTimeoutException.getMessage(), socketTimeoutException);
            LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
            return this.parse();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlBSEPriceShockersParser moneyControlPriceShockersParser = new MoneyControlBSEPriceShockersParser();
        moneyControlPriceShockersParser.parse();
    }
}
