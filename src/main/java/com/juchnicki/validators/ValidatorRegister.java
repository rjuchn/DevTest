package com.juchnicki.validators;

import com.juchnicki.interfaces.Validatable;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-09-12.
 */
public class ValidatorRegister {
    private List<Validatable> validationQueue = new ArrayList<Validatable>();

    /* Adding that to make sure that at least one validator bean is registered */
    @Required
    public void setValidationQueue(List<Validatable> validationQueue) {
        this.validationQueue = validationQueue;
    }

    public String showValidationList() {
        StringBuffer result = new StringBuffer();
        for (Validatable validator : validationQueue) {
            result.append(validator.getClass().toString());
        }
        return result.toString();
    }

    public void setToValidationQueue(Validatable validator) {
        validationQueue.add(validator);
    }

    public void removeFromValidationQueue(Validatable validator) {
        validationQueue.remove(validator);
    }

    public String checkValidations(String validatedString) {
        StringBuffer validationResult = new StringBuffer();
        for (Validatable validator : validationQueue) {
            validationResult.append(validator.validate(validatedString));
        }

        return validationResult.toString();
    }
}
