import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Rafal on 2016-08-06.
 */
public class Main {

    public static void main(String [ ] args) throws Exception {

        Connector urlReader = new Connector();
        urlReader.setConnectionURL(args[0]);
        urlReader.connectUrl();

        JSONParser jParser = new JSONParser();
        TextReader urlResponse = new TextReader();
        String urlJsonTxt = urlResponse.getStringData(urlReader.getConnection());

        Object jsonString = jParser.parse(urlJsonTxt);

        urlReader.disconnectUrl();

        JSONArray jArray = (JSONArray) jsonString;

        CsvCreator csvOutput = new CsvCreator();

        String result = csvOutput.makeResultString(jArray).toString();

        PrintWriter printWriter = new PrintWriter(new FileWriter(AppData.fileName));
        printWriter.write(result);
        printWriter.close();

        System.out.println(result);
    }
}
