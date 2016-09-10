import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

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
        cityValidator.getValidatedString();
        System.out.println(cityValidator.getValidatedString());

        Connectable urlReader = new UrlConnector(cityValidator.getValidatedString());
        TextReader textReader = new TextReader();
        String jsonText = textReader.getStringData(urlReader.getConnectionStream());

        JSONParser jParser = new JSONParser();
        JSONArray jArray = (JSONArray) jParser.parse(jsonText);


        JsonFormatter csvOutput = new CsvBuilder();
        String result = csvOutput.jsonToString(jArray);

        PrintWriter printWriter = new PrintWriter(new FileWriter(AppData.fileName));
        printWriter.write(result);
        printWriter.close();
    }
}

