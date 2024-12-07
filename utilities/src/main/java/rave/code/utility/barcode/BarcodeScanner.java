package rave.code.utility.barcode;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import java.io.IOException;

public interface BarcodeScanner {

    public String scan(String fileName, String directoryPath)
            throws IOException, NotFoundException, ChecksumException,
            FormatException;
}
