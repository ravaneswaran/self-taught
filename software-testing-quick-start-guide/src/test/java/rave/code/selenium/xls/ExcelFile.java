package rave.code.selenium.xls;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFile {

    protected File xlsxFile;
    protected FileInputStream xlsxInputFileStream;
    protected XSSFWorkbook xlsxWorkBook;

    public void  openFile(String dataFilePath) throws IOException {
        this.xlsxFile = new File(dataFilePath);
        this.xlsxInputFileStream = new FileInputStream(xlsxFile);
        this.xlsxWorkBook = new XSSFWorkbook(xlsxInputFileStream);
    }

    public void closeFile() throws IOException {
        this.xlsxWorkBook.close();
        this.xlsxInputFileStream.close();
    }
}
