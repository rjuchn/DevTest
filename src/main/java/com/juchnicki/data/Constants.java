package com.juchnicki.data;

/**
 * Created by Rafal on 2016-09-01.
 */
public class Constants {

    // Database properties
    public static final String baseURL = "http://api.goeuro.com/api/v2/position/suggest/en/";
    public static final String fileName = "wynik.csv";
    public static final String columnList = "_id,name,type,latitude,longitude";

    // Spring strategy names
    public static final String STRATEGY_SAVE_TO_DATABASE = "saveToDatabase";
    public static final String STRATEGY_SAVE_TO_FILE = "saveToFile";
}
