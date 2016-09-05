import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rafal on 2016-09-01.
 */
public class Connector implements Connectable{
    private URL connectionURL;
    private HttpURLConnection connection;

    // DESIGN:
    // To use thid class you have to invoke methods accordingly.
    // I know setConnectionURL is enough but we want to change that.
    // Otherwise it fails to work. Document this or make it 
    // easier to use, i.e. in one line
    
    // Try to do the below and maybe it would help you to see some useful details.
    // OBJECTIVE1: Use builder design pattern to create this object
    // OBJECTIVE2: Create static factory method to create this object

    public URL getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String URLSpecifier) throws IOException {
        this.connectionURL = new URL(AppData.baseURL + URLSpecifier);
        // remove this, it's confusing since the method name does not specify it handles the connection
        setConnection();
    }

    // do we really need to expose to the Client the whole HttpURLConnection ???
    // analyze wheather it would be better to narrow the use API 
    // (hint. I think you dont need HttpConnection, but kind of Stream object retrieved from it)
    public HttpURLConnection getConnection() {
        return connection;
    }

    // rename to openConnection (don't be affraid of delegation/forwarding)
    public void setConnection() throws IOException {
        this.connection = (HttpURLConnection) connectionURL.openConnection();
    }

    // is it really needed to connect/disconnect while having conenction opened via openConnection() method?
    public void connectUrl() throws IOException {
        connection.connect();
    }
    public void disconnectUrl() {
        connection.disconnect();
    }
}
