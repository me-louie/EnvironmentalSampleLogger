package model;

import javax.lang.model.element.Element;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BoreholeLog implements Saveable, Loadable {
    private List<Sample> boreholeLog;
    private Sample sample1 = new Sample();



    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        boreholeLog = new ArrayList<>();

    }


    //EFFECTS: provides application options based on user input
    public void handleUserInput() throws IOException {
        while (true) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            if (str.equals("1")
                    || str.equals("2")
                    || str.equals("3")) {
                numAnswer(str);
            } else if (str.equals("save")) {
                save();
            } else if (str.equals("load")) {
                load();
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

    //MODIFIES: this, Sample
    //EFFECTS: sets new sample name based on user input
    private void addName() {
        System.out.println("Please enter a new sample id.");
        Scanner sampleData = new Scanner(System.in);
        sample1.setName(sampleData.nextLine());

    }

    //MODIFIES: this, Sample
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


    //MODIFIES: this, sample
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

    //MODIFIES: this, Sample
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


    //EFFECTS: returns size of list
    public Integer size() {
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

    //EFFECTS: adds a sample to borehole log
    public void addSample(Sample sample) {
        boreholeLog.add(sample);
    }

    //EFFECTS: limits sample type to silt, sand, or gravel
    private void invalidType() {
        System.out.println("Please enter a valid type.");
        addType();
    }

    @Override
    //EFFECTS: writes Sample data to txt file
    public void save() throws IOException {
        File fileName = new File("Borehole Log.txt");
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (Sample sample : boreholeLog) {
            pw.println(sample.getName());
            pw.println(sample.getType());
            pw.println(sample.getColour());
            pw.println(sample.isOdourous());
//            pw.println("ID: " + boreholeLog.get(i).getName());
//            pw.println("Type:  " + boreholeLog.get(i).getType());
//            pw.println("Colour: " + boreholeLog.get(i).getColour());
//            pw.println("Odourous?: " + boreholeLog.get(i).isOdourous());
        }
        pw.close();
        System.out.println("File " + fileName + " was saved.");
        Menu.initiateApplication();

    }

    @Override
    //EFFECTS: loads Sample data saved in .txt file
    public void load() throws FileNotFoundException {
        File fileName = new File("Borehole Log.txt");
        FileInputStream fis = new FileInputStream(fileName);
        Scanner in = new Scanner(fis);

        while (in.hasNext()) {
            Sample sample1 = new Sample();
            sample1.setName(in.nextLine());
            sample1.setType(in.nextLine());
            sample1.setColour(in.nextLine());
            sample1.setOdour((in.nextLine().equals("true")));
            boreholeLog.add(sample1);
        }
        System.out.println(fileName + " data has been loaded.");


    }

}




