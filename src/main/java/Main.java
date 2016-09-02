import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Rafal on 2016-08-06.
 */
public class Main {

    public static void main(String [ ] args) throws Exception {

        // 1. Create object that will handle all logic that is in main function
        // 2. Add validation. Create interface i.e. Validator. Create some classes that implement it.
        //    Read about 'chain of responsability', 'strategy' and 'command' design patterns They could be useful.
        // 3. Create at least 3 distinc interfaces and classes that implement it (i.e. Validator, Connector, Parser)
        // 4. Use try/catch/finally properly. Read about exception handling in Java. Read about 'try with resources' in Java 7.

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
