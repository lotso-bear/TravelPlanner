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

public class GoogleApi {
    GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyDhub8iMmhP6KqVOujS98FXTsrVlNKdtig")
            .build();

    public void callGeoApi() throws IOException, InterruptedException, ApiException {

        GeocodingResult[] results =  GeocodingApi.geocode(context,
                "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0]));
    }

    public void callPlacesApi(double latitude, double longitude) throws IOException {
        URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?location="
         + latitude + "," + longitude + "&radius=2000&region=us&type=point_of_interest&key=AIzaSyBzPa1oDc9mU2SJWAfLY92vJxwufqH1Hj8");
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

    public static void main(String[] args) {
        GoogleApi googleApi = new GoogleApi();
        try {
            googleApi.callPlacesApi(37.8199, -122.4783);
        } catch (IOException ioe) {
            System.out.println("Exception Occurred: " + ioe.getMessage());
        }
    }


}
