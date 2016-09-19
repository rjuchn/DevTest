package validators;

import interfaces.Validatable;
import org.springframework.stereotype.Component;

/**
 * Created by Rafal on 2016-09-05.
 */
@Component
public class StringLengthValidatorRegister implements Validatable {
    public String validate(String input) {
        if(input != null){
            return "";
        } else{
            return "There is no input parameter !";
        }
    }
}
