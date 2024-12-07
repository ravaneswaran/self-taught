package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.code39.Code39Bean;

import java.io.File;
import java.io.IOException;

public class Code39BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        Code39Bean code39Bean = new Code39Bean();
        code39Bean.setWideFactor(3);
        return this.getFile(code39Bean, data, directoryPath);
    }

}