import interfaces.Connectable;
import interfaces.JsonFormatter;
import interfaces.Savable;
import model.LocationPOJO;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.*;
import validators.ValidatorRegister;

import javax.annotation.Resource;
import javax.inject.Inject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-09-05.
 */
public final class App {

    /* Autowiring with resource (not part of Spring framework but JSR-250 standard)*/
    @Resource(name = "messageSource")
    private MessageSource messageSource;

    @Inject
    private ValidatorRegister validatorRegister;

    @Inject
    JsonFormatter csvOutput;

    @Autowired
    @Qualifier("urlConnectorXXX")
    private Connectable urlReader;

    @Autowired
    TextReader textReader;

    // Spring is been turning on here...
    private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    private Savable saveStrategy;

    // Initializer block : Please read about it...
    {
        // Inject App to Spring context
        context.getAutowireCapableBeanFactory().autowireBean( App.this );
    }

    public void generateCsvFile(String[] inputText) throws IOException, ParseException {

        String inputString = InputFormatter.formatInputArray(inputText);
        String validationResults = validatorRegister.checkValidations(inputString);

        // validationResults should not be null so we do not consider "".equals comparision,
        // because NullPointer would be a hint for developer that something is wrong.
        if( validationResults.isEmpty() ) {
            urlReader.connect(inputString);
        } else {
            System.out.println(validationResults);
            System.exit(0);
        }

        // Better exception handling!!!!!
        String jsonText = null;

        try {
            jsonText = textReader.getStringData( urlReader.getInputStream() );
        } catch (IOException e) {
            // if exception occurs you continue program with null jsonText!!!
            e.printStackTrace();
        }



        List<LocationPOJO> locationPOJOs = new ArrayList<LocationPOJO>();
        try {
            locationPOJOs = csvOutput.formatJsonArray(csvOutput.parseJasonString(jsonText));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        save(locationPOJOs);
    }

    private void print(String validationResults) {
         /* Passing an array of objects to getMessage method so it gets included to displayed message */
        System.out.println( this.messageSource.getMessage("app.inputError",
                new Object[] {validationResults}, "ERROR WITH DISPLAYING ERROR ;]", null) );
    }

    private void save(List<LocationPOJO> objectsList) {
        this.saveStrategy.save(objectsList);
    }

    public Savable getSaveStrategy() {
        return saveStrategy;
    }

    public void setSaveStrategy(Savable saveStrategy) {
        this.saveStrategy = saveStrategy;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public JsonFormatter getCsvOutput() {
        return csvOutput;
    }

    public void setCsvOutput(JsonFormatter csvOutput) {
        this.csvOutput = csvOutput;
    }
}

