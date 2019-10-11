package ui;

import exceptions.*;
import model.*;


import java.io.FileNotFoundException;
import java.io.IOException;
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
        main.welcomeStatement("2.0");
        while (runProgram) {
            try {
                main.pickSampleType();
            } catch (InvalidSampleMediaException | IOException e) {
//                e.printStackTrace();
                System.out.println("Please enter a valid sample type.");
            } finally {
                System.out.println("Goodbye!");
            }
        }
    }


    //EFFECTS: prints welcome statement and indicates current version of the program
    private void welcomeStatement(String version) {
        System.out.println("Welcome to Sample Log Generator v." + version + "!");
//        System.out.println("Type 'quit' to end at any time.");
    }


    private void pickSampleType() throws InvalidSampleMediaException, IOException {
        System.out.println("Which sample type would you like to access?");
        System.out.println("[1] Soil [2] Water");
        String str;
        str = input.nextLine();
        if (str.equals("1")) {
            this.sampleType = "soil";
        } else if (str.equals("2")) {
            this.sampleType = "water";
        } else {
            throw new InvalidSampleMediaException();
        }
        initiateLog();
    }


//    private void invalidSampleInput() throws InvalidUserInputException {
////        System.out.println("Sorry, I didn't understand. Please pick a sample type.");
//        pickSampleType();
//    }


    //EFFECTS: prints user options to begin application, or quit application
    private void initiateLog() throws IOException {
        String type;
        if (this.sampleType.equals("soil")) {
            type = "borehole log";
        } else {
            type = "water log";
        }
        printMainMenu(type);
        try {
            handleUserInput();
        } catch (InvalidSampleMediaException e) {
//            e.printStackTrace();
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
    private void handleUserInput() throws IOException, InvalidSampleMediaException, InvalidInputException {
//        while (true) {
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
//    }

    private boolean numAnswer(String str) throws IOException {

        if (this.sampleType.equals("soil")) {
            if (str.equals("1")) {
                optionOneSoil();
            } else if (str.equals("2")) {
                optionTwoSoil();
            } else if (str.equals("3")) {
                optionThreeSoil();
            }
        } else if (str.equals("1")) {
            optionOneWater();
        } else if (str.equals("2")) {
            optionTwoWater();
        } else if (str.equals("3")) {
            optionThreeWater();
        }
        return false;
    }

    private void optionThreeWater() throws IOException {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < waterLog.logSize(); i++) {

            if (waterLog.getSample(i).getName().equals(deleteId)) {
                waterLog.removeSample(i);
                System.out.println("You successfully removed a sample.");
                System.out.println("The remaining sample(s) is/are:");
                waterLog.printLog();
            } else System.out.println("sample not found");
            initiateLog();
            break;
        }
    }


    private void optionOneWater() throws IOException {
        waterSample1 = new WaterSample();
        addName();
        addType();
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


    private void saveAnswer(String str) throws IOException {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        if (this.sampleType.equals("soil")) {
            boreholeLog.save(fileToSave);
            initiateLog();
        } else {
            waterLog.save(fileToSave);
        }
        initiateLog();
    }

    private void loadAnswer(String str) throws IOException {
        System.out.println("Please enter the name of the file you would like to load.");
        Scanner loadName = new Scanner(System.in);
        String fileToLoad = loadName.nextLine();
        if (this.sampleType.equals("soil")) {
            try {
                boreholeLog.load(fileToLoad);
            } catch (FileNotFoundException e) {
//                e.printStackTrace();
                System.out.println("Sorry, that file cannot be found.");
            }
            initiateLog();
        } else {
            try {
                waterLog.load(fileToLoad);
            } catch (FileNotFoundException e) {
//                e.printStackTrace();
                System.out.println("Sorry, that file cannot be found.");
            }
            initiateLog();
        }
    }


    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void optionOneSoil() throws IOException {
        soilSample1 = new SoilSample();
        addName();
        addColour();
        addType();
        hasOdour();
        boreholeLog.addSample(soilSample1);
        System.out.println("You successfully added the entry: [" + soilSample1.toString() + "].");
        initiateLog();
    }

    //EFFECTS: prints list of samples currently logged
    private void optionTwoSoil() throws IOException {
        System.out.println("This borehole log has " + boreholeLog.logSize() + " samples.");
        boreholeLog.printLog();
        initiateLog();
    }

    //EFFECTS: prints list of samples currently logged
    private void optionTwoWater() throws IOException {
        System.out.println("This water log has " + waterLog.logSize() + " samples.");
        waterLog.printLog();
        initiateLog();
    }

    //MODIFIES: this
    //EFFECTS: removes sample from borehole log based on sample id user inputted
    private void optionThreeSoil() throws IOException {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < boreholeLog.logSize(); i++) {
            if (boreholeLog.getSample(i).getName().equals(deleteId)) {
                boreholeLog.removeSample(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining sample(s) is/are:");
        boreholeLog.printLog();
        initiateLog();
    }


//    //EFFECTS: prints error statement when user does not input a valid response
//    private void invalidInput() throws IOException  {
//        System.out.println("Sorry, I didn't understand. Please try a different command.");
//        initiateLog();
//    }


    //MODIFIES: this, Sample
    //EFFECTS: sets new sample name based on user input
    private void addName() {
        checkType();
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        if (checkUnique(sampleData, log)) {
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


    private void checkType() {
        if (this.sampleType.equals("soil")) {
            log = boreholeLog;
            sample = soilSample1;
        } else {
            log = waterLog;
            sample = waterSample1;
        }
    }


//
////                    e.printStackTrace();
//                System.out.println("Please enter a unique name.");
//                addName();
////            } else
////        {
////            waterSample1.setName(sampleData.nextLine());
//        }
//    }

    private boolean checkUnique(String testString, Log log) {
        for (int i = 0; i < log.logSize(); i++) {
            if (testString.equals(log.getSample(i).getName())) {
                return false;
            }
        }
        return true;
    }


    //MODIFIES: this, Sample
//EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    private void hasOdour() {
        Sample tempSample;
        if (this.sampleType.equals("soil")) {
            tempSample = soilSample1;
        } else {
            tempSample = waterSample1;
        }

        System.out.println("Is the sample odourous?");
        Scanner input = new Scanner(System.in);
        String contaminated = input.nextLine();
        if (contaminated.equals("yes")) {
            tempSample.setOdour(true);
        } else if (contaminated.equals("no")) {
            tempSample.setOdour(false);
//        } else {
//            try {
//                throw new YesOrNoException();
//            } catch (YesOrNoException e) {
////                e.printStackTrace();
//                System.out.println("'Yes' or 'no' is required.");
//                hasOdour();
        } else {
            yesOrNoRequired();
        }
    }


    private void checkSampleType() {
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
        if (str.equals("blue")) {
            soilSample1.setColour("blue");
        } else if (str.equals("grey")) {
            soilSample1.setColour("grey");
        } else if (str.equals("brown")) {
            soilSample1.setColour("brown");
        } else {
            invalidColour();
        }
    }


    //EFFECTS: prompts user to input a valid colour option
    private void invalidColour() {
        System.out.println("Please enter a valid colour.");
        addColour();
    }

    private void addType() {
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
        if (str.equals("groundwater")) {
            waterSample1.setType("groundwater");
        } else if (str.equals("surface water")) {
            waterSample1.setType("surface water");
        } else {
            try {
                throw new InvalidTypeException();
            } catch (InvalidTypeException e) {
//                e.printStackTrace();
                System.out.println("Please enter a valid type");
                addWaterType();
            }
        }
    }


    //MODIFIES: this, Sample
//EFFECTS: sets sample type to silt, sand, or gravel
    private void addSoilType() {
        System.out.println("Is the sample silt, sand, or gravel?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str.equals("silt")) {
            soilSample1.setType("silt");
        } else if (str.equals("sand")) {
            soilSample1.setType("sand");
        } else if (str.equals("gravel")) {
            soilSample1.setType("gravel");
        } else {
            try {
                throw new InvalidTypeException();
            } catch (InvalidTypeException e) {
//                e.printStackTrace();
                System.out.println("Please enter a valid type");
                addSoilType();
            }

        }
    }
//    }

    //EFFECTS: limits sample type to silt, sand, or gravel
    private void invalidType() {
        System.out.println("Please enter a valid type.");
        addType();
    }


}


