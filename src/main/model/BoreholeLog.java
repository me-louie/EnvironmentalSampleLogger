package model;

import ui.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoreholeLog implements Saveable, Loadable {
    private List<SoilSample> boreholeLog;
    private SoilSample soilSample1 = new SoilSample();



    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        boreholeLog = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a new sample to the borehole log
    private void optionOne() {
        soilSample1 = new SoilSample();
//        addName();
//        addColour();
//        addType();
//        hasOdour();
        boreholeLog.add(soilSample1);
        System.out.println("You successfully added the entry: [" + soilSample1.toString() + "].");
        Menu.initiateApplication();
    }

    //EFFECTS: prints list of samples currently logged
    private void optionTwo() {
        System.out.println("This borehole log has " + bhLogSize() + " samples.");
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


    //EFFECTS: returns size of list
    public Integer bhLogSize() {
        return boreholeLog.size();
    }


    //EFFECTS: returns list of samples which are odourous
    public List<SoilSample> returnContaminatedSamples() {
        List<SoilSample> contaminated = new ArrayList<>();

        for (SoilSample soilSample : boreholeLog) {
            if (soilSample.isOdourous()) {
                contaminated.add(soilSample);
            }
        }
        return contaminated;
    }

    //EFFECTS: adds a sample to borehole log
    public void addSample(SoilSample soilSample) {
        boreholeLog.add(soilSample);
    }



    @Override
    //EFFECTS: writes borehole log data to txt file
    public void save(String fileSaveName) throws IOException {
        File fileName = new File(fileSaveName);
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (SoilSample soilSample : boreholeLog) {
            pw.println(soilSample.getName());
            pw.println(soilSample.getColour());
            pw.println(soilSample.getType());
            pw.println(soilSample.isOdourous());
        }
        pw.close();
        System.out.println("File " + fileName + " was saved.");
        Menu.initiateApplication();

    }

    @Override
    //MODIFIES: this
    //EFFECTS: loads borehole log data saved in .txt file
    public void load(String fileLoadName) throws FileNotFoundException {
        File file = new File(fileLoadName);
        FileInputStream fis = new FileInputStream(file);
        Scanner in = new Scanner(fis);

        while (in.hasNext()) {
            SoilSample soilSample1 = new SoilSample();
            soilSample1.setName(in.nextLine());
            soilSample1.setColour(in.nextLine());
            soilSample1.setType(in.nextLine());
            soilSample1.setOdour((in.nextLine().equals("true")));
            boreholeLog.add(soilSample1);
        }
        System.out.println(file + " data has been loaded.");
    }

    private void saveAnswer(String str) throws IOException {
        System.out.println("Please enter a new file name.");
        Scanner saveName = new Scanner(System.in);
        String fileToSave = saveName.nextLine();
        save(fileToSave);
    }

    private void loadAnswer(String str) throws FileNotFoundException {
        System.out.println("Please enter the name of the file you would like to load.");
        Scanner loadName = new Scanner(System.in);
        String fileToLoad = loadName.nextLine();
        load(fileToLoad);
    }

    //EFFECTS: returns sample from borehole log at specified index
    public SoilSample getSample(int i) {
        return boreholeLog.get(i);
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
                saveAnswer(str);
            } else if (str.equals("load")) {
                loadAnswer(str);
            } else if (str.equals("quit")) {
                System.out.println("Goodbye.");
                break;
            } else {
                Menu.invalidInput();
            }
        }
    }

}




