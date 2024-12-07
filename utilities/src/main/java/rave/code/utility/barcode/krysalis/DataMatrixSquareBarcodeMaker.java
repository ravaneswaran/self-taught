package rave.code.utility.barcode.krysalis;

import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.impl.datamatrix.SymbolShapeHint;

import java.io.File;
import java.io.IOException;

public class DataMatrixSquareBarcodeMaker extends AbstractKrysalisBarcodeMaker {

    public File create(String data, String directoryPath)
            throws IOException {
        DataMatrixBean dataMatrixBean = new DataMatrixBean();
        dataMatrixBean.setShape(SymbolShapeHint.FORCE_SQUARE);
        return this.getFile(dataMatrixBean, data, directoryPath);
    }

}