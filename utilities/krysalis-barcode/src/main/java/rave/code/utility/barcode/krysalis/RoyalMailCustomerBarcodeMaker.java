package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.fourstate.RoyalMailCBCBean;

import java.io.File;
import java.io.IOException;

public class RoyalMailCustomerBarcodeMaker extends AbstractKrysalisBarcodeMaker{

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new RoyalMailCBCBean(), data, directoryPath);
    }

}