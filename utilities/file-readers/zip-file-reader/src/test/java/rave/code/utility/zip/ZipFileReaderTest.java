package rave.code.utility.zip;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipFileReaderTest {

    @Test
    public void read_when_the_entry_exists() throws IOException {
        ZipFileReader zipFileReader = new ZipFileReader();
        InputStream inputStream = this.getClass().getResourceAsStream("/test.zip");
        InputStream inpStream = zipFileReader.read(inputStream, "Pd140825.csv");
        assertTrue(null != inpStream);
    }

    @Test
    public void read_when_the_entry_does_not_exists() throws IOException {
        ZipFileReader zipFileReader = new ZipFileReader();
        InputStream inputStream = this.getClass().getResourceAsStream("/test.zip");
        InputStream inpStream = zipFileReader.read(inputStream, "does-not-exist.csv");
        assertTrue(null == inpStream);
    }

    @Test
    public void read_inner_directory() throws IOException {
        ZipFileReader zipFileReader = new ZipFileReader();
        InputStream inputStream = this.getClass().getResourceAsStream("/test.zip");
        InputStream inpStream = zipFileReader.read(inputStream, "testing/Readme.txt");
        assertTrue(null != inpStream);
    }
}
