package rave.code.groww.data.parser.html;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
        List<GrowwHolidayModel> growwHolidayModels = new ArrayList<>();
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
                if (null != document) {
                    Element table = document.select("table").get(0);
                    Elements tableRows = table.select("tbody").get(0).select("tr");

                    for (int index = 1; index < tableRows.size(); index++) {
                        Element tableRow = tableRows.get(index);
                        Elements tableData = tableRow.select("td");
                        GrowwHolidayModel growwHolidayModel = new GrowwHolidayModel();
                        growwHolidayModel.setDate(tableData.get(0).text());
                        growwHolidayModel.setDay(tableData.get(1).text());
                        growwHolidayModel.setDescription(tableData.get(2).text());
                        growwHolidayModels.add(growwHolidayModel);
                    }
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

        return growwHolidayModels;
    }

    public static void main(String[] args) {
        GrowwHolidayParser growwHolidayParser = new GrowwHolidayParser();
        growwHolidayParser.parse();
    }
}
