package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.upcean.EAN8Bean;

import java.io.File;
import java.io.IOException;

public class EAN8BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new EAN8Bean(), data, directoryPath);
    }

}