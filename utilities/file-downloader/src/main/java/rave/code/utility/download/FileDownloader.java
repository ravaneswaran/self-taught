package rave.code.utility.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {

    public InputStream downloadFile(String url) throws IOException {
        return this.downloadFile(new URL(url));
    }

    public InputStream downloadFile(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36)");
        conn.setInstanceFollowRedirects(true);

        return conn.getInputStream();
    }
}
