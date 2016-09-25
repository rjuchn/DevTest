import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Saveable;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.*;
import validators.ValidatorRegister;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Rafal on 2016-09-05.
 */
public class App {

    /* Autowiring with resource (not part of Spring framework but JSR-250 standard)*/
    @Resource(name="messageSource")
    private MessageSource messageSource;

    public void generateCsvFile(String[] inputText) throws IOException {
//        SaveToDatabase saveToDatabase = new SaveToDatabase();
//        saveToDatabase.save("test");

        InputFormatter inputFormatter = new InputFormatter();
        String inputString = inputFormatter.formatInputArray(inputText);

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        /*Injecting validators through xml bean configuration*/
        ValidatorRegister validatorRegister = (ValidatorRegister) context.getBean("validatorRegister");

        Connectable urlReader = new UrlConnector();
        if(validatorRegister.checkValidations(inputString).length() == 0){
            urlReader.connect(inputString);
        } else {
            /* Passing an array of objects to getMessage method so it gets included to displayed message */
            System.out.println(this.messageSource.getMessage("app.inputError", new Object[] {validatorRegister.checkValidations(inputString)}, "ERROR WITH DISPLAYING ERROR ;]", null));
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

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}

