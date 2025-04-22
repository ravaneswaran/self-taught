package rave.code.utility.parser.html.moneycontrol.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.utility.parser.html.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class MoneyControlSilverRateParser extends HTMLSourceParser {

    public MoneyControlSilverRateParser() {
        super("https://www.moneycontrol.com/news/silver-rates-today/");
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
        MoneyControlSilverRateParser moneyControlSilverRateParser = new MoneyControlSilverRateParser();
        moneyControlSilverRateParser.parse();
    }
}
