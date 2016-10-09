package com.juchnicki.validators;

import com.juchnicki.interfaces.Validatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Rafal on 2016-09-12.
 */
@Component
public class StringNotContainsNumbers implements Validatable{
    private MessageSource messageSource;

    /*It is also autowired because the name of variable is same as bean id (but type matching goes first) */
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String validate(String input) {
        String pattern = "\\d+";
        Pattern jPattern = Pattern.compile(pattern);
        Matcher matcher = jPattern.matcher(input);
        if(matcher.find()){
            return this.messageSource.getMessage("validator.numbers.error", null, "Message can not be displayed !", null);
        } else {
            return "";
        }
    }
}
