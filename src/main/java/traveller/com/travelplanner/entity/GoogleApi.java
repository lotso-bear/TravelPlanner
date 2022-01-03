package traveller.com.travelplanner.entity;


import com.google.gson.*;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

public class GoogleApi {
    private static SessionFactory factory;
    private static final String APIKEY = "AIzaSyDhub8iMmhP6KqVOujS98FXTsrVlNKdtig";
    private JsonParser parser;
    private GeoApiContext context;

    public GoogleApi() {
        this.context = new GeoApiContext.Builder()
                .apiKey(APIKEY)
                .build();
        parser = new JsonParser();
    }

    // returns Json geo info in hashmap entries
    public JsonObject callGeoApi(String name) throws IOException, InterruptedException, ApiException {
        GeocodingResult[] results = GeocodingApi.geocode(context, name).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(results[0]);
        JsonObject obj = (JsonObject) parser.parse(json);
        return obj;
    }

    /*
     @param name: city name
     @param plusCode: city plus code for google geo api input
     */
    public String[] getCity(String name) throws IOException, InterruptedException, ApiException {
        JsonObject geometry = callGeoApi(name);
        JsonObject location = geometry.get("geometry").getAsJsonObject().get("location").getAsJsonObject();
        String lat = location.get("lat").getAsString();
        String lng = location.get("lng").getAsString();
        return new String[] {lat, lng};
    }

    public void callPlacesApi(double latitude, double longitude) throws IOException {
        URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?location="
                + latitude + "," + longitude + "&radius=2000&region=us&type=point_of_interest&key=" + APIKEY);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content.toString());
    }

    private static final String RDS = "jdbc:mysql://travel-planner.cu5gi9o5hjot.us-east-2.rds.amazonaws.com";
    private static final String user = "admin";
    private static final String password = "12345678";
    public static void main(String[] args) throws IOException, InterruptedException, ApiException, SQLException {
        String[] cities = new String[] {"New York", "Chicago", "San Francisco"};
        GoogleApi googleApi = new GoogleApi();
        for (String city : cities) {
            String[] location = googleApi.getCity(city);
            System.out.println(city + ": " + Arrays.toString(location));
        }

//        try {
//            googleApi.callPlacesApi(37.8199, -122.4783);
//        } catch (IOException ioe) {
//            System.out.println("Exception Occurred: " + ioe.getMessage());
//        }
    }


}
