package rave.code.moneycontrol.bse.data.parser.html;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import rave.code.moneycontrol.bse.data.parser.HTMLSourceParser;
import rave.code.moneycontrol.website.data.model.MoneyControlIntradayLargeDealModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoneyControlBSEIntradayLargeDealsParser extends HTMLSourceParser<MoneyControlIntradayLargeDealModel> {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEIntradayLargeDealsParser.class.getName());

    public MoneyControlBSEIntradayLargeDealsParser() {
        //https://www.moneycontrol.com/markets/stock-deals/large-deals/
        super("https://www.moneycontrol.com/markets/stock-deals/large-deals/");
    }

    @Override
    public List<MoneyControlIntradayLargeDealModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
                //Element mainElement = document.select("main").get(0);
                //Element element = mainElement.select("div").get(88).select("div").get(0);
                //System.out.println(element.childNodeSize());
                Elements elements = document.select("div.web_deal_card__WsXNK");
                /*System.out.println(divElement);*/
                int index = 0;
                for (Element element : elements) {
                    System.out.println(index++ + " -------------->>>>> "+ element.childNodeSize());
                }
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
                this.parse();
            }
        } catch (SocketTimeoutException socketTimeoutException) {
            LOGGER.log(Level.SEVERE, socketTimeoutException.getMessage(), socketTimeoutException);
            LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
            return this.parse();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            return new ArrayList<>();
        }

        return null;
    }


    public static void main(String[] args) {
        MoneyControlBSEIntradayLargeDealsParser moneyControlBSEIntradayLargeDealsParser = new MoneyControlBSEIntradayLargeDealsParser();
        moneyControlBSEIntradayLargeDealsParser.parse();
    }
}