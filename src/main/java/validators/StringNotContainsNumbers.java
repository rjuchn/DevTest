package validators;

import interfaces.Validatable;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Rafal on 2016-09-12.
 */
@Component
public class StringNotContainsNumbers implements Validatable{
    public String validate(String input) {
        String pattern = "\\d+";
        Pattern jPattern = Pattern.compile(pattern);
        Matcher matcher = jPattern.matcher(input);
        if(matcher.lookingAt()){
            return "Input value should not contain digits.";
        } else {
            return "";
        }
    }
}
