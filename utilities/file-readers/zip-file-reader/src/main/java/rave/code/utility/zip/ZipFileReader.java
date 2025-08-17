package rave.code.utility.zip;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileReader {

    public static void main(String[] args) {

        String zipFilePath = "example.zip"; // Path to your ZIP file

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("File: " + entry.getName());

                if (!entry.isDirectory()) {
                    // Read file contents
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }

                    // Print the file content as text (if text file)
                    String fileContent = baos.toString("UTF-8");
                    System.out.println("Content:\n" + fileContent);
                }
                zis.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
