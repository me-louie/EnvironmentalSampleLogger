package ui;

import exceptions.*;
import model.*;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidSampleMediaException;
import ui.exceptions.SampleDoesNotExistException;
import ui.exceptions.SampleNameAlreadyUsedException;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static boolean runProgram = true;

    private SoilSample soilSample1 = new SoilSample();
    private BoreholeLog boreholeLog = new BoreholeLog();

    private Scanner input = new Scanner(System.in);

    private WaterSample waterSample1 = new WaterSample();
    private WaterLog waterLog = new WaterLog();

    private Log log;
    private Sample sample;


    private String sampleType = " ";

    public static void main(String[] args) {
        Main main = new Main();
        main.welcomeStatement("3.0");
        while (runProgram) {
            main.pickSampleType();
            System.out.println("Goodbye!");
        }
    }


    //EFFECTS: prints welcome statement and indicates current version of the program
    private void welcomeStatement(String version) {
        System.out.println("Welcome to Sample Log Generator v." + version + "!");
//        System.out.println("Type 'quit' to end at any time.");
    }

    //MODIFIES: this
    //EFFECTS: sets sampleType to soil if user selects 1 or sets sampleType to water if user selects 2
    private void pickSampleType() {
        System.out.println("Which sample type would you like to access?");
        System.out.println("[1] Soil [2] Water");
        String str;
        str = input.nextLine();
        if (str.equals("1")) {
            this.sampleType = "soil";
        } else if (str.equals("2")) {
            this.sampleType = "water";
        } else {
            try {
                throw new InvalidSampleMediaException();
            } catch (InvalidSampleMediaException e) {
//                e.printStackTrace();
                System.out.println("Please pick a valid type.");
                pickSampleType();
            }
        }
        initiateLog();
    }


    //EFFECTS: prints user options to begin application, or quit application
    private void initiateLog() {
        String type;
        if (this.sampleType.equals("soil")) {
            type = "borehole log";
        } else {
            type = "water log";
        }
        printMainMenu(type);
        try {
            handleUserInput();
        } catch (InvalidInputException e) {
//            e.printStackTrace();
            System.out.println("Please enter a valid command.");
            initiateLog();
        }
    }

    private void printMainMenu(String type) {
        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the " + type);
        System.out.println("Press [2] to view the " + type);
        System.out.println("Press [3] to delete an existing sample from the " + type);
        System.out.println("Type 'save' to save your " + type);
        System.out.println("Type 'load' to load a " + type + " from a text file.");
        System.out.println("Type 'return' to return to the main menu.");
        System.out.println("Type 'quit' to end the application.");
    }


    //EFFECTS: provides application options based on user input
    private void handleUserInput() throws InvalidInputException {
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
        } else if (str.equals("return")) {
            pickSampleType();
        } else if (str.equals("quit")) {
            runProgram = false;
        } else {
            throw new InvalidInputException();
        }
    }


    private boolean numAnswer(String str) {

        if (str.equals("2")) {
            viewExistingLog();
        } else if (str.equals("3")) {
            tryDeleteSample();
        } else if (str.equals("1")
                && sampleType.equals("soil")) {
            addSoilSample();
        } else if (str.equals("1")
                && sampleType.equals("water")) {
            addWaterSample();
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: removes sample from borehole log based on sample id user inputted
    private void tryDeleteSample() {
        checkSampleType();
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        if (log.isSampleIDUnique(deleteId)) {
            try {
                throw new SampleDoesNotExistException();
            } catch (SampleDoesNotExistException e) {
                System.out.println("Sorry, that sample does not exist.");
                tryDeleteSample();
            }
        }
        log.removeSampleFromLog(log, deleteId);
        initiateLog();
    }


    private void addWaterSample() {
        waterSample1 = new WaterSample();
        addName();
        addSampleType();
        hasOdour();
        addConductivity();
        addTemperature();
        addTurbidity();
        waterLog.addSample(waterSample1);
        System.out.println("You successfully added the entry: [" + waterSample1.toString() + "].");
        initiateLog();
    }

    private void addConductivity() {
        System.out.println("Please enter the sample conductivity.");
        Scanner sampleData = new Scanner(System.in);
        waterSample1.setConductivity(sampleData.nextLine());
//need to restrict inputs to numbers
    }

    private void addTemperature() {
        System.out.println("Please enter the sample temperature.");
        Scanner sampleData = new Scanner(System.in);
        waterSample1.setTemperature(sampleData.nextLine());
    }

    private void addTurbidity() {
        System.out.println("Please enter the sample turbidity.");
        Scanner sampleData = new Scanner(System.in);
        waterSample1.setTurbidity(sampleData.nextLine());
    }


    private void saveAnswer(String str) {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        checkSampleType();
        try {
            log.save(fileToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("That file name is invalid. Please enter a new name.");
            saveAnswer(fileToSave);
            initiateLog();
        } finally {
            System.out.println("...");
        }
    }

    private void loadAnswer(String str) {
        System.out.println("Please enter the name of the file you would like to load.");
        Scanner loadName = new Scanner(System.in);
        String fileToLoad = loadName.nextLine();
        checkSampleType();
        try {
            log.load(fileToLoad);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, that file cannot be found.");

        } finally {
            System.out.println("...");
        }
        initiateLog();
    }


    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void addSoilSample() {
        soilSample1 = new SoilSample();
        addName();
        addColour();
        addSampleType();
        hasOdour();
        boreholeLog.addSample(soilSample1);
        System.out.println("You successfully added the entry: [" + soilSample1.toString() + "].");
        initiateLog();
    }

    //EFFECTS: prints list of samples currently logged
    private void viewExistingLog() {
        checkSampleType();
        System.out.println("This log has " + log.logSize() + " samples.");
        log.printLog();
        initiateLog();
    }


    //MODIFIES: this, Sample
    //EFFECTS: sets new sample name based on user input
    private void addName() {
        checkSampleType();
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        if (log.isSampleIDUnique(sampleData)) {
            sample.setName(sampleData);
        } else {
            try {
                throw new SampleNameAlreadyUsedException();
            } catch (SampleNameAlreadyUsedException e) {
                System.out.println("Sorry, that ID has already been used.");
                addName();
            }
        }
    }


    private void checkSampleType() {
        if (this.sampleType.equals("soil")) {
            log = boreholeLog;
            sample = soilSample1;
        } else {
            log = waterLog;
            sample = waterSample1;
        }
    }


    //MODIFIES: Sample
    //EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    private void hasOdour() {
        checkSampleType();

        System.out.println("Is the sample odourous?");
        Scanner input = new Scanner(System.in);
        String contaminated = input.nextLine();
        try {
            sample.setIsSampleOdourous(sample, contaminated);
        } catch (YesOrNoInputException e) {
//            e.printStackTrace();
            System.out.println("A 'yes' or 'no' is required.");
            hasOdour();
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
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        try {
            soilSample1.setSoilColour(soilSample1, str);
        } catch (InvalidSoilColourException e) {
//            e.printStackTrace();
            System.out.println("Please enter a valid colour.");
            addColour();
        }

    }


    //EFFECTS: prompts user to input a valid colour option
    private void invalidColour() {
        System.out.println("Please enter a valid colour.");
        addColour();
    }

    private void addSampleType() {
        if (this.sampleType.equals("soil")) {
            addSoilType();
        } else {
            addWaterType();
        }
    }

    private void addWaterType() {
        System.out.println("Is the sample groundwater or surface water?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        try {
            waterSample1.setWaterSampleType(waterSample1, str);
        } catch (InvalidWaterTypeException e) {
//            e.printStackTrace();
            System.out.println("Please enter a valid sample type.");
            addWaterType();
        }

    }


    //MODIFIES: this, Sample
    //EFFECTS: sets sample type to silt, sand, or gravel
    private void addSoilType() {
        System.out.println("Is the sample silt, sand, or gravel?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        try {
            soilSample1.setSoilType(soilSample1, str);
        } catch (InvalidSoilTypeException e) {
//            e.printStackTrace();
            System.out.println("Please enter a valid type.");
            addSoilType();
        }

    }


    //EFFECTS: limits sample type to silt, sand, or gravel
    private void invalidType() {
        System.out.println("Please enter a valid type.");
        addSampleType();
    }


}


