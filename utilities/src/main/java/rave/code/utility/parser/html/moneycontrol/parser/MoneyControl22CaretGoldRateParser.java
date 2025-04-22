package rave.code.utility.parser.html.moneycontrol.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.utility.parser.html.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class MoneyControl22CaretGoldRateParser extends HTMLSourceParser {

    public MoneyControl22CaretGoldRateParser() {
        super("https://www.moneycontrol.com/news/gold-rates-today/");
    }

    @Override
    public void parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");
            Element tr = tableRows.get(1);
            Elements tableData = tr.select("td");
            for (Element td :tableData) {
                System.out.println(td.text());
            }
        } catch (SocketTimeoutException e) {
            this.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MoneyControl22CaretGoldRateParser moneyControl22CaretGoldRateParser = new MoneyControl22CaretGoldRateParser();
        moneyControl22CaretGoldRateParser.parse();
    }
}
