package internet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// construct http client
// make http request (GET request) with client
// run synchronous request API

public class Map {
    private HttpURLConnection connection = null;
    private JSONObject jsonObject = null;

    public Map() {

    }


    //method modified from source: https://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java
    public String getJSONresponse() {
        try {
            //Create connection

            URL url = new URL("https://api.mapbox.com/geocoding/v5/mapbox.places/Los%20Angeles.json?access_token=pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMWNsaTYwMDZwM2NtenJkMTRibTczIn0.ZJMCmrHKmy7K_ONrKamwqA");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
//
//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
//            connection.setRequestProperty("Content-Language", "en-US");
//
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);

//            //Send request
//            DataOutputStream wr = new DataOutputStream(
//                    connection.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response.toString());
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

    public JSONObject createJSON(String response) {
//        JSONObject jsonObject = null;
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

