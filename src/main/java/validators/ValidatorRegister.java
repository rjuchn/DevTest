package validators;

import interfaces.Validatable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-09-12.
 */
public class ValidatorRegister {
    protected static List<Validatable> validationQueue = new ArrayList<Validatable>();

    public static String showValidationList(){
        StringBuffer result = new StringBuffer();
        for(Validatable validator : validationQueue){
            result.append(validator.getClass().toString());
        }
        return result.toString();
    }

    public static void setToValidationQueue(Validatable validator){
        validationQueue.add(validator);
    }

    public static void removeFromValidationQueue(Validatable validator){
        validationQueue.remove(validator);
    }

    public static String checkValidations(String validatedString){
        StringBuffer validationResult = new StringBuffer();
        try {
            for (Validatable validator : validationQueue) {
                validationResult.append(validator.validate(validatedString));
            }
        } catch (NullPointerException e){
            System.out.println("There was no input - application stopped. Error: " + e.toString());
            System.exit(0);
        }
        return validationResult.toString();
    }
}
