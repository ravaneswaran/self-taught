package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.bse.data.parser.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlBSEActive100Model;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSEActive100Parser extends HTMLSourceParser<MoneyControlBSEActive100Model> {

    public MoneyControlBSEActive100Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-100_1/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-100-1/");
    }

    @Override
    public List<MoneyControlBSEActive100Model> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");

            List<MoneyControlBSEActive100Model> moneyControlBSEActive100Models = new ArrayList<>();

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

                    MoneyControlBSEActive100Model moneyControlBSEActive100Model = new MoneyControlBSEActive100Model();
                    moneyControlBSEActive100Model.setCompanyName(companyName);
                    moneyControlBSEActive100Model.setGroup(group);
                    moneyControlBSEActive100Model.setHigh(high);
                    moneyControlBSEActive100Model.setLow(low);
                    moneyControlBSEActive100Model.setLastPrice(lastPrice);
                    moneyControlBSEActive100Model.setPercentageChange(percentageChange);
                    moneyControlBSEActive100Model.setValueInCrores(valueInCrores);

                    moneyControlBSEActive100Models.add(moneyControlBSEActive100Model);

                }catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
            System.out.println("--------------------------->>>>>>>> "+moneyControlBSEActive100Models.size());
            return moneyControlBSEActive100Models;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlBSEActive100Parser moneyControlBSEActive100Parser = new MoneyControlBSEActive100Parser();
        moneyControlBSEActive100Parser.parse();
    }
}
