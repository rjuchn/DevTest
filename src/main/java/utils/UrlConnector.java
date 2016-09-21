package utils;

import data.Constants;
import interfaces.Connectable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rafal on 2016-09-07.
 */
public class UrlConnector implements Connectable {
    private HttpURLConnection httpURLConnection;

    public void connect(String url) throws IOException {
        httpURLConnection = (HttpURLConnection) new URL(Constants.baseURL + url).openConnection();
    }

    public InputStream getInputStream() throws IOException {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e){
            throw new RuntimeException("Unable to get input stream. Error msg: " + e.getMessage());
        }
    }
}


