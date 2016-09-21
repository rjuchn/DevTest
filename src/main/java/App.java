import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Saveable;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.*;
import validators.ValidatorRegister;

import java.io.IOException;

/**
 * Created by Rafal on 2016-09-05.
 */
public class App {

    public void generateCsvFile(String[] inputText) throws IOException {
        InputFormatter inputFormatter = new InputFormatter();
        String inputString = inputFormatter.formatInputArray(inputText);

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        /*Injecting validators through xml bean configuration*/
        ValidatorRegister validatorRegister = (ValidatorRegister) context.getBean("validatorRegister");

        Connectable urlReader = new UrlConnector();
        if(validatorRegister.checkValidations(inputString).length() == 0){
            urlReader.connect(inputString);
        } else {
            System.out.println("There was an input error. Application terminated. Error: " + validatorRegister.checkValidations(inputString));
            System.exit(0);
        }

        TextReader textReader = new TextReader();

        String jsonText = null;
        try {
            jsonText = textReader.getStringData(urlReader.getInputStream());
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

