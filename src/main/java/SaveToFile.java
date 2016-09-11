import data.AppData;
import interfaces.Saveable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rafal on 2016-09-11.
 */
public class SaveToFile implements Saveable {

    public Boolean save(String stringToBeSaved) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(AppData.fileName));
        printWriter.write(stringToBeSaved);
        printWriter.close();
        return null;
    }
}
