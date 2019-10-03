package ui;

import model.SoilSample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private SoilSample soilSample1 = new SoilSample();
    private List<SoilSample> boreholeLog;

    //EFFECTS: prints welcome statement and indicates current version of the program
    public static void welcomeStatement(String version) {
        System.out.println("Welcome to Borehole Log Generator v." + version + "!");
    }

    //EFFECTS: prints user options to begin application, or quit application
    public static void initiateApplication() {

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the borehole log.");
        System.out.println("Press [2] to view the borehole log.");
        System.out.println("Press [3] to delete an existing sample from the borehole log.");
        System.out.println("Type 'save' to save your borehole log.");
        System.out.println("Type 'load' to load a borehole from a text file.");
        System.out.println("Type 'quit' to end the application.");
    }




    //EFFECTS: prints error statement when user does not input a valid response
    public static void invalidInput() {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        Menu.initiateApplication();
    }


    //MODIFIES: this, Sample
    //EFFECTS: sets new sample name based on user input
    private void addName() {
        System.out.println("Please enter a new sample id.");
        Scanner sampleData = new Scanner(System.in);
        soilSample1.setName(sampleData.nextLine());

    }

    //MODIFIES: this, Sample
    //EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    private void hasOdour() {
        System.out.println("Is the sample odourous?");
        Scanner input = new Scanner(System.in);
        String contaminated = input.nextLine();
        if (contaminated.equals("yes")) {
            soilSample1.setOdour(true);
        } else if (contaminated.equals("no")) {
            soilSample1.setOdour(false);
        } else {
            yesOrNoRequired();
        }
    }

    //EFFECTS: prompts user for yes or not input
    private void yesOrNoRequired() {
        System.out.println("Sorry, I don't understand.");
        hasOdour();
    }


    //MODIFIES: this, sample
    //EFFECTS: sets sample colour to grey, blue, or brown
    private void addColour() {
        System.out.println("Is the sample grey, blue, or brown?");
        while (true) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("blue")) {
                soilSample1.setColour("blue");
                break;
            } else if (str.equals("grey")) {
                soilSample1.setColour("grey");
                break;
            } else if (str.equals("brown")) {
                soilSample1.setColour("brown");
                break;
            } else {
                invalidColour();
                break;
            }
        }
    }

    //EFFECTS: prompts user to input a valid colour option
    private void invalidColour() {
        System.out.println("Please enter a valid colour.");
        addColour();
    }

    //MODIFIES: this, Sample
    //EFFECTS: sets sample type to silt, sand, or gravel
    private void addType() {
        System.out.println("Is the sample silt, sand, or gravel?");
        while (true) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("silt")) {
                soilSample1.setType("silt");
                break;
            } else if (str.equals("sand")) {
                soilSample1.setType("sand");
                break;
            } else if (str.equals("gravel")) {
                soilSample1.setType("gravel");
                break;
            } else {
                invalidType();
                break;
            }
        }
    }

    //EFFECTS: limits sample type to silt, sand, or gravel
    private void invalidType() {
        System.out.println("Please enter a valid type.");
        addType();
    }




}
