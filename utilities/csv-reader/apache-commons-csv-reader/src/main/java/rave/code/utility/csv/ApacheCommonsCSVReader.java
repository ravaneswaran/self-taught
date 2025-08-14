package rave.code.utility.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApacheCommonsCSVReader {

    //https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV

    public static void main(String[] args) throws IOException {
        ApacheCommonsCSVReader apacheCommonsCSVReader = new ApacheCommonsCSVReader();
        Iterable<CSVRecord> csvRecords = apacheCommonsCSVReader.getCSVRecords("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV");
        for (CSVRecord csvRecord : csvRecords) {
            int recordSize = csvRecord.size();
            for (int index = 0; index < recordSize; index++) {
                System.out.print(String.format("%s ", csvRecord.get(index)));
            }
            System.out.println();
        }
    }

    public Iterable<CSVRecord> getCSVRecords(String urlString)  throws IOException {
        return this.getCSVRecords(new URL(urlString));
    }

    public Iterable<CSVRecord> getCSVRecords(URL url)  throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        conn.setRequestProperty("Referer", "https://www.bseindia.com/");
        conn.setInstanceFollowRedirects(true);
        Iterable<CSVRecord> records = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            records = CSVFormat.DEFAULT.parse(bufferedReader);
        }
        return records;
    }
}
