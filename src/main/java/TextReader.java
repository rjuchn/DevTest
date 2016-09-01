import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Rafal on 2016-09-01.
 */
public class TextReader {
    private String textLine;

    public String getStringData(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        do {
            textLine = in.readLine();
        } while(in.readLine() != null);

        in.close();
        return textLine;
    }
}
