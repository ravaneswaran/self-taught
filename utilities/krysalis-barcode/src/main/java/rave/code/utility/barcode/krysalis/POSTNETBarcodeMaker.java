package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.postnet.POSTNETBean;

import java.io.File;
import java.io.IOException;

public class POSTNETBarcodeMaker extends AbstractKrysalisBarcodeMaker{

    public File create(String data, String directoryPath)
            throws IOException {
        return this.getFile(new POSTNETBean(), data, directoryPath);
    }

}