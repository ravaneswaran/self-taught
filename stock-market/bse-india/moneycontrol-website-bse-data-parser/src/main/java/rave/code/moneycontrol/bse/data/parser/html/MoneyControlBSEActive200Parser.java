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

public class MoneyControlBSEActive200Parser extends HTMLSourceParser<MoneyControlGenericBSEActiveModel> {

    public MoneyControlBSEActive200Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-200_2/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-200-2/");
    }

    @Override
    public List<MoneyControlGenericBSEActiveModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");

            List<MoneyControlGenericBSEActiveModel> moneyControlBSEActive200Models = new ArrayList<>();

            for (Element tr : tableRows) {
                try {
                    Elements tableData = tr.select("td");

                    /*for(int i=0; i <= 30; i++) {
                        String element = tableData.get(i).toString();
                        System.out.println(i + " ================>>>>>>> " + element);
                    }*/

                    Element companyNameElement = tableData.get(0).select("a").get(0);

                    String companyName = companyNameElement.text();
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

                    MoneyControlGenericBSEActiveModel moneyControlBSEActive200Model = new MoneyControlGenericBSEActiveModel();
                    moneyControlBSEActive200Model.setCompanyName(companyName);
                    moneyControlBSEActive200Model.setGroup(group);
                    moneyControlBSEActive200Model.setHigh(high);
                    moneyControlBSEActive200Model.setLow(low);
                    moneyControlBSEActive200Model.setLastPrice(lastPrice);
                    moneyControlBSEActive200Model.setPercentageChange(percentageChange);
                    moneyControlBSEActive200Model.setValueInCrores(valueInCrores);
                    moneyControlBSEActive200Model.setAverageVolume5Days(averageVolume5Days);
                    moneyControlBSEActive200Model.setAverageVolume10Days(averageVolume10Days);
                    moneyControlBSEActive200Model.setAverageVolume30Days(averageVolume30Days);
                    moneyControlBSEActive200Model.setPriceToEarningRatio(priceToEarningRatio);
                    moneyControlBSEActive200Model.setPriceToBookRatio(priceToBookRatio);
                    moneyControlBSEActive200Model.setUpperCircuit(upperCircuit);
                    moneyControlBSEActive200Model.setLowerCircuit(lowerCircuit);
                    moneyControlBSEActive200Model.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                    moneyControlBSEActive200Model.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                    moneyControlBSEActive200Model.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                    moneyControlBSEActive200Model.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                    moneyControlBSEActive200Model.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                    moneyControlBSEActive200Models.add(moneyControlBSEActive200Model);
                }catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
            return moneyControlBSEActive200Models;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlBSEActive200Parser moneyControlBSEActive200Parser = new MoneyControlBSEActive200Parser();
        moneyControlBSEActive200Parser.parse();
    }
}
