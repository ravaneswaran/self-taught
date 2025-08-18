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
        if (zipEntry.isDirectory()) {
            return this.readZipEntry(inputStream, zipEntry);
        } else {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                baos.write(buffer, 0, length);
            }
            return new ByteArrayInputStream(baos.toByteArray());
        }
    }

    public static void main(String[] args) throws IOException {
        String zipFilePath = "/PR140825.zip"; // Path to your ZIP file
        InputStream inputStream = ZipFileReader.class.getResourceAsStream(zipFilePath);
        ZipFileReader zipFileReader = new ZipFileReader();
        InputStream returnStream = zipFileReader.read(inputStream, "Pd140825.csv");
        System.out.println("==================>>>>>>> " + returnStream);

        /*try (ZipInputStream zis = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                if (!entry.isDirectory()) {
                    // Read file contents
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }
                    // Print the file content as text (if text file)
                    String fileContent = baos.toString("UTF-8");
                    //System.out.println("Content:\n" + fileContent);
                    System.out.println(String.format("File: %s - %s", entry.getName(), fileContent.getBytes().length));
                }
                zis.closeEntry();
            }
        }*/
    }
}
