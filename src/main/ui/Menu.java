package ui;

import exceptions.InvalidSoilTypeException;
import model.*;
import ui.exceptions.InvalidInputException;
import ui.exceptions.InvalidSampleMediaException;
import ui.exceptions.SampleDoesNotExistException;
import ui.exceptions.SampleNameAlreadyUsedException;

import java.io.FileNotFoundException;
import java.util.Scanner;

class Menu {

    private Log log;
    private boolean runProgram = true;
    private Printer printer = new Printer();
    private ProjectInfo projectData = new ProjectInfo();

    Menu() {
        printer.welcomeStatement("4.0");

        projectData.createProject();

        while (runProgram) {
            pickSampleType();
            System.out.println("Goodbye!");
        }
    }


    //MODIFIES: this
    //EFFECTS: sets sampleType to soil if user selects 1 or sets sampleType to water if user selects 2
    private void pickSampleType() {
        System.out.println("Which sample type would you like to access?");
        System.out.println("[1] Soil [2] Water");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str.equals("1")) {
            this.log = new BoreholeLog();
        } else if (str.equals("2")) {
            this.log = new WaterLog();
        } else {
            try {
                throw new InvalidSampleMediaException("Please pick a valid type.");
            } catch (InvalidSampleMediaException e) {
                System.out.println(e.getMessage());
                pickSampleType();
            }
        }
        runLogMenu();
    }

    //EFFECTS: initiates application
    private void runLogMenu() {
        printer.printMainMenu(log.getType());
        try {
            handleUserInput();
        } catch (InvalidInputException | SampleNameAlreadyUsedException e) {
            System.out.println("Please enter a valid command");
        }
    }


    //TODO: work on waterlog load capabilities
    //EFFECTS: provides application options based on user input
    private void handleUserInput() throws InvalidInputException, SampleNameAlreadyUsedException {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (isNumeric(str)) {
            addViewDeleteSample(str);
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

    //EFFECTS: returns true if input string is 1, 2, or 3
    private boolean isNumeric(String str) {
        return (str.equals("1")
                || str.equals("2")
                || str.equals("3"));
    }

    //EFFECTS: initiates add, view, or delete sample menu based on user input
    private void addViewDeleteSample(String str) throws SampleNameAlreadyUsedException {
        if (str.equals("2")) {
            viewExistingLog();
        } else if (str.equals("3")) {
            deleteSampleFromLog();
        } else {
            addSampleToLog();
        }
    }


    private void saveAnswer() {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        try {
            log.save(fileToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("That file name is invalid. Please enter a new name.");
            saveAnswer();
        } finally {
            runLogMenu();
            System.out.println("...");
        }
    }


    private void saveWaterLog() {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        try {
            log.save(fileToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("That file name is invalid. Please enter a new name.");
            saveAnswer();
            runLogMenu();
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
        runLogMenu();
    }


    private void loadAnswer() {
        System.out.println("Please enter the name of the file you would like to load.");
        Scanner loadName = new Scanner(System.in);
        String fileToLoad = loadName.nextLine();
        try {
            log.load(fileToLoad);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, that file cannot be found.");
        } finally {
            System.out.println("...");
            runLogMenu();
        }
    }


    //EFFECTS: prints size of log and list of samples currently logged
    private void viewExistingLog() {
        System.out.println("This log has " + log.logSize() + " samples.");
        log.printLog();
        runLogMenu();
    }

    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void addSampleToLog() {
        if (log.getType().equals("borehole log")) {
            addSoilSample();
        } else {
            addWaterSample();
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a new soil sample to this
    private void addSoilSample() {
        log.addSoilSampleToLog(addSampleID(), addColour(), addSoilType(), hasOdour());
        runLogMenu();
    }


    //MODIFIES: this
    //EFFECTS: removes soil sample from borehole log based on sample id user inputted
    private void deleteSampleFromLog() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();
        if (log.isSampleIDUnique(deleteId)) {
            try {
                throw new SampleDoesNotExistException("Sorry, that sample does not exist.");
            } catch (SampleDoesNotExistException e) {
                System.out.println(e.getMessage());
                runLogMenu();
            }
        }
        log.removeSampleFromLog(deleteId);
        runLogMenu();
    }

//    //MODIFIES: this, Sample
////EFFECTS: sets new sample name based on user input
//    private void userSetSampleName() {
//        System.out.println("Please enter a new sample id.");
//        Scanner s = new Scanner(System.in);
//        String sampleData = s.nextLine();
//        if (boreholeLog.isSoilSampleIDUnique(sampleData)) {
//            soilSample1.setName(sampleData);
//        } else {
//            try {
//                throw new SampleNameAlreadyUsedException("Sorry, that ID has already been used.");
//            } catch (SampleNameAlreadyUsedException e) {
//                System.out.println(e.getMessage());
//                userSetSampleName();
//            }
//        }
//    }

    //MODIFIES: Sample
    //EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    private boolean hasOdour() {
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

    //MODIFIES: this, sample
    //EFFECTS: sets sample colour to grey, blue, or brown
    private String addColour() {
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
    private String addSoilType() {
        System.out.println("Is the sample silt, sand, or gravel?");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
//        try {
//            soilSample1.setSoilType(soilSample1, str);
//        } catch (InvalidSoilTypeException e) {
//            System.out.println(e.getMessage());
//            addSoilType();
//        }
        return str;
    }

//    //MODIFIES: this
////EFFECTS: removes water sample from water log based on sample id user inputted
//    private void tryDeleteWaterSample() {
//        System.out.println("Please enter the ID of the sample you would like to delete.");
//        Scanner id = new Scanner(System.in);
//        String deleteId = id.next();
//        try {
//            waterLog.removeSample(deleteId);
//        } catch (SampleDoesNotExistException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            runLogMenu();
//        }
//    }

    private void addWaterSample() {
        log.setHashMap(addSampleID(), buildHashArray());
        runLogMenu();
    }

    private WaterSample buildHashArray() {
        WaterSample waterSample = new WaterSample();
        waterSample.setTemperature(addWaterTemperature());
        waterSample.setTurbidity(addWaterTurbidity());
        waterSample.setConductivity(addWaterConductivity());
        return waterSample;
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


    private String addSampleID() {
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        String id = s.nextLine();
//        if (!log.isSampleIDUnique(id)) {
//            System.out.println("Sorry that id has already been used.");
//            addSampleID();
//        }
        //TODO: ask TA, why when adding a sample with a duplicate name,
        // after the return statement, addSample() is called again?
        return id;
    }


    private boolean checkValidSoilType(String str) throws InvalidSoilTypeException {
        if (str.equals("blue")
                || str.equals("grey")
                || str.equals("brown")) {
            return true;
        } else {
            throw new InvalidSoilTypeException("Please enter a valid colour.");
        }
    }
}





