import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

/**
 * Created by Rafal on 2016-09-05.
 */
public interface Validator {
    Boolean validateArrayInput(String[] inputArray);
    Boolean validateProperString(String stringToValidate);
    String getValidatedString();
}