package rave.code.data.parser.html.moneycontrol;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.data.parser.html.HTMLSourceParser;
import rave.code.website.data.model.moneycontrol.DividendModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSETopDividendParser extends HTMLSourceParser<DividendModel> {

    private static final Logger LOGGER = Logger.getLogger(BSETopDividendParser.class.getName());

    public BSETopDividendParser() {
        super("https://www.moneycontrol.com/stocks/marketstats/bsetopdiv/");
    }

    public static void main(String[] args) {
        BSETopDividendParser bseTopDividendParser = new BSETopDividendParser();
        bseTopDividendParser.parse();
    }

    @Override
    public List<DividendModel> parse() {
        try {
            Document doc = Jsoup.connect(this.getSourceUrl()).get();
            Element table = doc.select("table").get(1);
            Element tableBody = table.select("tbody").get(0);
            Elements tableRows = tableBody.select("tr");
            List<DividendModel> dividendModels = new ArrayList<>();

            for (Element tr : tableRows) {
                Elements tableData = tr.select("td");
                if (tableData.size() >= 5) {

                    Element companyNameElement = tableData.get(0).select("a").get(0);
                    String companyName = companyNameElement.text();
                    String lastPrice = tableData.get(1).text();
                    String latestDividendPercentage = tableData.get(2).text();
                    String dividendYieldPercentAt52High = tableData.get(3).text();
                    String dividendYieldPercentAt52Low = tableData.get(4).text();
                    String dividendYieldPercentAtCurrent = tableData.get(5).text();

                    DividendModel dividendModel = new DividendModel();
                    dividendModel.setCompanyName(companyName);
                    dividendModel.setLastPrice(lastPrice);
                    dividendModel.setLatestDividendPercentage(latestDividendPercentage);
                    dividendModel.setDividendYieldPercentAtCurrent(dividendYieldPercentAtCurrent);
                    dividendModel.setDividendYieldPercentAt52High(dividendYieldPercentAt52High);
                    dividendModel.setDividendYieldPercentAt52Low(dividendYieldPercentAt52Low);
                    dividendModel.setDividendYieldPercentAtCurrent(dividendYieldPercentAtCurrent);

                    dividendModels.add(dividendModel);
                }
            }
            return dividendModels;
        } catch (SocketTimeoutException ste) {
            LOGGER.log(Level.SEVERE, ste.getMessage(), ste);
            return this.parse();
        } catch (IOException ste) {
            LOGGER.log(Level.SEVERE, ste.getMessage(), ste);
            return new ArrayList<>();
        }
    }
}
