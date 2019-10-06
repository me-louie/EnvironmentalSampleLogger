package ui;

import model.*;


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


    String sampleType = " ";

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.welcomeStatement("2.0");
        while (runProgram) {
            main.pickSampleType();
        }
    }


    //EFFECTS: prints welcome statement and indicates current version of the program
    private void welcomeStatement(String version) {
        System.out.println("Welcome to Sample Log Generator v." + version + "!");
//        System.out.println("Type 'quit' to end at any time.");
    }


    private void pickSampleType() throws IOException {
        System.out.println("Which sample type would you like to access?");
        System.out.println("[1] Soil [2] Water");
        String str;
        str = input.nextLine();
        if (str.equals("1")) {
            this.sampleType = "soil";
        } else if (str.equals("2")) {
            this.sampleType = "water";
        } else {
            invalidSampleInput();
        }
        initiateLog();
    }

    private void invalidSampleInput() throws IOException {
        System.out.println("Sorry, I didn't understand. Please pick a sample type.");
        pickSampleType();
    }


    //EFFECTS: prints user options to begin application, or quit application
    private void initiateLog() throws IOException {
        String type;
        if (this.sampleType.equals("soil")) {
            type = "borehole log";
        } else {
            type = "water log";
        }
        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the " + type);
        System.out.println("Press [2] to view the " + type);
        System.out.println("Press [3] to delete an existing sample from the " + type);
        System.out.println("Type 'save' to save your " + type);
        System.out.println("Type 'load' to load a " + type + " from a text file.");
        System.out.println("Type 'return' to return to the main menu.");
        System.out.println("Type 'quit' to end the application.");
        handleUserInput();
    }


    //EFFECTS: provides application options based on user input
    private void handleUserInput() throws IOException {
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
            System.out.println("Goodbye.");
            runProgram = false;
//                break;
        } else {
            invalidInput();
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

        for (int i = 0; i < waterLog.wlSize(); i++) {
            if (waterLog.getSample(i).getName().equals(deleteId)) {
                waterLog.removeSample(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining sample(s) is/are:");
        waterLog.printLog();
        initiateLog();
    }


//        if (str.equals("1")
//                && this.sampleType.equals("soil")) {
//            optionOneSoil();
//        } else if (str.equals("1")
//                && this.sampleType.equals("water")) {
//            optionOneWater();
//        } else if (str.equals("2")) {
//            optionTwo();
//        } else if (str.equals("3")) {
//            optionThree();
//        }
//        return false;
//}

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
            boreholeLog.load(fileToLoad);
            initiateLog();
        } else {
            waterLog.load(fileToLoad);
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
        System.out.println("This borehole log has " + boreholeLog.bhSize() + " samples.");
        boreholeLog.printLog();
        initiateLog();
    }

    //EFFECTS: prints list of samples currently logged
    private void optionTwoWater() throws IOException {
        System.out.println("This water log has " + waterLog.wlSize() + " samples.");
        waterLog.printLog();
        initiateLog();
    }

    //MODIFIES: this
    //EFFECTS: removes sample from borehole log based on sample id user inputted
    private void optionThreeSoil() throws IOException {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < boreholeLog.bhSize(); i++) {
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


    //EFFECTS: prints error statement when user does not input a valid response
    private void invalidInput() throws IOException {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        initiateLog();
    }


    //MODIFIES: this, Sample
    //EFFECTS: sets new sample name based on user input
    private void addName() {
        System.out.println("Please enter a new sample id.");
        Scanner sampleData = new Scanner(System.in);
        if (this.sampleType.equals("soil")) {
            soilSample1.setName(sampleData.nextLine());
        } else {
            waterSample1.setName(sampleData.nextLine());
        }
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
//        while (true) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str.equals("blue")) {
            soilSample1.setColour("blue");
//                break;
        } else if (str.equals("grey")) {
            soilSample1.setColour("grey");
//                break;
        } else if (str.equals("brown")) {
            soilSample1.setColour("brown");
//                break;
        } else {
            invalidColour();
//                break;
        }
    }
//    }

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
            invalidType();
        }
    }


    //MODIFIES: this, Sample
    //EFFECTS: sets sample type to silt, sand, or gravel
    private void addSoilType() {
        System.out.println("Is the sample silt, sand, or gravel?");
//        while (true) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str.equals("silt")) {
            soilSample1.setType("silt");
//                break;
        } else if (str.equals("sand")) {
            soilSample1.setType("sand");
//                break;
        } else if (str.equals("gravel")) {
            soilSample1.setType("gravel");
//                break;
        } else {
            invalidType();
//                break;
        }
    }
//    }

    //EFFECTS: limits sample type to silt, sand, or gravel
    private void invalidType() {
        System.out.println("Please enter a valid type.");
        addType();
    }
}


