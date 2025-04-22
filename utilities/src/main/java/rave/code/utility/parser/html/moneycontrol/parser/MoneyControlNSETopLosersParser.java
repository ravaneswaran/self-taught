package rave.code.utility.parser.html.moneycontrol.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.utility.parser.html.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class MoneyControlNSETopLosersParser extends HTMLSourceParser {

    public MoneyControlNSETopLosersParser() {
        super("https://www.moneycontrol.com/stocks/marketstats/nseloser/index.php");
    }

    public static void main(String[] args) {
        MoneyControlNSETopLosersParser moneyControlNSETopLosersParser = new MoneyControlNSETopLosersParser();
        moneyControlNSETopLosersParser.parse();
    }

    @Override
    public void parse() {
        try {
            Document doc = Jsoup.connect("https://www.moneycontrol.com/stocks/marketstats/nseloser/index.php").get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");

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
                    String percentageLoss = tableData.get(6).text();

                }catch (IndexOutOfBoundsException e) {
                    //do nothing
                }
            }
        } catch (SocketTimeoutException e) {
            this.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
