import java.io.IOException;

/**
 * Created by Rafal on 2016-09-01.
 */
public interface Connectable {
    
    // Modify this interace accordingly. When using Connector 
    // (that implements this interface) use only Connectable reference!
    
    void connectUrl() throws IOException;
    void disconnectUrl();
}
