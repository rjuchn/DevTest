package controllers;

import interfaces.JsonFormatter;
import model.LocationPojo;
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

    public List<LocationPojo> formatJsonArray(JSONArray jsonArray){

        List<LocationPojo> locationPojoList = new ArrayList<LocationPojo>();

            for(Object jObject : jsonArray){
                JSONObject jsonObject = (JSONObject) jObject;
                LocationPojo locationPojo = new LocationPojo();

                locationPojo.setId((Long) jsonObject.get("_id"));
                locationPojo.setName((String) jsonObject.get("name"));
                locationPojo.setType((String) jsonObject.get("type"));

                Object geo_position = jsonObject.get("geo_position");
                JSONObject json_geo_position = (JSONObject) geo_position;

                locationPojo.setGeo_latitude((Double) json_geo_position.get("latitude"));
                locationPojo.setGeo_longitude((Double) json_geo_position.get("longitude"));

                locationPojoList.add(locationPojo);
            }

        return locationPojoList;
    }
}

