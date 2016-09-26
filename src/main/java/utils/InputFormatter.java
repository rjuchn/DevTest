package utils;

/**
 * Created by Rafal on 2016-09-18.
 */
public class InputFormatter {
    public static String formatInputArray(String[] stringArray){
        String inputString = null;
        if(stringArray.length != 0){
            inputString = stringArray[0].replaceAll("\\s","");
        }
        return inputString;
    }
}