import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Rafal on 2016-09-01.
 */
public class CsvBuilder implements JsonFormatter{
    private String columnList;
    private StringBuilder resultString;

    // Apply changes that we were talking about earlier.

    // DESIGN:
    // Extrac some interface from it. Use 'strategy' pattern, 
    // in future we will want to store the data from webservice not only in CSV file but i.e. in database.
    // take that into consideration when designing interface and applying startegy pattern.

    public CsvBuilder() {
        resultString = new StringBuilder();
        columnList = AppData.columnList;
        resultString.append(columnList + "\n");
    }

    public String jsonToString(JSONArray jsonArray) {
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
