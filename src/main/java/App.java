import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Saveable;
import org.json.simple.parser.ParseException;
import utils.*;
import validators.StringLengthValidator;
import validators.StringNotContainsNumbers;
import validators.Validator;

import java.io.IOException;

/**
 * Created by Rafal on 2016-09-05.
 */
public class App {

    public void generateCsvFile(String[] inputText) throws IOException, ParseException {
        Validator validator = new StringLengthValidator();
        Validator digitValidator = new StringNotContainsNumbers();
        validator.addToValidationQueue();
        digitValidator.addToValidationQueue();

        Connectable urlReader = null;
        if(validator.validate(inputText[0]) == ""){
            urlReader = new UrlConnector(inputText[0].trim());
        } else {
            System.out.println("There was an input error. Application terminated. Error: " + validator.validate(inputText[0]));
            System.exit(0);
        }

        TextReader textReader = new TextReader();
        String jsonText = textReader.getStringData(urlReader.getConnectionStream());

        JsonFormatter csvOutput = new CsvBuilder();
        String output = csvOutput.formatJsonArray(csvOutput.parseJasonString(jsonText));

        Saveable file = new SaveToFile();
        file.save(output);

    }
}

