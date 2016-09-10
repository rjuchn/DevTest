/**
 * Created by Rafal on 2016-09-05.
 */
public class InputValidator implements Validator {
    private String inputString;
    private String[] args;

    public InputValidator(String[] args) {
        this.args = args;
    }

    public String getValidatedString() {
        inputString = args[0];
        if(inputString != null){
            return inputString.trim();
        } else{
            return null;
        }
    }
}
