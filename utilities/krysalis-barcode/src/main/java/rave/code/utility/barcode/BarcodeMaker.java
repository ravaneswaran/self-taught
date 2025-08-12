package rave.code.utility.barcode;

import java.io.File;
import java.io.IOException;

public interface BarcodeMaker {

    /**
     * @param data
     * @param directoryPath
     * @return
     * @throws IOException
     */
    public File create(String data, String directoryPath) throws IOException;

}
