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

    Menu() {
        ProjectInfoBuilder projectData = new ProjectInfoBuilder();
        projectData.createProject();

        printer.welcomeStatement("4.0");

        while (runProgram) {
            pickSampleTypeMenu();
            System.out.println("Goodbye!");
        }
    }


    //MODIFIES: this
    //EFFECTS: sets sampleType to soil if user selects 1 or sets sampleType to water if user selects 2
    private void pickSampleTypeMenu() {
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
                pickSampleTypeMenu();
            }
        }
        runLogMenu();
    }

    //EFFECTS: initiates application
    private void runLogMenu() {
        printer.printMainMenu(log.getType());
        try {
            handleUserInputMenu();
        } catch (InvalidInputException | SampleNameAlreadyUsedException e) {
            System.out.println("Please enter a valid command");
        }
    }


    //TODO: work on waterlog load capabilities
    //EFFECTS: provides application options based on user input
    private void handleUserInputMenu() throws InvalidInputException, SampleNameAlreadyUsedException {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (isNumeric(str)) {
            addViewDeleteSample(str);
        } else if (str.equals("save")) {
            saveAnswer();
        } else if (str.equals("load")) {
            loadAnswer();
        } else if (str.equals("return")) {
            pickSampleTypeMenu();
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
    private void addViewDeleteSample(String str) {
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
        SoilSampleBuilder ssb = new SoilSampleBuilder();
        log.addSoilSampleToLog(ssb.addSampleID(), ssb.addColour(),
                ssb.addSoilType(), ssb.hasOdour());
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
        WaterSampleBuilder wsb = new WaterSampleBuilder();
        log.setHashMap(wsb.addSampleID(), wsb.buildHashArray());
        runLogMenu();
    }


}





