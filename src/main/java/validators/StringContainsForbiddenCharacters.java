package validators;

import interfaces.Validatable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rafal on 2016-09-17.
 */
public class StringContainsForbiddenCharacters implements Validatable {
    public String validate(String input) {
        String pattern = "[^A-Za-z]";
        Pattern jPattern = Pattern.compile(pattern);
        Matcher matcher = jPattern.matcher(input);
        if(matcher.lookingAt()){
            return "Input value should not contain characters other than letters.";
        } else {
            return "";
        }
    }
}
