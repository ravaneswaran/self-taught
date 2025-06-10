package rave.code.data.parser.html.moneycontrol;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.data.parser.html.HTMLSourceParser;
import rave.code.website.data.model.moneycontrol.CapitalGainerModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSESmallCapGainersParser extends HTMLSourceParser<CapitalGainerModel> {

    private static final Logger LOGGER = Logger.getLogger(BSESmallCapGainersParser.class.getName());

    public BSESmallCapGainersParser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-smallcap_26/");
    }

    @Override
    public List<CapitalGainerModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
                this.parse();
            }

            List<CapitalGainerModel> moneyControlCapGainerModels = new ArrayList<>();

            if (document != null) {
                Element table = document.select("table").get(1);
                Element tableBody = table.select("tbody").get(0);
                Elements tableRows = tableBody.select("tr");

                for (Element tr : tableRows) {

                    Elements tableData = tr.select("td");

                   /* for (int i = 0; i < tableData.size() - 1; i++) {
                        String element = tableData.get(i).toString();
                        System.out.println(i + " ================>>>>>>> " + element);
                        Elements companyNameAnchorElements = tableData.get(0).select("a");
                        String companyName = "COMPANY-NAME : SOURCE DATA ERROR";
                        if (companyNameAnchorElements.size() > 0) {
                            companyName = companyNameAnchorElements.get(0).text();
                            System.out.println(companyName);
                        }
                    }*/

                    // the reason why we check this condition is to make sure that we have more or equal to 24 <td>s for the data to be parsed for our need.
                    if (tableData.size() >= 23) {
                        Elements companyNameAnchorElements = tableData.get(0).select("a");

                        String companyName = "COMPANY-NAME : SOURCE DATA ERROR";
                        if (companyNameAnchorElements.size() > 0) {
                            companyName = companyNameAnchorElements.get(0).text();
                        }
                        String high = tableData.get(1).text();
                        String low = tableData.get(2).text();
                        String lastPrice = tableData.get(3).text();
                        String previousClose = tableData.get(4).text();
                        String change = tableData.get(5).text();
                        String percentageGain = tableData.get(6).text();

                        Elements averageVolumeTables = tableData.get(7).select("table");
                        String averageVolume5Days = "0.00";
                        String averageVolume10Days = "0.00";
                        String averageVolume30Days = "0.00";

                        if (averageVolumeTables.size() > 0) {
                            Element averageVolumeTable = tableData.get(7).select("table").get(0);
                            Element averageVolumeTableBody = averageVolumeTable.select("tbody").get(0);

                            Element averageVolume5DaysTableRow = averageVolumeTableBody.select("tr").get(0);
                            Element averageVolume10DaysTableRow = averageVolumeTableBody.select("tr").get(1);
                            Element averageVolume30DaysTableRow = averageVolumeTableBody.select("tr").get(2);

                            averageVolume5Days = averageVolume5DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume10Days = averageVolume10DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume30Days = averageVolume30DaysTableRow.select("td").get(1).select("strong").get(0).text();
                        }

                        String displacedMovingAverage30Days = tableData.get(14).text();
                        String displacedMovingAverage50Days = tableData.get(15).text();
                        String displacedMovingAverage150Days = tableData.get(16).text();
                        String displacedMovingAverage200Days = tableData.get(17).text();

                        String priceToEarningRatio = tableData.get(18).text();
                        String priceToBookRatio = tableData.get(19).text();
                        String upperCircuit = tableData.get(22).text();
                        String lowerCircuit = tableData.get(23).text();
                        String volumeWeightedAveragePrice = tableData.get(24).text();

                        CapitalGainerModel moneyControlCapGainerModel = new CapitalGainerModel();

                        moneyControlCapGainerModel.setCompanyName(companyName);
                        moneyControlCapGainerModel.setHigh(high);
                        moneyControlCapGainerModel.setLow(low);
                        moneyControlCapGainerModel.setLastPrice(lastPrice);
                        moneyControlCapGainerModel.setPreviousClose(previousClose);
                        moneyControlCapGainerModel.setChange(change);
                        moneyControlCapGainerModel.setPercentageGain(percentageGain);
                        moneyControlCapGainerModel.setAverageVolume5Days(averageVolume5Days);
                        moneyControlCapGainerModel.setAverageVolume10Days(averageVolume10Days);
                        moneyControlCapGainerModel.setAverageVolume30Days(averageVolume30Days);
                        moneyControlCapGainerModel.setPriceToEarningRatio(priceToEarningRatio);
                        moneyControlCapGainerModel.setPriceToBookRatio(priceToBookRatio);
                        moneyControlCapGainerModel.setUpperCircuit(upperCircuit);
                        moneyControlCapGainerModel.setLowerCircuit(lowerCircuit);
                        moneyControlCapGainerModel.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                        moneyControlCapGainerModel.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                        moneyControlCapGainerModel.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                        moneyControlCapGainerModel.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                        moneyControlCapGainerModel.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                        moneyControlCapGainerModels.add(moneyControlCapGainerModel);
                    }
                }
            }
            return moneyControlCapGainerModels;
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
        BSESmallCapGainersParser moneyControlBSESmallCapGainersParser = new BSESmallCapGainersParser();
        moneyControlBSESmallCapGainersParser.parse();
    }
}
