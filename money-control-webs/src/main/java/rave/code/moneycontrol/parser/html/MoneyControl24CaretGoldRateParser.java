package rave.code.moneycontrol.parser.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.moneycontrol.model.MoneyControl22CaretGoldPriceModel;
import rave.code.moneycontrol.model.MoneyControl24CaretGoldPriceModel;
import rave.code.moneycontrol.parser.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MoneyControl24CaretGoldRateParser extends HTMLSourceParser<MoneyControl24CaretGoldPriceModel> {

    public MoneyControl24CaretGoldRateParser() {
        super("https://www.moneycontrol.com/news/gold-rates-today/");
    }

    @Override
    public List<MoneyControl24CaretGoldPriceModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(2);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");
            Element tr = tableRows.get(1);
            Elements tableData = tr.select("td");
            String gram = tableData.get(0).text();
            String today = tableData.get(1).text();
            String yesterday = tableData.get(2).text();
            String priceChange = tableData.get(3).text();

            MoneyControl24CaretGoldPriceModel moneyControl24CaretGoldPriceModel = new MoneyControl24CaretGoldPriceModel();
            moneyControl24CaretGoldPriceModel.setQuantityStr(gram);
            moneyControl24CaretGoldPriceModel.setTodayPriceStr(today);
            moneyControl24CaretGoldPriceModel.setYesterdayPriceStr(yesterday);
            moneyControl24CaretGoldPriceModel.setPriceDifferenceStr(priceChange);

            List<MoneyControl24CaretGoldPriceModel> returnList = new ArrayList<>();
            returnList.add(moneyControl24CaretGoldPriceModel);

            return returnList;
        } catch (SocketTimeoutException e) {
            return this.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        MoneyControl24CaretGoldRateParser moneyControl24CaretGoldRateParser = new MoneyControl24CaretGoldRateParser();
        moneyControl24CaretGoldRateParser.parse();
    }
}
