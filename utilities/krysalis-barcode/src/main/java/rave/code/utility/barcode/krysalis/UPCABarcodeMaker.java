package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.upcean.UPCABean;

import java.io.File;
import java.io.IOException;

public class UPCABarcodeMaker extends AbstractKrysalisBarcodeMaker{

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new UPCABean(), data, directoryPath);
    }

}