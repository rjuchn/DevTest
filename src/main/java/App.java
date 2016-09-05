import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rafal on 2016-09-05.
 */
public class App {
    String[] inputText;


    public App(String[] inputText) {
        this.inputText = inputText;
    }

    public void generateCsvFile() throws IOException, ParseException {
        Validator cityValidator = new InputValidator(inputText);

        Connector urlReader = new Connector();
        urlReader.setConnectionURL(cityValidator.getValidatedString());
        urlReader.connectUrl();

        JSONParser jParser = new JSONParser();
        TextReader urlResponse = new TextReader();
        String urlJsonTxt = urlResponse.getStringData(urlReader.getConnection());

        Object jsonString = jParser.parse(urlJsonTxt);

        urlReader.disconnectUrl();

        JSONArray jArray = (JSONArray) jsonString;

        JsonFormatter csvOutput = new CsvBuilder();
        String result = csvOutput.jsonToString(jArray);

        PrintWriter printWriter = new PrintWriter(new FileWriter(AppData.fileName));
        printWriter.write(result);
        printWriter.close();
    }
}

