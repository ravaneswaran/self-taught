package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.bse.data.parser.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlGenericModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControlBSESmallCapGainersParser extends HTMLSourceParser<MoneyControlGenericModel> {

    public MoneyControlBSESmallCapGainersParser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-smallcap_26/");
    }

    @Override
    public List<MoneyControlGenericModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");

            List<MoneyControlGenericModel> moneyControlNSETopGainerModelList = new ArrayList<MoneyControlGenericModel>();

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

                    MoneyControlGenericModel moneyControlGainerModel = new MoneyControlGenericModel();
                    moneyControlGainerModel.setCompanyName(companyName);
                    moneyControlGainerModel.setHigh(high);
                    moneyControlGainerModel.setLow(low);
                    moneyControlGainerModel.setLastPrice(lastPrice);
                    moneyControlGainerModel.setPreviousClose(previousClose);
                    moneyControlGainerModel.setChange(change);
                    moneyControlGainerModel.setPercentageGain(percentageGain);

                    moneyControlNSETopGainerModelList.add(moneyControlGainerModel);

                }catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
            return moneyControlNSETopGainerModelList;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlBSESmallCapGainersParser moneyControlBSESmallCapGainersParser = new MoneyControlBSESmallCapGainersParser();
        moneyControlBSESmallCapGainersParser.parse();

    }
}
