package ui;


import exceptions.InvalidSoilTypeException;

import javax.swing.*;
import java.util.Scanner;

class SoilSampleBuilder extends SampleBuilder {

    SoilSampleBuilder() {

    }

    //MODIFIES: this, sample
    //EFFECTS: sets sample colour to grey, blue, or brown
    String addColour() {
        System.out.println("Is the sample grey, blue, or brown?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
//        try {
//            soilSample1.setSoilColour(soilSample1, str);
//        } catch (InvalidSoilColourException e) {
//            System.out.println(e.getMessage());
//            addColour();
//        }

        return str;
    }


    //MODIFIES: this, Sample
    //EFFECTS: sets sample type to silt, sand, or gravel
    String addSoilType() {
        String str = "didntwork";

        //surround in while.. while not valid, keep going
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

    private boolean checkValidSoilType(String str) {
        return (str.equals("sand")
                || str.equals("silt")
                || str.equals("gravel"));
    }

    private boolean checkValidSoilColour(String str) {
        return (str.equals("blue")
                || str.equals("grey")
                || str.equals("brown"));
//        } else {
//            throw new InvalidSoilTypeException("Please enter a valid colour.");
    }


    //MODIFIES: Sample
    //EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    boolean hasOdour() {
        System.out.println("Is the sample odourous?");
        Scanner input = new Scanner(System.in);
        String contaminated = input.nextLine();
        boolean hasOdour = false;
        if (contaminated.equals("yes")) {
            hasOdour = true;
        }
//        try {
//            sample.setIsSampleOdourous(sample, contaminated);
//        } catch (YesOrNoInputException e) {
//            System.out.println(e.getMessage());
//            hasOdour();
        return hasOdour;
    }
}
