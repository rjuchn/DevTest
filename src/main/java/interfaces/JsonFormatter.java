package interfaces;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import model.LocationPojo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Rafal on 2016-09-05.
 */
@Component
public interface JsonFormatter {
    JSONArray parseJasonString(String inputString) throws ParseException;
    List<LocationPojo> formatJsonArray(JSONArray jsonArray);
}
