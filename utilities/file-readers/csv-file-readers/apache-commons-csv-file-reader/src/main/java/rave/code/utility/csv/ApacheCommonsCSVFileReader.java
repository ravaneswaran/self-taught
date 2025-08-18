package rave.code.utility.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import rave.code.utility.download.FileDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApacheCommonsCSVFileReader implements FileReader{

    //https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV

    public static void main(String[] args) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String url = String.format("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_%s_F_0000.CSV", simpleDateFormat.format(new Date()));
        System.out.println("---------------->>>>> " + url);
        FileDownloader fileDownloader = new FileDownloader();
        InputStream inputStream = fileDownloader.downloadFile("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV");
        ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
        List<CSVRecord> csvRecords = apacheCommonsCSVReader.read(inputStream);
        for (CSVRecord csvRecord : csvRecords) {
            System.out.println(csvRecord.toString());
        }
    }

    public List<CSVRecord> read(InputStream inputStream) throws IOException {
        List<CSVRecord> csvRecordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.parse(bufferedReader);
            for (CSVRecord csvRecord : csvRecords) {
                csvRecordList.add(csvRecord);
            }
        }
        return csvRecordList;
    }
}
