package rave.code.moneycontrol.bse.data.parser.html;

import java.util.logging.Logger;

public class MoneyControlBSEActive500Parser extends MoneyControlBSEActiveParser{

    private static final Logger LOGGER = Logger.getLogger(MoneyControlBSEActive500Parser.class.getName());

    public MoneyControlBSEActive500Parser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse-gainer/bse-500_12/
        super("https://www.moneycontrol.com/stocks/marketstats/bse-mostactive-stocks/bse-500-12/");
    }

    public static void main(String[] args) {
        MoneyControlBSEActive500Parser moneyControlBSEActive500Parser = new MoneyControlBSEActive500Parser();
        moneyControlBSEActive500Parser.parse();
    }
}
