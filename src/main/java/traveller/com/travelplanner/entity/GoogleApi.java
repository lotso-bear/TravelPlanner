package traveller.com.travelplanner.entity;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class GoogleApi {

    private static final String APIKEY = "AIzaSyDhub8iMmhP6KqVOujS98FXTsrVlNKdtig";
    private GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(APIKEY)
            .build();

    public GeocodingResult[] callGeoApi(String code) throws IOException, InterruptedException, ApiException {

        GeocodingResult[] results =  GeocodingApi.geocode(context, code).await();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        System.out.println(gson.toJson(results[0]));
        return results;
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

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        GoogleApi googleApi = new GoogleApi();
        String code = "Q254+J5";
        GeocodingResult[] results = googleApi.callGeoApi(code);
        System.out.println(Arrays.toString(results));
//        try {
//            googleApi.callPlacesApi(37.8199, -122.4783);
//        } catch (IOException ioe) {
//            System.out.println("Exception Occurred: " + ioe.getMessage());
//        }
    }


}
