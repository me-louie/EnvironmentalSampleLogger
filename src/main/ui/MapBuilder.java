package ui;

import java.util.Scanner;

public class MapBuilder {
    private String token =
            "access_token=pk.eyJ1IjoibWVsb3VpZSIsImEiOiJjazJvMWNsaTYwMDZwM2NtenJkMTRibTczIn0.ZJMCmrHKmy7K_ONrKamwqA";
    private String mapboxAPI = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    private String query = "ubc";
    private String bbox = "bbox=-123.28965644634036,49.181803990270794,-122.97949367449506,49.322155168068576";
    private static String searchURL = "";


    MapBuilder() {

    }

    public void enterMapAddress() {
        System.out.println("Please enter an address.");
        Scanner input = new Scanner(System.in);
        this.query = input.nextLine();
    }
}
