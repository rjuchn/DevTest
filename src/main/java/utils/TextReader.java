package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

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
@Component
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
}
