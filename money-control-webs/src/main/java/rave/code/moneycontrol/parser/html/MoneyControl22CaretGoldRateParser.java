package rave.code.moneycontrol.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.model.MoneyControl22CaretGoldPriceModel;
import rave.code.moneycontrol.parser.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControl22CaretGoldRateParser extends HTMLSourceParser<MoneyControl22CaretGoldPriceModel> {

    public MoneyControl22CaretGoldRateParser() {
        super("https://www.moneycontrol.com/news/gold-rates-today/");
    }

    @Override
    public List<MoneyControl22CaretGoldPriceModel> parse() {
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

            MoneyControl22CaretGoldPriceModel moneyControl22CaretGoldPriceModel = new MoneyControl22CaretGoldPriceModel();
            moneyControl22CaretGoldPriceModel.setQuantityStr(gram);
            moneyControl22CaretGoldPriceModel.setTodayPriceStr(today);
            moneyControl22CaretGoldPriceModel.setYesterdayPriceStr(yesterday);
            moneyControl22CaretGoldPriceModel.setPriceDifferenceStr(priceChange);

            List<MoneyControl22CaretGoldPriceModel> returnList = new ArrayList<>();
            returnList.add(moneyControl22CaretGoldPriceModel);

            return returnList;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControl22CaretGoldRateParser moneyControl22CaretGoldRateParser = new MoneyControl22CaretGoldRateParser();
        moneyControl22CaretGoldRateParser.parse();
    }
}
