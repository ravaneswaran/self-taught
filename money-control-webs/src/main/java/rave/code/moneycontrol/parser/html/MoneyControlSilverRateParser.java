package rave.code.moneycontrol.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.model.MoneyControlSilverPriceModel;
import rave.code.moneycontrol.parser.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControlSilverRateParser extends HTMLSourceParser<MoneyControlSilverPriceModel> {

    public MoneyControlSilverRateParser() {
        super("https://www.moneycontrol.com/news/silver-rates-today/");
    }

    @Override
    public List<MoneyControlSilverPriceModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");
            Element tr = tableRows.get(1);
            Elements tableData = tr.select("td");
            String gram = tableData.get(0).text();
            String today = tableData.get(1).text();
            String yesterday = tableData.get(2).text();
            String priceChange = tableData.get(3).text();

            MoneyControlSilverPriceModel moneyControlSilverPriceModel = new MoneyControlSilverPriceModel();
            moneyControlSilverPriceModel.setQuantityStr(gram);
            moneyControlSilverPriceModel.setTodayPriceStr(today);
            moneyControlSilverPriceModel.setYesterdayPriceStr(yesterday);
            moneyControlSilverPriceModel.setPriceDifferenceStr(priceChange);

            List<MoneyControlSilverPriceModel> returnList = new ArrayList<>();
            returnList.add(moneyControlSilverPriceModel);

            return returnList;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControlSilverRateParser moneyControlSilverRateParser = new MoneyControlSilverRateParser();
        MoneyControlSilverPriceModel moneyControlSilverPriceModel = moneyControlSilverRateParser.parse().get(0);

        System.out.println("--------------------->>>>>>> "+moneyControlSilverPriceModel.getQuantityStr());
        System.out.println("--------------------->>>>>>> "+moneyControlSilverPriceModel.getTodayPriceStr());
        System.out.println("--------------------->>>>>>> "+moneyControlSilverPriceModel.getYesterdayPriceStr());
        System.out.println("--------------------->>>>>>> "+moneyControlSilverPriceModel.getPriceDifferenceStr());
    }
}
