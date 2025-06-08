package rave.code.groww.data.parser.html;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import rave.code.HTMLSourceParser;
import rave.code.groww.website.data.model.GrowwHolidayModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrowwHolidayParser extends HTMLSourceParser<GrowwHolidayModel> {

    private static final Logger LOGGER = Logger.getLogger(GrowwHolidayParser.class.getName());

    public GrowwHolidayParser() {
        //https://groww.in/p/nse-holidays
        super("https://groww.in/p/nse-holidays");
    }

    @Override
    public List<GrowwHolidayModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
                if (null != document) {
                    Element table = document.select("table").get(0);
                    System.out.println(table);
                }
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://groww.in) for the data.....");
                this.parse();
            }
        } catch (SocketTimeoutException socketTimeoutException) {
            LOGGER.log(Level.SEVERE, socketTimeoutException.getMessage(), socketTimeoutException);
            LOGGER.log(Level.INFO, "trying again to connect to the site(https://groww.in) for the data.....");
            return this.parse();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            return new ArrayList<>();
        }

        return null;
    }

    public static void main(String[] args) {
        GrowwHolidayParser growwHolidayParser = new GrowwHolidayParser();
        growwHolidayParser.parse();
    }
}
