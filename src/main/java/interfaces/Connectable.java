package interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * Created by Rafal on 2016-09-10.
 */
public interface Connectable {
    void connect(String url) throws IOException;
    InputStream getInputStream() throws IOException;
}
