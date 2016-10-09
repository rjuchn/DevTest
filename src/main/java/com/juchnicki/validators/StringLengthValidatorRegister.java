package com.juchnicki.validators;

import com.juchnicki.interfaces.Validatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Created by Rafal on 2016-09-05.
 */
@Component
public class StringLengthValidatorRegister implements Validatable {
    private MessageSource messageSource;

    /*Autowiring this by type - there is only one bean MessageSource class*/
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String validate(String input) {
        if( input != null && !input.isEmpty() ) {
            return "";
        } else{
            return this.messageSource.getMessage("validator.length.error", null, "Message can not be displayed !", null).toString();
        }
    }
}
