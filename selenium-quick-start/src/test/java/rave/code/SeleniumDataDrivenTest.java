package rave.code;

import org.junit.jupiter.api.Test;
import rave.code.data.ReadXlsxTestData;

import java.io.IOException;

public class SeleniumDataDrivenTest {

    @Test
    public void seleniumDataDrivenRun() throws IOException {

        String testDataFilePath = this.getClass().getResource("/test-data/test-data-file.xlsx").getFile();
        ReadXlsxTestData testData = new ReadXlsxTestData();
        testData.openFile(testDataFilePath);
        int numberOfSheets = testData.getNumberOfSheets();

        for(int sheetNumber = 0; sheetNumber < numberOfSheets; sheetNumber++){
            int numberOfRows = testData.getSheetAt(sheetNumber).getPhysicalNumberOfRows();
            for(int rowNumber = 0; rowNumber < numberOfRows; rowNumber++){
                for(int columnNumber = 0; columnNumber < 1; columnNumber++){
                    String username = testData.getData(sheetNumber, rowNumber, columnNumber);
                    String password = testData.getData(sheetNumber, rowNumber, columnNumber+1);
                    System.out.println(username +" : "+password);
                }
            }
        }

        testData.closeFile();
    }

}
