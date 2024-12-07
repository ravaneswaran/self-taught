package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;

import java.io.File;
import java.io.IOException;

public class EAN13BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new EAN13Bean(), data, directoryPath);
    }

}