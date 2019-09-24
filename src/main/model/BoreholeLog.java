package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoreholeLog {
    private List<Sample> boreholeLog;
    private Sample sample1 = new Sample();

    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        boreholeLog = new ArrayList<>();

    }

    //EFFECTS: provides application options based on user input
    public void handleUserInput() {
        String str = "";
        while (true) {
            Scanner input = new Scanner(System.in);
            str = input.nextLine();
            if (str.equals("1")) {
                optionOne();
            } else if (str.equals("2")) {
                optionTwo();
            } else if (str.equals("3")) {
                optionThree();
            } else if (!str.equals("quit")) {
                invalidInput();
            }
            if (str.equals("quit")) {
                System.out.println("Goodbye.");
                break;
            }
        }
    }


    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void optionOne() {
        sample1 = new Sample();
        addName();
        addColour();
        addType();
        hasOdour();
        boreholeLog.add(sample1);
        System.out.println("You successfully added the entry: [" + sample1.toString() + "].");
        Menu.initiateApplication();
    }

    private void addName() {
        System.out.println("Please enter a new sample id.");
        Scanner sampleData = new Scanner(System.in);
        sample1.setName(sampleData.nextLine());

    }

    //EFFECTS: sets sample odour to true if the sample is odourous, otherwise false
    private void hasOdour() {
        System.out.println("Is the sample odourous?");
        Scanner input = new Scanner(System.in);
        String contaminated = input.nextLine();
        if (contaminated.equals("yes")) {
            sample1.setOdour(true);
        } else if (contaminated.equals("no")) {
            sample1.setOdour(false);
        } else {
            yesOrNoRequired();
        }
    }

    //EFFECTS: prompts user for yes or not input
    private void yesOrNoRequired() {
        System.out.println("Sorry, I don't understand.");
        hasOdour();
    }


    //EFFECTS: sets sample colour to grey, blue, or brown
    private void addColour() {
        System.out.println("Is the sample grey, blue, or brown?");
        while (true) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("blue")) {
                sample1.setColour("blue");
                break;
            } else if (str.equals("grey")) {
                sample1.setColour("grey");
                break;
            } else if (str.equals("brown")) {
                sample1.setColour("brown");
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

    //EFFECTS: sets sample type to silt, sand, or gravel
    private void addType() {
        System.out.println("Is the sample silt, sand, or gravel?");
        while (true) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("silt")) {
                sample1.setType("silt");
                break;
            } else if (str.equals("sand")) {
                sample1.setType("sand");
                break;
            } else if (str.equals("gravel")) {
                sample1.setType("gravel");
                break;
            } else {
                invalidType();
                break;
            }
        }
    }

    //EFFECTS: prints list of samples currently logged
    private void optionTwo() {
        System.out.println("This borehole log has " + size() + " samples.");
        System.out.println(boreholeLog);
        Menu.initiateApplication();
    }

    //MODIFIES: this
    //EFFECTS: removes sample from borehole log based on sample id user inputted
    private void optionThree() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < boreholeLog.size(); i++) {
            if (boreholeLog.get(i).getName().equals(deleteId)) {
                boreholeLog.remove(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining samples are:" + boreholeLog);
        Menu.initiateApplication();
    }


    //EFFECTS: prints error statement when user does not input a valid response
    private void invalidInput() {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        Menu.initiateApplication();
    }

    //EFFECTS: returns number of samples in the borehole log
    private Integer size() {
        return boreholeLog.size();
    }

    //EFFECTS: returns list of samples which are odourous
    public List<Sample> returnContaminatedSamples() {
        List<Sample> contaminated = new ArrayList<>();

        for (Sample sample : boreholeLog) {
            if (sample.isOdourous()) {
                contaminated.add(sample);
            }
        }
        return contaminated;
    }

    public void addSample(Sample sample) {
        boreholeLog.add(sample);
    }

    //EFFECTS: limits sample type to silt, sand, or gravel
    private void invalidType() {
        System.out.println("Please enter a valid type.");
        addType();
    }
}


