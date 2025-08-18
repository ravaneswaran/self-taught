package rave.code.utility.csv;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface FileReader {

    public List<CSVRecord> read(InputStream inputStream) throws IOException;

}
