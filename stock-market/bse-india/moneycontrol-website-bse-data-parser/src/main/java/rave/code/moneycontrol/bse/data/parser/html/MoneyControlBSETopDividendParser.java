package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.bse.data.parser.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlDividendModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSETopDividendParser extends HTMLSourceParser<MoneyControlDividendModel> {

    public MoneyControlBSETopDividendParser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bsetopdiv/");
    }

    @Override
    public List<MoneyControlDividendModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");
            List<MoneyControlDividendModel> moneyControlDividendModels = new ArrayList<>();
            for (Element tr : tableRows) {
                try {
                    Elements tableData = tr.select("td");
                    Element companyNameElement = tableData.get(0).select("a").get(0);
                    String companyName = companyNameElement.text();
                    String lastPrice = tableData.get(1).text();
                    String latestDividendPercentage = tableData.get(2).text();
                    String dividendYieldPercentAt52High = tableData.get(3).text();
                    String dividendYieldPercentAt52Low = tableData.get(4).text();
                    String dividendYieldPercentAtCurrent = tableData.get(5).text();

                    MoneyControlDividendModel moneyControlDividendModel = new MoneyControlDividendModel();
                    moneyControlDividendModel.setCompanyName(companyName);
                    moneyControlDividendModel.setLastPrice(lastPrice);
                    moneyControlDividendModel.setLatestDividendPercentage(latestDividendPercentage);
                    moneyControlDividendModel.setDividendYieldPercentAtCurrent(dividendYieldPercentAtCurrent);
                    moneyControlDividendModel.setDividendYieldPercentAt52High(dividendYieldPercentAt52High);
                    moneyControlDividendModel.setDividendYieldPercentAt52Low(dividendYieldPercentAt52Low);
                    moneyControlDividendModel.setDividendYieldPercentAtCurrent(dividendYieldPercentAtCurrent);

                    moneyControlDividendModels.add(moneyControlDividendModel);
                }catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
            return moneyControlDividendModels;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlBSETopDividendParser moneyControlBSETopDividendParser = new MoneyControlBSETopDividendParser();
        moneyControlBSETopDividendParser.parse();
    }
}
