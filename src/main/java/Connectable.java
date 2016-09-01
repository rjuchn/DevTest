import java.io.IOException;

/**
 * Created by Rafal on 2016-09-01.
 */
public interface Connectable {
    void connectUrl() throws IOException;
    void disconnectUrl();
}
