package rave.code.moneycontrol.bse.data.parser.html;

import java.util.logging.Logger;

public class MoneyControlBSEActive100Parser extends MoneyControlBSEActiveParser {

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive100Parser.class.getName());

    public MoneyControlBSEActive100Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-100_1/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-100-1/");
    }

    public static void main(String[] args) {
        MoneyControlBSEActive100Parser moneyControlBSEActive100Parser = new MoneyControlBSEActive100Parser();
        moneyControlBSEActive100Parser.parse();
    }
}