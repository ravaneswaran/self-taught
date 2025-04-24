package rave.code.moneycontrol.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.model.MoneyControlGainerModel;
import rave.code.moneycontrol.parser.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSEActive500Parser extends HTMLSourceParser<MoneyControlGainerModel> {

    public MoneyControlBSEActive500Parser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-500_12/");
    }

    @Override
    public List<MoneyControlGainerModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");

            List<MoneyControlGainerModel> moneyControlGainerModels = new ArrayList<MoneyControlGainerModel>();

            for (Element tr : tableRows) {
                try {
                    Elements tableData = tr.select("td");
                    Element companyNameElement = tableData.get(0).select("a").get(0);
                    String companyName = companyNameElement.text();
                    String high = tableData.get(1).text();
                    String low = tableData.get(2).text();
                    String lastPrice = tableData.get(3).text();
                    String previousClose = tableData.get(4).text();
                    String change = tableData.get(5).text();
                    String percentageGain = tableData.get(6).text();

                    MoneyControlGainerModel moneyControlGainerModel = new MoneyControlGainerModel();
                    moneyControlGainerModel.setCompanyName(companyName);
                    moneyControlGainerModel.setHigh(high);
                    moneyControlGainerModel.setLow(low);
                    moneyControlGainerModel.setLastPrice(lastPrice);
                    moneyControlGainerModel.setPreviousClose(previousClose);
                    moneyControlGainerModel.setChange(change);
                    moneyControlGainerModel.setPercentageGain(percentageGain);

                    moneyControlGainerModels.add(moneyControlGainerModel);

                }catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
            return moneyControlGainerModels;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlBSEActive500Parser moneyControlBSEActive500Parser = new MoneyControlBSEActive500Parser();
        moneyControlBSEActive500Parser.parse();
    }
}
