package ui;

import model.BoreholeLog;
import model.SoilSample;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private SoilSample soilSample1 = new SoilSample();
    private BoreholeLog boreholeLog = new BoreholeLog();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.welcomeStatement("1.0");
        main.initiateApplication();
        main.handleUserInput();
    }


    //EFFECTS: prints welcome statement and indicates current version of the program
    private void welcomeStatement(String version) {
        System.out.println("Welcome to Borehole Log Generator v." + version + "!");
    }

    //EFFECTS: prints user options to begin application, or quit application
    private void initiateApplication() {

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the borehole log.");
        System.out.println("Press [2] to view the borehole log.");
        System.out.println("Press [3] to delete an existing sample from the borehole log.");
        System.out.println("Type 'save' to save your borehole log.");
        System.out.println("Type 'load' to load a borehole from a text file.");
        System.out.println("Type 'quit' to end the application.");
    }


    //EFFECTS: provides application options based on user input
    private void handleUserInput() throws IOException {
        while (true) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("1")
                    || str.equals("2")
                    || str.equals("3")) {
                numAnswer(str);
            } else if (str.equals("save")) {
                saveAnswer(str);
            } else if (str.equals("load")) {
                loadAnswer(str);
            } else if (str.equals("quit")) {
                System.out.println("Goodbye.");
                break;
            } else {
                invalidInput();
            }
        }
    }

    private boolean numAnswer(String str) {
        if (str.equals("1")) {
            optionOne();
        } else if (str.equals("2")) {
            optionTwo();
        } else if (str.equals("3")) {
            optionThree();
        }
        return false;
    }

    private void saveAnswer(String str) throws IOException {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        boreholeLog.save(fileToSave);
    }

    private void loadAnswer(String str) throws FileNotFoundException {
        System.out.println("Please enter the name of the file you would like to load.");
        Scanner loadName = new Scanner(System.in);
        String fileToLoad = loadName.nextLine();
        boreholeLog.load(fileToLoad);
    }

    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void optionOne() {
        soilSample1 = new SoilSample();
//        boreholeLog = boreholeLog;
        addName();
        addColour();
        addType();
        hasOdour();
        boreholeLog.addSample(soilSample1);
        System.out.println("You successfully added the entry: [" + soilSample1.toString() + "].");
        initiateApplication();
    }

    //EFFECTS: prints list of samples currently logged
    private void optionTwo() {
        System.out.println("This borehole log has " + boreholeLog.bhLogSize() + " samples.");
        System.out.println(boreholeLog.toString());
        initiateApplication();
    }

    //MODIFIES: this
    //EFFECTS: removes sample from borehole log based on sample id user inputted
    private void optionThree() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < boreholeLog.bhLogSize(); i++) {
            if (boreholeLog.getSample(i).getName().equals(deleteId)) {
                boreholeLog.removeSample(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining samples are:" + boreholeLog);
        initiateApplication();
    }


    //EFFECTS: prints error statement when user does not input a valid response
    private void invalidInput() {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        initiateApplication();
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


