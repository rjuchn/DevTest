package interfaces;

import java.io.IOException;

/**
 * Created by Rafal on 2016-09-11.
 */
public interface Saveable {
    Boolean save(String stringToBeSaved) throws IOException;
}
