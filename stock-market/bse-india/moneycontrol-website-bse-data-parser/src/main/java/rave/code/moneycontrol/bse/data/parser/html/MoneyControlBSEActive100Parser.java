package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.bse.data.parser.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericBSEActiveModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEActive100Parser extends HTMLSourceParser<MoneyControlGenericBSEActiveModel> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive100Parser.class.getName());

    public MoneyControlBSEActive100Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-100_1/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-100-1/");
    }

    @Override
    public List<MoneyControlGenericBSEActiveModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");

            List<MoneyControlGenericBSEActiveModel> moneyControlBSEActive100Models = new ArrayList<>();

            for (Element tr : tableRows) {

                /*Elements tableData = tr.select("td");
                for (int i = 0; i < tableData.size(); i++) {
                    String element = tableData.get(i).toString();
                    //System.out.println(i + " ================>>>>>>> " + element);
                    Element companyNameElement = tableData.get(0).select("a").get(0);
                    System.out.println(companyNameElement.text());
                }*/

                Elements tableData = tr.select("td");
                if (tableData.size() > 0) {
                    Elements companyNameAnchorElements = tableData.get(0).select("a");

                    if (companyNameAnchorElements.size() > 0) {
                        String companyName = companyNameAnchorElements.get(0).text();

                        String group = tableData.get(1).text();
                        String high = tableData.get(2).text();
                        String low = tableData.get(3).text();
                        String lastPrice = tableData.get(4).text();
                        String percentageChange = tableData.get(5).text();
                        String valueInCrores = tableData.get(6).text();

                        Element averageVolumeTable = tableData.get(7).select("table").get(0);
                        Element averageVolumeTableBody = averageVolumeTable.select("tbody").get(0);

                        Element averageVolume5DaysTableRow = averageVolumeTableBody.select("tr").get(0);
                        Element averageVolume10DaysTableRow = averageVolumeTableBody.select("tr").get(1);
                        Element averageVolume30DaysTableRow = averageVolumeTableBody.select("tr").get(2);

                        String averageVolume5Days = averageVolume5DaysTableRow.select("td").get(1).select("strong").get(0).text();
                        String averageVolume10Days = averageVolume10DaysTableRow.select("td").get(1).select("strong").get(0).text();
                        String averageVolume30Days = averageVolume30DaysTableRow.select("td").get(1).select("strong").get(0).text();

                        String displacedMovingAverage30Days = tableData.get(14).text();
                        String displacedMovingAverage50Days = tableData.get(15).text();
                        String displacedMovingAverage150Days = tableData.get(16).text();
                        String displacedMovingAverage200Days = tableData.get(17).text();

                        String priceToEarningRatio = tableData.get(18).text();
                        String priceToBookRatio = tableData.get(19).text();
                        String upperCircuit = tableData.get(22).text();
                        String lowerCircuit = tableData.get(23).text();
                        String volumeWeightedAveragePrice = tableData.get(24).text();

                        MoneyControlGenericBSEActiveModel moneyControlBSEActive100Model = new MoneyControlGenericBSEActiveModel();
                        moneyControlBSEActive100Model.setCompanyName(companyName);
                        moneyControlBSEActive100Model.setGroup(group);
                        moneyControlBSEActive100Model.setHigh(high);
                        moneyControlBSEActive100Model.setLow(low);
                        moneyControlBSEActive100Model.setLastPrice(lastPrice);
                        moneyControlBSEActive100Model.setPercentageChange(percentageChange);
                        moneyControlBSEActive100Model.setValueInCrores(valueInCrores);
                        moneyControlBSEActive100Model.setAverageVolume5Days(averageVolume5Days);
                        moneyControlBSEActive100Model.setAverageVolume10Days(averageVolume10Days);
                        moneyControlBSEActive100Model.setAverageVolume30Days(averageVolume30Days);
                        moneyControlBSEActive100Model.setPriceToEarningRatio(priceToEarningRatio);
                        moneyControlBSEActive100Model.setPriceToBookRatio(priceToBookRatio);
                        moneyControlBSEActive100Model.setUpperCircuit(upperCircuit);
                        moneyControlBSEActive100Model.setLowerCircuit(lowerCircuit);
                        moneyControlBSEActive100Model.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                        moneyControlBSEActive100Model.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                        moneyControlBSEActive100Model.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                        moneyControlBSEActive100Model.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                        moneyControlBSEActive100Model.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                        moneyControlBSEActive100Models.add(moneyControlBSEActive100Model);
                    }
                }
            }
            return moneyControlBSEActive100Models;
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
        MoneyControlBSEActive100Parser moneyControlBSEActive100Parser = new MoneyControlBSEActive100Parser();
        moneyControlBSEActive100Parser.parse();
    }
}