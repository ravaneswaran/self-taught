package rave.code.utility.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileReader {

    public static final Logger LOGGER = Logger.getLogger(ZipFileReader.class.getName());

    public InputStream read(InputStream inputStream, String zipEntryName) throws IOException {
        if (null != inputStream && null != zipEntryName && !"".equals(zipEntryName)) {
            try (ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
                ZipEntry zipEntry;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    if (null != zipEntry && zipEntryName.toLowerCase().equals(zipEntry.getName().toLowerCase())) {
                        LOGGER.info(String.format("the entry '%s' exist in the zip file", zipEntryName));
                        return this.readZipEntry(inputStream, zipEntry);
                    }
                }
            }
        }
        LOGGER.info(String.format("the entry '%s' does not exist in the zip file", zipEntryName));
        return null;
    }

    private InputStream readZipEntry(InputStream inputStream, ZipEntry zipEntry) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}
