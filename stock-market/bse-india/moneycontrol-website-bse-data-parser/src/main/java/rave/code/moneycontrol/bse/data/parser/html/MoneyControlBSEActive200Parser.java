package rave.code.moneycontrol.bse.data.parser.html;

import java.util.logging.Logger;

public class MoneyControlBSEActive200Parser extends MoneyControlBSEActiveParser {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive200Parser.class.getName());

    public MoneyControlBSEActive200Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-200_2/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-200-2/");
    }

    public static void main(String[] args) {
        MoneyControlBSEActive200Parser moneyControlBSEActive200Parser = new MoneyControlBSEActive200Parser();
        moneyControlBSEActive200Parser.parse();
    }
}
