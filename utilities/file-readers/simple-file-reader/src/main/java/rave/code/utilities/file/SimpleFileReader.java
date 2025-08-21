package rave.code.utilities.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class SimpleFileReader {

    public List<String> read(InputStream inputStream) throws IOException {
        List<String> lineContentList = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                result.append((char) ch);
            }
        }
        String[] lines = result.toString().split("\n");
        for (String line : lines) {
            lineContentList.add(line);
        }
        return lineContentList;
    }
}
