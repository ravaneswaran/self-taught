package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.code128.Code128Bean;

import java.io.File;
import java.io.IOException;

public class Code128BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new Code128Bean(), data, directoryPath);
    }

}