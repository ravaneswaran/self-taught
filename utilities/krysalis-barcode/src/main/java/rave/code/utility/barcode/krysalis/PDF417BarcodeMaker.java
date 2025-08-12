package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;

import java.io.File;
import java.io.IOException;

public class PDF417BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new PDF417Bean(), data, directoryPath);
    }

}