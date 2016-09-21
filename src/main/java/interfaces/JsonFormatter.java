package interfaces;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * Created by Rafal on 2016-09-05.
 */
public interface JsonFormatter {
    JSONArray parseJasonString(String inputString) throws ParseException;
    String formatJsonArray(JSONArray jsonArray);
}
