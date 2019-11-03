package model;


import ui.Printer;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoreholeLog extends Log {
    private List<SoilSample> soilSamples = new ArrayList<>();
    private Printer printer = new Printer();


    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        super();
    }

    //EFFECTS: returns list of samples which are odourous
    public List<SoilSample> returnContaminatedSamples() {
        List<SoilSample> contaminated = new ArrayList<>();

        for (SoilSample soilSample : soilSamples) {
            if (soilSample.isOdourous()) {
                contaminated.add(soilSample);
            }
        }
        return contaminated;
    }

    //MODIFIES: this, SoilSample soilSample
    //EFFECTS: adds soilSample to the borehole log and assigns boreholeLog to soilSample
    public void addSample(SoilSample soilSample) {
        if (!soilSamples.contains(soilSample)) {
            soilSamples.add(soilSample);
            soilSample.setBoreholeLog(this);
        }

    }


    @Override
    //EFFECTS: writes borehole log data to txt file
    public void save(String fileSaveName) throws FileNotFoundException {
        File fileName = new File(String.valueOf(Paths.get("data", "soil", fileSaveName)));
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (SoilSample soilSample : soilSamples) {
            pw.println(soilSample.getName());
            pw.println(soilSample.getColour());
            pw.println(soilSample.getType());
            pw.println(soilSample.isOdourous());
        }
        pw.close();
        System.out.println("File " + fileName + " was saved.");
    }


    @Override
    //MODIFIES: this
    //EFFECTS: loads borehole log data saved in .txt file
    public void load(String fileLoadName) throws FileNotFoundException {
        File file = new File(String.valueOf(Paths.get("data", "soil", fileLoadName)));

        FileInputStream fis = new FileInputStream(file);
        Scanner in = new Scanner(fis);
        List<SoilSample> boreholeLog = new ArrayList<>();
        this.soilSamples = boreholeLog;

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

    //EFFECTS: return soil type
    public String getType() {
        return "borehole log";
    }


    @Override
    //EFFECTS: returns true if id has not been assigned to a sample in the borehole log
    public boolean isSampleIDUnique(String deleteId) {
        return isSoilSampleIDUnique(deleteId);
    }

    //EFFECTS: returns true if id has not been assigned to a sample in the borehole log
    private boolean isSoilSampleIDUnique(String testString) {
        for (int i = 0; i < logSize(); i++) {
            if (testString.equals(getSample(i).getName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    //MODIFIES: this
    //EFFECTS: removes soil sample from the borehole log based on id
    public void removeSampleFromLog(String deleteId) {
        for (int i = 0; i < logSize(); i++) {
            if (getSample(i).getName().equals(deleteId)) {
                removeSample(i);
                break;
            }
        }
        printer.sampleHasBeenDeleted();
        printLog();
    }

    //MODIFIES: this
    //EFFECTS: creates a new soil sample based on user input and adds it to the borehole log
    public void addSoilSampleToLog(String name, String colour, String type, boolean odour) {
        SoilSample soilSample = new SoilSample(name, colour, type, odour, new BoreholeLog());
        addSample(soilSample);
        System.out.println("You successfully added " + name);
    }


    //EFFECTS: returns sample from borehole log at specified index
    public SoilSample getSample(int i) {
        return soilSamples.get(i);
    }


    //MODIFIES: this
    //EFFECTS: removes sample from the borehole log at the specified index
    public void removeSample(int i) {
        soilSamples.remove(i);
    }


    @Override
    //EFFECTS: returns size of the borehole log
    public int logSize() {
        return soilSamples.size();
    }

    @Override
    //EFFECTS: converts borehole log to a list of string and prints the result
    public void printLog() {
        for (SoilSample soilSample : soilSamples) {
            System.out.println("[" + soilSample.toString() + "]");
        }
    }

    @Override
    //TODO: this method is required by waterLog but not borehole log. Current it is abstract in log sso that I can call
    // it from the Menu. Is there a better way?
    public void setHashMap(String addSampleID, WaterSample buildHashArray) {

    }

    //EFFECTS: returns true if borehole log contains sample
    public boolean contains(Sample sample) {
        return soilSamples.contains(sample);
    }


}



