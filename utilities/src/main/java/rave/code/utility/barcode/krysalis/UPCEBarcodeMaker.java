package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.upcean.UPCEBean;

import java.io.File;
import java.io.IOException;

public class UPCEBarcodeMaker extends AbstractKrysalisBarcodeMaker{

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new UPCEBean(), data, directoryPath);
    }

}