package ui;

import exceptions.InvalidSoilColourException;
import exceptions.InvalidSoilTypeException;
import exceptions.InvalidWaterTypeException;
import exceptions.YesOrNoInputException;
import model.*;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidSampleMediaException;
import ui.exceptions.SampleDoesNotExistException;
import ui.exceptions.SampleNameAlreadyUsedException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintMenu {

    protected SoilSample soilSample1 = new SoilSample();
    protected BoreholeLog boreholeLog = new BoreholeLog();

    protected Scanner input = new Scanner(System.in);

    protected WaterSample waterSample1 = new WaterSample();
    protected WaterLog waterLog = new WaterLog();

    protected Log log;
    protected Sample sample;

    protected String sampleType = " ";


    protected boolean runProgram = true;

    PrintMenu() {
        welcomeStatement("4.0");
        while (runProgram) {
            pickSampleType();
            System.out.println("Goodbye!");
        }
    }

    //EFFECTS: prints welcome statement and indicates current version of the program
    private void welcomeStatement(String version) {
        System.out.println("Welcome to Sample Log Generator v." + version + "!");
//        System.out.println("Type 'quit' to end at any time.");
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
        } catch (InvalidInputException | FileNotFoundException e) {
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
    private void handleUserInput() throws InvalidInputException, FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str.equals("1")
                || str.equals("2")
                || str.equals("3")) {
            numAnswer(str);
        } else if (str.equals("save")) {
            saveAnswer();
        } else if (str.equals("load")) {
            loadAnswer();
        } else if (str.equals("return")) {
            pickSampleType();
        } else if (str.equals("quit")) {
            runProgram = false;
        } else {
            throw new InvalidInputException();
        }
    }

    private void numAnswer(String str) {
        if (str.equals("2")) {
            viewExistingLog();
        }
        if (sampleType.equals("soil")) {
            if (str.equals("3")) {
                tryDeleteSoilSample();
            } else {
                addSoilSample();
            }
        } else {
            if (str.equals("3")) {
                tryDeleteWaterSample();
            } else {
                addWaterSample();
            }
        }
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
                throw new InvalidSampleMediaException("Please pick a valid type.");
            } catch (InvalidSampleMediaException e) {
                System.out.println(e.getMessage());
                pickSampleType();
            }
        }
        initiateLog();
    }

//    void addSampleType() {
//        if (this.sampleType.equals("soil")) {
//            addSoilType();
//        } else {
//            addWaterType();
//        }
//    }

    private void checkSampleType() {
        if (this.sampleType.equals("soil")) {
            log = boreholeLog;
            sample = soilSample1;
        } else {
            log = waterLog;
            sample = waterSample1;
        }
    }


    private void saveAnswer() {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        checkSampleType();
        try {
            log.save(fileToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("That file name is invalid. Please enter a new name.");
            saveAnswer();
        } finally {
            initiateLog();
            System.out.println("...");
        }
    }


    private void saveWaterLog() {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        try {
            waterLog.save(fileToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("That file name is invalid. Please enter a new name.");
            saveAnswer();
            initiateLog();
        } finally {
            System.out.println("...");
        }
    }

    private void loadWaterLog() {
        System.out.println("Please enter the name of the file you would like to load.");
        Scanner loadName = new Scanner(System.in);
        String fileToLoad = loadName.nextLine();
        try {
            log.load(fileToLoad);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, that file cannot be found.");

        } finally {
            System.out.println("...");
        }
        initiateLog();
    }


    private void loadAnswer() {
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
            initiateLog();
        }

    }


    //EFFECTS: prints list of samples currently logged
    private void viewExistingLog() {
        checkSampleType();
        System.out.println("This log has " + log.logSize() + " samples.");
        log.printLog();
        initiateLog();
    }

    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void addSoilSample() {
        soilSample1 = new SoilSample();
        addSoilSampleName();
        addColour();
        addSoilType();
        hasOdour();
        boreholeLog.addSample(soilSample1);
        System.out.println("You successfully added the entry: [" + soilSample1.toString() + "].");
        initiateLog();
    }


    //MODIFIES: this
    //EFFECTS: removes soil sample from borehole log based on sample id user inputted
    private void tryDeleteSoilSample() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();
        if (boreholeLog.isSoilSampleIDUnique(deleteId)) {
            try {
                throw new SampleDoesNotExistException("Sorry, that sample does not exist.");
            } catch (SampleDoesNotExistException e) {
                System.out.println(e.getMessage());
                tryDeleteSoilSample();
            }
        }
        boreholeLog.removeSampleFromBoreholeLog(boreholeLog, deleteId);
        initiateLog();
    }

    //MODIFIES: this, Sample
    //EFFECTS: sets new sample name based on user input
    private void addSoilSampleName() {
//        checkSampleType();
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        if (boreholeLog.isSoilSampleIDUnique(sampleData)) {
            soilSample1.setName(sampleData);
        } else {
            try {
                throw new SampleNameAlreadyUsedException("Sorry, that ID has already been used.");
            } catch (SampleNameAlreadyUsedException e) {
                System.out.println(e.getMessage());
                addSoilSampleName();
            }
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
            System.out.println(e.getMessage());
            hasOdour();
        }
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
            System.out.println(e.getMessage());
            addColour();
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
            System.out.println(e.getMessage());
            addSoilType();
        }

    }

    //MODIFIES: this
    //EFFECTS: removes water sample from water log based on sample id user inputted
    private void tryDeleteWaterSample() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();
        try {
            waterLog.removeSample(deleteId);
        } catch (SampleDoesNotExistException e) {
            System.out.println(e.getMessage());
        } finally {
            initiateLog();
        }
    }

    private void addWaterSample() {
        waterLog.setHashMap(addWaterID(), buildHashArray());
        initiateLog();
    }

    private Integer addWaterTemperature() {
        System.out.println("Please enter the sample temperature.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private Integer addWaterTurbidity() {
        System.out.println("Please enter the sample turbidity.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private Integer addWaterConductivity() {
        System.out.println("Please enter the sample conductivity.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private ArrayList buildHashArray() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(addWaterTemperature());
        data.add(addWaterTurbidity());
        data.add(addWaterConductivity());
        return data;
    }

    private String addWaterID() {
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private void addWaterType() {
        System.out.println("Is the sample groundwater or surface water?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        try {
            waterSample1.setWaterSampleType(waterSample1, str);
        } catch (InvalidWaterTypeException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            addWaterType();
        }

    }
}
