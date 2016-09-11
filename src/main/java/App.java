import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Saveable;
import interfaces.Validator;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

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

        Connectable urlReader = new UrlConnector(cityValidator.getValidatedString());

        TextReader textReader = new TextReader();
        String jsonText = textReader.getStringData(urlReader.getConnectionStream());


        JsonFormatter csvOutput = new CsvBuilder();
        JSONArray jArray  = csvOutput.parseJasonString(jsonText);
        String output = csvOutput.formatJsonArray(jArray);

        try{
            Saveable file = new SaveToFile();
            file.save(output);
        } catch (IOException e){
            System.out.println("There were errors during saving to file: " + e.toString());
        }

    }
}

