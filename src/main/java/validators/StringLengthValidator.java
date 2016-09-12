package validators;

/**
 * Created by Rafal on 2016-09-05.
 */
public class StringLengthValidator extends Validator {
    public String getValidatedString(String inputArray) {
        if(inputArray != null){
            return "";
        } else{
            return "There is no input parameter !";
        }
    }
}
