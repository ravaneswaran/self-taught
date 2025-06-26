package rave.code.data.parser.html.moneycontrol;

import java.util.logging.Logger;

public class BSEActive200Parser extends BSEActiveParser {

    private static final Logger LOGGER = Logger.getLogger(BSEActive200Parser.class.getName());

    public BSEActive200Parser() {
        //super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-200-2/");
        super("https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-200_2/");
    }

    public static void main(String[] args) {
        BSEActive200Parser bseActive200Parser = new BSEActive200Parser();
        bseActive200Parser.parse();
    }
}
