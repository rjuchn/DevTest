package validators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-09-12.
 */
public abstract class Validator {
    protected static List<Validator> validationQueue = new ArrayList<Validator>();

    public void addToValidationQueue(){
        validationQueue.add(this);
    }

    public void removeFromValidationQueue(){
        validationQueue.remove(this);
    }

    public String validate(String[] inputArray) {
        String result = "";
        for(Validator validator : validationQueue){
            result = validator.getValidatedString(inputArray);
        }
        return result;
    }

    protected abstract String getValidatedString(String[] inputArray);
}
