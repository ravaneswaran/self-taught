package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.codabar.CodabarBean;

import java.io.File;
import java.io.IOException;

public class CodabarBarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new CodabarBean(), data, directoryPath);
    }

}
