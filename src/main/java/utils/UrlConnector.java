package utils;

import data.Constants;
import interfaces.Connectable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Rafal on 2016-09-07.
 */
public class UrlConnector implements Connectable {
    private URLConnection url;
    HttpURLConnection httpURLConnection;
    String urlSpecifier = null;

    public UrlConnector(String urlSpecifier) {
        this.urlSpecifier = urlSpecifier;
    }

    public InputStream getConnectionStream() {
        try {
            url = new URL(Constants.baseURL + urlSpecifier).openConnection();
            httpURLConnection = (HttpURLConnection) url;
            return httpURLConnection.getInputStream();
        } catch (IOException e){
            System.out.println("Error: " + e.toString());
            System.exit(0);
        }
        return null;
    }
}


