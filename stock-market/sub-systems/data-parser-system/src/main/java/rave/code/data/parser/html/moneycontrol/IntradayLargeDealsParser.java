package rave.code.data.parser.html.moneycontrol;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import rave.code.data.parser.html.HTMLSourceParser;
import rave.code.website.data.model.moneycontrol.IntradayLargeDealModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntradayLargeDealsParser extends HTMLSourceParser<IntradayLargeDealModel> {

    private static final Logger LOGGER = Logger.getLogger(IntradayLargeDealsParser.class.getName());

    public IntradayLargeDealsParser() {
        //https://www.moneycontrol.com/markets/stock-deals/large-deals/
        super("https://www.moneycontrol.com/markets/stock-deals/large-deals/");
    }

    @Override
    public List<IntradayLargeDealModel> parse() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get(this.getSourceUrl());

        List<WebElement> svgs = driver.findElements(By.tagName("path"));
        System.out.println("----------------------------"+svgs.size());
        for (WebElement svg : svgs) {
            String text = svg.getText();
            System.out.println(text);
            System.out.println("----------------------------");
        }





        /*try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
                System.out.println(document);
                Elements elements = document.select("div");
                //System.out.println(" -------------->>>>> " + elements.size());

                for (Element element: elements) {
                    System.out.println("--------------->>>>>> "+element.className());
                }

                //Element mainElement = document.select("main").get(0);
                //Element element = mainElement.select("div").get(88).select("div").get(0);
                //System.out.println(element.childNodeSize());
                //Elements elements = document.select("div.web_deal_card__WsXNK");
                *//*System.out.println(divElement);*//*
                *//*int index = 0;
                for (Element element : elements) {
                    System.out.println(index++ + " -------------->>>>> " + element.childNodeSize());
                }*//*
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
        }*/

        return null;
    }

    public static void main(String[] args) {
        IntradayLargeDealsParser intradayLargeDealsParser = new IntradayLargeDealsParser();
        intradayLargeDealsParser.parse();
    }
}