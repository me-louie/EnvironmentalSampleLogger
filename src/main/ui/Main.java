package ui;



import internet.SiteMap;
import org.json.JSONException;

public class Main {

    public static void main(String[] args) throws JSONException {
        SiteMap map = new SiteMap();

        map.parseCoordinates(map.createJson(map.getJsonResponse()));

        Menu menu = new Menu();



    }
}





