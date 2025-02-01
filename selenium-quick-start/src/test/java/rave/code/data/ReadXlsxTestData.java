package rave.code.data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXlsxTestData {

    private File testDataFile;
    private FileInputStream testDataStream;
    private XSSFWorkbook testDataWorkBook;
    private XSSFSheet testDataSheet;

    public void  openFile(String dataFilePath) throws IOException {
        this.testDataFile = new File(dataFilePath);
        this.testDataStream = new FileInputStream(testDataFile);
        this.testDataWorkBook = new XSSFWorkbook(testDataStream);
    }

    public int getNumberOfSheets(){
        return this.testDataWorkBook.getNumberOfSheets();
    }

    public XSSFSheet getSheetAt(int index){
        return this.testDataWorkBook.getSheetAt(index);
    }

    public String getData(int sheetNumber, int row, int column) {
        this.testDataSheet = testDataWorkBook.getSheetAt(sheetNumber);
        String data = this.testDataSheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex) {
        int row = testDataWorkBook.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }

    public void closeFile() throws IOException {
        this.testDataWorkBook.close();
        this.testDataStream.close();
    }
}
