package utils;

import interfaces.JsonFormatter;
import model.LocationPOJO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-09-01.
 */
@Controller
@Qualifier(value="CsvBuilder")
public class CsvBuilder implements JsonFormatter {

    public JSONArray parseJasonString(String inputString) throws ParseException {
        JSONParser jParser = new JSONParser();
        JSONArray jArray = (JSONArray) jParser.parse(inputString);

        return jArray;
    }

    public List<LocationPOJO> formatJsonArray(JSONArray jsonArray){

        List<LocationPOJO> locationPOJOList = new ArrayList<LocationPOJO>();

            for(Object jObject : jsonArray){
                JSONObject jsonObject = (JSONObject) jObject;
                LocationPOJO locationPOJO = new LocationPOJO();

                locationPOJO.setId((Long) jsonObject.get("_id"));
                locationPOJO.setName((String) jsonObject.get("name"));
                locationPOJO.setType((String) jsonObject.get("type"));

                Object geo_position = jsonObject.get("geo_position");
                JSONObject json_geo_position = (JSONObject) geo_position;

                locationPOJO.setGeo_latitude((Double) json_geo_position.get("latitude"));
                locationPOJO.setGeo_longitude((Double) json_geo_position.get("longitude"));

                locationPOJOList.add(locationPOJO);
            }

        return locationPOJOList;
    }
}

