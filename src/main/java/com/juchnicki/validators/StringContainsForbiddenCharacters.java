package com.juchnicki.validators;

import com.juchnicki.interfaces.Validatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rafal on 2016-09-17.
 */
@Component
public class StringContainsForbiddenCharacters implements Validatable {
    private MessageSource messageSource;

    /*Autowiring this by type - there is only one bean MessageSource class*/
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String validate(String input) {
        String pattern = "[^A-Za-z]";
        Pattern jPattern = Pattern.compile(pattern);
        Matcher matcher = jPattern.matcher(input);
        if (matcher.find()) {
            return this.messageSource.getMessage("validator.forbiddenCharacter.error", null, "Can't get error message.", null).toString();
        } else {
            return "";
        }
    }
}
