package rave.code.data.parser.html.moneycontrol;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.data.parser.html.HTMLSourceParser;
import rave.code.website.data.model.moneycontrol.PriceShockerModel;
import rave.code.website.data.model.moneycontrol.VolumeShockerModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEVolumeShockersParser extends HTMLSourceParser<VolumeShockerModel> {

    private static final Logger LOGGER = Logger.getLogger(BSEVolumeShockersParser.class.getName());

    public BSEVolumeShockersParser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse_vshockers/index.php
        super("https://www.moneycontrol.com/stocks/marketstats/bse_vshockers/index.php");
    }

    public static void main(String[] args) {
        BSEVolumeShockersParser bseVolumeShockersParser = new BSEVolumeShockersParser();
        bseVolumeShockersParser.parse();
    }

    @Override
    public List<VolumeShockerModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
                this.parse();
            }

            List<VolumeShockerModel> volumeShockerModels = new ArrayList<>();

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
                        String lastPrice = tableData.get(3).text();
                        String percentageChange = tableData.get(4).text();
                        String averageVolume = tableData.get(5).text();

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

                        VolumeShockerModel volumeShockerModel = new VolumeShockerModel();
                        volumeShockerModel.setCompanyName(companyName);
                        volumeShockerModel.setGroup(group);
                        volumeShockerModel.setSector(sector);
                        volumeShockerModel.setLastPrice(lastPrice);
                        volumeShockerModel.setAverageVolume(averageVolume);
                        volumeShockerModel.setPercentageChange(percentageChange);
                        volumeShockerModel.setAverageVolume5Days(averageVolume5Days);
                        volumeShockerModel.setAverageVolume10Days(averageVolume10Days);
                        volumeShockerModel.setAverageVolume30Days(averageVolume30Days);
                        volumeShockerModel.setPriceToEarningRatio(priceToEarningRatio);
                        volumeShockerModel.setPriceToBookRatio(priceToBookRatio);
                        volumeShockerModel.setUpperCircuit(upperCircuit);
                        volumeShockerModel.setLowerCircuit(lowerCircuit);
                        volumeShockerModel.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                        volumeShockerModel.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                        volumeShockerModel.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                        volumeShockerModel.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                        volumeShockerModel.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                        volumeShockerModels.add(volumeShockerModel);
                    }
                }
            }
            return volumeShockerModels;
        } catch (SocketTimeoutException socketTimeoutException) {
            LOGGER.log(Level.SEVERE, socketTimeoutException.getMessage(), socketTimeoutException);
            LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
            return this.parse();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            return new ArrayList<>();
        }
    }
}
