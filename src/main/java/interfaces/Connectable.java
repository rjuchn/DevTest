package interfaces;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rafal on 2016-09-10.
 */
public interface Connectable {
    InputStream getConnectionStream() throws IOException;
}
