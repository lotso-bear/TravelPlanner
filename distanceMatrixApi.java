import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class distanceMatrixApi {
    private static HttpURLConnection connection;
    private static final java.lang.String key = "AIzaSyCLtCYjUi1-WRsP8OYHHHi_buI3cfZYOgk";
    static BufferedReader reader;
    static java.lang.String line;
    static StringBuffer content = new StringBuffer();

    static float[][] distances;
    static float[][] durations;

    public static void getData(java.lang.String origin, java.lang.String destination) throws Exception {
        URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination + "&key=" +key);
        connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setReadTimeout(6000);
        connection.setConnectTimeout(6000);

        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine()) != null){
            content.append(line);
        }
        reader.close();
        connection.disconnect();
        System.out.println(content.toString());
    }

    public static void parse(String content, int i, int j) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(content);
        JSONArray array = (JSONArray) obj.get("rows");
        obj = (JSONObject) array.get(i);
        array = (JSONArray) obj.get("elements");
        obj = (JSONObject) array.get(j);
        JSONObject dist = (JSONObject) obj.get("distance");
        JSONObject dur = (JSONObject) obj.get("duration");
        float distance = (float)dist.get("value");
        float duration = (float)dur.get("value");
        distances[i][j] = distance;
        durations[i][j] = duration;
    }

    public static void main(String[] args) throws Exception {
        getData("Brooklyn%2CNY", "Queens%2CNY");
    }
}
