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

    public void generateCsvFile() throws IOException {
        Validator cityValidator = new InputValidator(inputText);
        cityValidator.getValidatedString();
        System.out.println(cityValidator.getValidatedString());

        Connectable urlReader = new UrlConnector(cityValidator.getValidatedString());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlReader.getConnectionStream()));
        String input;
        StringBuffer stringBuffer = new StringBuffer();
        while((input = bufferedReader.readLine()) != null){
            stringBuffer.append(input);
        }
        bufferedReader.close();

        System.out.println(stringBuffer.toString());

        /*JSONParser jParser = new JSONParser();
        TextReader urlResponse = new TextReader();

        JSONArray jArray = (JSONArray) jsonString;

        JsonFormatter csvOutput = new CsvBuilder();
        String result = csvOutput.jsonToString(jArray);

        PrintWriter printWriter = new PrintWriter(new FileWriter(AppData.fileName));
        printWriter.write(result);
        printWriter.close();*/
    }
}

