package ui;


import java.util.Scanner;

class SoilSampleBuilder extends SampleBuilder {

    //MODIFIES: this
    //EFFECTS: constructs new SoilSampleBuilder
    SoilSampleBuilder() {

    }

    //MODIFIES: this, sample
    //EFFECTS: sets sample colour to grey, blue, or brown and returns the colour
    String addColour() {
        String str = "invalid colour";
        while (!checkValidSoilColour(str)) {
            System.out.println("Is the sample grey, blue, or brown?");
            Scanner input = new Scanner(System.in);
            String colour = input.nextLine();
            if (checkValidSoilColour(colour)) {
                return colour;
            } else {
                System.out.println("Please enter a valid colour.");
            }
        }
        return str;
    }


    //MODIFIES: this, Sample
    //EFFECTS: sets sample type to silt, sand, or gravel
    String addSoilType() {
        String str = "invalid type";

        while (!checkValidSoilType(str)) {
            System.out.println("Is the sample silt, sand, or gravel?");
            Scanner input = new Scanner(System.in);
            String type = input.nextLine();
            if (checkValidSoilType(type)) {
                return type;
            } else {
                System.out.println("Please enter a valid type");
            }
        }
        return str;
    }


    //MODIFIES: Sample
    //EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    boolean hasOdour() {
        boolean runLoop = false;
        boolean hasOdour = false;
        while (!runLoop) {
            System.out.println("Is the sample odourous?");
            Scanner input = new Scanner(System.in);
            String odour = input.nextLine();
            if (odour.equals("yes")) {
                hasOdour = true;
                runLoop = true;
            } else if (odour.equals("no")) {
                runLoop = true;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
        return hasOdour;
    }

    private boolean checkValidSoilType(String str) {
        return (str.equals("sand")
                || str.equals("silt")
                || str.equals("gravel"));
    }

    private boolean checkValidSoilColour(String str) {
        return (str.equals("blue")
                || str.equals("grey")
                || str.equals("brown"));
    }
}
