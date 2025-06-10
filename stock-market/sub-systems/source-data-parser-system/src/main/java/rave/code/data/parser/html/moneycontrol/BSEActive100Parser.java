package rave.code.data.parser.html.moneycontrol;

import java.util.logging.Logger;

public class BSEActive100Parser extends BSEActiveParser {

    private static final Logger LOGGER = Logger.getLogger(BSEActive100Parser.class.getName());

    public BSEActive100Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-100_1/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-100-1/");
    }

    public static void main(String[] args) {
        BSEActive100Parser moneyControlBSEActive100Parser = new BSEActive100Parser();
        moneyControlBSEActive100Parser.parse();
    }
}