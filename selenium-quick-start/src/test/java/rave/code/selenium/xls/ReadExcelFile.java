package rave.code.selenium.xls;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadExcelFile extends ExcelFile{

    public int getNumberOfSheets(){
        return this.xlsxWorkBook.getNumberOfSheets();
    }

    public XSSFSheet getSheetAt(int index){
        return this.xlsxWorkBook.getSheetAt(index);
    }

    public XSSFSheet getSheet(String sheetName){
        return this.xlsxWorkBook.getSheet(sheetName);
    }

    public int getRowCount(int sheetIndex){
        return this.xlsxWorkBook.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
    }

    public XSSFRow getRowAt(int sheetNumber, int row){
        return this.xlsxWorkBook.getSheetAt(sheetNumber).getRow(row);
    }

    public XSSFCell getCell(int sheetNumber, int row, int column){
        return this.getRowAt(sheetNumber, row).getCell(column);
    }

    public String getCellStringValue(int sheetNumber, int row, int column) {
        return this.getRowAt(sheetNumber, row).getCell(column).getStringCellValue();
    }

    public String getCellFormula(int sheetNumber, int row, int column){
        return this.getCell(sheetNumber, row, column).getCellFormula();
    }
}
