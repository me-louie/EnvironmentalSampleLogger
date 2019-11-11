package internet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

// construct http client
// make http request (GET request) with client
// run synchronous request API

public class SiteMap {
    private HttpURLConnection connection = null;
    private JSONObject jsonObject = null;
    private StringBuilder response = null;
    private String line;


    public SiteMap() {


    }


    //url with bbox "https://api.mapbox.com/geocoding/v5/mapbox.places/starbucks.json?bbox=-77.083056,38.908611,-76.997778,38.959167&access_token=pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMTlmNHUwMDV0M3BtemRmeTFveGRiIn0.PnKZ_-j1wONn43DnbtzShw"


    //method modified from source: https://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java
    public String getJsonResponse() {
        try {
            //Create connection
//            URL url = new URL(
//                    "https://api.mapbox.com/geocoding/v5/mapbox.places/ubc.json?bbox=-123.28965644634036,
//                    49.181803990270794,-122.97949367449506,49.322155168068576&access_token
//                    =pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMTlmNHUwMDV0M3BtemRmeTFveGRiIn0.PnKZ_-j1wONn43DnbtzShw");
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
            createConnection();
            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
//            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    //"https://api.mapbox.com/geocoding/v5/mapbox.places/ubc.json?bbox=-123.28965644634036,49.181803990270794,-122.97949367449506,49.322155168068576&access_token=pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMTlmNHUwMDV0M3BtemRmeTFveGRiIn0.PnKZ_-j1wONn43DnbtzShw"

    private void createConnection() throws IOException {
        String website = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
        String query = "ubc";
        String bbox = ".json?bbox=-123.28965644634036,49.181803990270794,-122.97949367449506,49.322155168068576&";
        String accessToken = "access_token=";
        String token = "pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMTlmNHUwMDV0M3BtemRmeTFveGRiIn0.PnKZ_-j1wONn43DnbtzShw";
        String buildURL = website + query + bbox + accessToken + token;
        URL url = new URL(buildURL);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
    }



    public JSONObject createJson(String response) {
        try {
            this.jsonObject = new JSONObject(response);
        } catch (JSONException err) {
            System.out.println("Invalid response.");
        }
        return this.jsonObject;
    }


    public String parseCoordinates(JSONObject json) throws JSONException {
        JSONArray myObj;
        myObj = this.jsonObject.getJSONArray("features");

        JSONObject features;
        features = myObj.getJSONObject(0);

        JSONObject geometry;
        geometry = features.getJSONObject("geometry");


        JSONArray coordinates;
        coordinates = geometry.getJSONArray("coordinates");
        System.out.println(coordinates.toString());

        return coordinates.toString();
    }
}
//
//    String map =
//            "https://api.mapbox.com/geocoding/v5/mapbox.places/Los%20Angeles.json?access_token=pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMWNsaTYwMDZwM2NtenJkMTRibTczIn0.ZJMCmrHKmy7K_ONrKamwqA";
//    URL url = new URL(map);
//    map.parse();

//check JSON library . see if i can convert string into json objet
// use json library to parse the data i want
// take that data and next query to get map
//check what format the map is in
//may need to convert to jpeg or png


//read documentation for json parsing

