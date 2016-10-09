package com.juchnicki.interfaces;

/**
 * Created by Rafal on 2016-09-17.
 */
public interface Validatable {
    /*Returns empty string if validation pass, Error message if fails*/
    String validate(String input);
}
