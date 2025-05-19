package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.bse.data.parser.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericBSEActiveModel;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericModel;

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
                    Element companyNameElement = tableData.get(0).select("a").get(0);

                    String companyName = companyNameElement.text();
                    String group = tableData.get(1).text();
                    String high = tableData.get(2).text();
                    String low = tableData.get(3).text();
                    String lastPrice = tableData.get(4).text();
                    String percentageChange = tableData.get(5).text();
                    String valueInCrores = tableData.get(6).text();

                    MoneyControlGenericBSEActiveModel moneyControlBSEActive200Model = new MoneyControlGenericBSEActiveModel();
                    moneyControlBSEActive200Model.setCompanyName(companyName);
                    moneyControlBSEActive200Model.setGroup(group);
                    moneyControlBSEActive200Model.setHigh(high);
                    moneyControlBSEActive200Model.setLow(low);
                    moneyControlBSEActive200Model.setLastPrice(lastPrice);
                    moneyControlBSEActive200Model.setPercentageChange(percentageChange);
                    moneyControlBSEActive200Model.setValueInCrores(valueInCrores);

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
