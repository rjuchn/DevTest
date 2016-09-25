package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-09-01.
 */
public class TextReader {



    public String getStringData(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input;
        StringBuffer stringBuffer = new StringBuffer();
        while((input = bufferedReader.readLine()) != null){
            stringBuffer.append(input);
        }
        bufferedReader.close();

        return stringBuffer.toString();
    }

    public List<LocationPOJO> getLocationPojoArray(InputStream inputStream) throws IOException, ParseException {
        List<LocationPOJO> locationPOJOList = new ArrayList<LocationPOJO>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input;
        StringBuffer stringBuffer = new StringBuffer();
        while((input = bufferedReader.readLine()) != null) {
            stringBuffer.append(input);
        }
        bufferedReader.close();

        JSONParser jParser = new JSONParser();
        JSONArray jArray = (JSONArray) jParser.parse(stringBuffer.toString());

        for(Object jObject : jArray){
            JSONObject jsonObject = (JSONObject) jObject;
            LocationPOJO locationPOJO = new LocationPOJO();

            locationPOJO.setId((Integer) jsonObject.get("_id"));
            locationPOJO.setName((String) jsonObject.get("name"));
            locationPOJO.setType((String) jsonObject.get("type"));

            Object geo_position = jsonObject.get("geo_position");
            JSONObject json_geo_position = (JSONObject) geo_position;

            locationPOJO.setGeo_latitude((Integer) json_geo_position.get("latitude"));
            locationPOJO.setGeo_longitude((Integer) json_geo_position.get("longitude"));

            locationPOJOList.add(locationPOJO);
        }

        return locationPOJOList;
    }
}
