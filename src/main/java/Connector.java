import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Rafal on 2016-09-01.
 */
public abstract class Connector {

    public Connection setConnection(String connectionType){
        Connection connection;
        connection = createConnection(connectionType);

        return connection;
    }

    abstract Connection createConnection(String connectionType) throws MalformedURLException, IOException;

}
