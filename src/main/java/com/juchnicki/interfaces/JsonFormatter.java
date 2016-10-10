package com.juchnicki.interfaces;

import com.juchnicki.model.LocationPojo;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.util.List;

/**
 * Created by Rafal on 2016-09-05.
 */
public interface JsonFormatter {
    JSONArray parseJasonString(String inputString) throws ParseException;

    List<LocationPojo> formatJsonArray(JSONArray jsonArray);
}
