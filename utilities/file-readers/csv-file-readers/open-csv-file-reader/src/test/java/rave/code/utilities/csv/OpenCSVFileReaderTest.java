package rave.code.utilities.csv;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.zip.ZipFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class OpenCSVFileReaderTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void download_NSE_BhavCopy_File() throws IOException, CsvValidationException {
        int date = 190825;
        String url = String.format("https://nsearchives.nseindia.com/archives/equities/bhavcopy/pr/PR%s.zip", date);
        String zipFileEntryName = String.format("Pd%s.csv", date);

        FileDownloader fileDownload = new FileDownloader();
        InputStream inputStream = null;
        try {
            inputStream = fileDownload.downloadFile(url);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        InputStream csvInputStream = new ZipFileReader().read(inputStream, zipFileEntryName);
        List<String> lines = new OpenCSVFileReader().read(csvInputStream);

        inputStream.close();
        csvInputStream.close();

        assertTrue(lines.size() > 0);
    }

    @Test
    public void download_BSE_BhavCopy_File() throws IOException, CsvValidationException {
        int date = 20250819;
        String url = String.format("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_%s_F_0000.CSV", date);

        FileDownloader fileDownload = new FileDownloader();
        InputStream inputStream = null;
        try {
            inputStream = fileDownload.downloadFile(url);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        List<String> lines = new OpenCSVFileReader().read(inputStream);
        inputStream.close();

        assertTrue(lines.size() > 0);
    }
}
