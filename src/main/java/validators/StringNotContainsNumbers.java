package validators;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Rafal on 2016-09-12.
 */
public class StringNotContainsNumbers extends Validator {
    protected String getValidatedString(String inputArray) {
        String pattern = "\\d+";
        Pattern jPattern = Pattern.compile(pattern);
        Matcher matcher = jPattern.matcher(inputArray.trim());
        if(matcher.lookingAt()){
            return "Input value should not contain digits.";
        }
        return "";
    }
}
