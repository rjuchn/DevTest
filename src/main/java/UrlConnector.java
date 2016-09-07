import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Rafal on 2016-09-07.
 */
public class UrlConnector extends Connector {
    Connection connection;
    String connectionAdress;


    public UrlConnector(String connectionAdress) {
        this.connectionAdress = connectionAdress;
    }

    Connection createConnection(String connectionType) throws IOException{
        if(connectionType == "URL"){
            URL url = null;
            url = new URL(connectionAdress);
            connection = (Connection) url.openConnection();
            return connection;
        }



    }
}
