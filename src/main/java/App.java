import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Saveable;
import org.json.simple.parser.ParseException;
import utils.*;
import validators.StringLengthValidator;
import validators.Validator;

import java.io.IOException;

/**
 * Created by Rafal on 2016-09-05.
 */
public class App {

    public void generateCsvFile(String[] inputText) throws IOException, ParseException {
        Validator validator = new StringLengthValidator();
        validator.addToValidationQueue();

        Connectable urlReader = new UrlConnector(validator.validate(inputText));

        TextReader textReader = new TextReader();
        String jsonText = textReader.getStringData(urlReader.getConnectionStream());

        JsonFormatter csvOutput = new CsvBuilder();
        String output = csvOutput.formatJsonArray(csvOutput.parseJasonString(jsonText));

        try{
            Saveable file = new SaveToFile();
            file.save(output);
        } catch (IOException e){
            System.out.println("There were errors during saving to file: " + e.toString());
        }
    }
}

