package validators;

/**
 * Created by Rafal on 2016-09-05.
 */
public class StringLengthValidator extends Validator {
    public String getValidatedString(String[] inputArray) {
        String inputString = inputArray[0];
        if(inputString != null){
            return inputString.trim();
        } else{
            return "";
        }
    }
}
