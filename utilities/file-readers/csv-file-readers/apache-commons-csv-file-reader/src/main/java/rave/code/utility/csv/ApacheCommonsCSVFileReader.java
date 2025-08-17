package rave.code.utility.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import rave.code.utility.download.FileDownload;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApacheCommonsCSVFileReader {

    //https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV

    public static void main(String[] args) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String url = String.format("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_%s_F_0000.CSV", simpleDateFormat.format(new Date()));
        System.out.println("---------------->>>>> " + url);
        ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
        List<CSVRecord> csvRecords = apacheCommonsCSVReader.read("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV");
        for (CSVRecord csvRecord : csvRecords) {
            System.out.println(csvRecord.toString());
        }
    }

    public List<CSVRecord> read(String url) throws IOException {
        return this.read(new URL(url));
    }

    public List<CSVRecord> read(URL url) throws IOException {
        InputStream inputStream = new FileDownload().downloadFile(url);
        return this.read(inputStream);
    }

    public List<CSVRecord> read(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        return this.read(inputStream);
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
