import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Saveable;
import org.json.simple.parser.ParseException;
import utils.CsvBuilder;
import utils.SaveToFile;
import utils.TextReader;
import utils.UrlConnector;
import validators.StringContainsForbiddenCharacters;
import validators.StringLengthValidatorRegister;
import validators.StringNotContainsNumbers;
import validators.ValidatorRegister;

import java.io.IOException;

/**
 * Created by Rafal on 2016-09-05.
 */
public class App {

    public void generateCsvFile(String[] inputText) {
        String inputString = null;
        if(inputText.length != 0){
            inputString = inputText[0].replaceAll("\\s","");
        }
        ValidatorRegister.setToValidationQueue(new StringLengthValidatorRegister());
        ValidatorRegister.setToValidationQueue(new StringContainsForbiddenCharacters());
        ValidatorRegister.setToValidationQueue(new StringNotContainsNumbers());

        Connectable urlReader = null;

        if(ValidatorRegister.checkValidations(inputString).length() == 0){
            urlReader = new UrlConnector(inputString);
        } else {
            System.out.println("There was an input error. Application terminated. Error: " + ValidatorRegister.checkValidations(inputString));
            System.exit(0);
        }

        TextReader textReader = new TextReader();

        String jsonText = null;
        try {
            jsonText = textReader.getStringData(urlReader.getConnectionStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonFormatter csvOutput = new CsvBuilder();
        String output = null;
        try {
            output = csvOutput.formatJsonArray(csvOutput.parseJasonString(jsonText));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Saveable file = new SaveToFile();
        file.save(output);
    }
}

