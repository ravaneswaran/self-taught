package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;

import java.io.File;
import java.io.IOException;

public class Interleaved2Of5BarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath) throws IOException {
        return this.getFile(new Interleaved2Of5Bean(), data, directoryPath);
    }

}