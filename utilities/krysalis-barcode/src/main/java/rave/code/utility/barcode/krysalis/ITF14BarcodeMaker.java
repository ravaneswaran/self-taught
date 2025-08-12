package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.int2of5.ITF14Bean;

import java.io.File;
import java.io.IOException;

public class ITF14BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        ITF14Bean itf14Bean = new ITF14Bean();
        return this.getFile(itf14Bean, data, directoryPath);
    }

}