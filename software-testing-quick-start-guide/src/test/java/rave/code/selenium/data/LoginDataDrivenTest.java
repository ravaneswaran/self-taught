package rave.code.selenium.data;

import org.junit.jupiter.api.Test;
import rave.code.selenium.xls.ReadExcelFile;

import java.io.IOException;

public class LoginDataDrivenTest {

    @Test
    public void loginDataDrivenRun() throws IOException {

        String testDataFilePath = this.getClass().getResource("/test-data/test-data-file.xlsx").getFile();
        ReadExcelFile testData = new ReadExcelFile();
        testData.openFile(testDataFilePath);
        int numberOfSheets = testData.getNumberOfSheets();

        for(int sheetNumber = 0; sheetNumber < numberOfSheets; sheetNumber++){
            int numberOfRows = testData.getSheetAt(sheetNumber).getPhysicalNumberOfRows();
            for(int rowNumber = 1; rowNumber < numberOfRows; rowNumber++){
                for(int columnNumber = 0; columnNumber < 1; columnNumber++){
                    String username = testData.getCellStringValue(sheetNumber, rowNumber, columnNumber);
                    String password = testData.getCellStringValue(sheetNumber, rowNumber, columnNumber+1);
                    System.out.println(username +" : "+password);
                }
            }
        }

        testData.closeFile();
    }

}
