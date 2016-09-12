package utils;

import data.Constants;
import interfaces.JsonFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Rafal on 2016-09-01.
 */
public class CsvBuilder implements JsonFormatter {


    // Apply changes that we were talking about earlier.

    // DESIGN:
    // Extrac some interface from it. Use 'strategy' pattern, 
    // in future we will want to store the data from webservice not only in CSV file but i.e. in database.
    // take that into consideration when designing interface and applying startegy pattern.

    public JSONArray parseJasonString(String inputString) throws ParseException {
        JSONParser jParser = new JSONParser();
        JSONArray jArray = (JSONArray) jParser.parse(inputString);

        return jArray;
    }

    public String formatJsonArray(JSONArray jsonArray) {

        StringBuilder resultString = null;
        resultString.append(Constants.columnList);

        for (Object jObject : jsonArray) {
            JSONObject jsonObject = (JSONObject) jObject;

            Object objId = jsonObject.get("_id");
            Object objName = jsonObject.get("name");
            Object objType = jsonObject.get("type");
            Object geo_position = jsonObject.get("geo_position");
            JSONObject json_geo_position = (JSONObject) geo_position;
            Object objLatitude = json_geo_position.get("latitude");
            Object objLongitude = json_geo_position.get("longitude");

            resultString.append(objId.toString() + "," + objName.toString() + "," + objType.toString() + "," + objLatitude.toString() + "," + objLongitude.toString() + "\n");
        }

        return resultString.toString();
    }
}
