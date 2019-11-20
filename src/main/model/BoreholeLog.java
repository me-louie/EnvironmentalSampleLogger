package model;


import ui.Printer;
import ui.gui.AppPanel;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;


public class BoreholeLog extends Log {
    private List<SoilSample> soilSamples = new ArrayList<>();
    private Printer printer = new Printer();
    private static final BoreholeLog INSTANCE = new BoreholeLog();

    //MODIFIES: this
    //EFFECTS: subscribes AppPanel as an observer to the BoreholeLog
    private BoreholeLog() {
//        List<SoilSample> boreholeLog = new ArrayList<>();
        addObserver(AppPanel.getInstance());
    }


    //EFFECTS: returns the instance of the BoreholeLog
    public static BoreholeLog getInstance() {
        return INSTANCE;
    }

    //MODIFIES: this
    //EFFECTS: removes all samples from the BoreholeLog
    public void clear() {
        BoreholeLog.getInstance().removeAll();
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

    //MODIFIES: this, SoilSample soilSample, AppPanel
    //EFFECTS: adds soilSample to the BoreholeLog, assigns BoreholeLog to soilSample, and notifies observers
    public void addSample(SoilSample soilSample) {
        if (!soilSamples.contains(soilSample)) {
            soilSamples.add(soilSample);
            soilSample.setBoreholeLog(this);
            notifyObservers(this);
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
        printer.printLogHasBeenSaved(fileName);
    }


    @Override
    //MODIFIES: this
    //EFFECTS: loads BoreholeLog data saved in .txt file
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
        printer.printLogHasBeenLoaded(file);
    }

    //EFFECTS: returns "borehole log"
    public String getType() {
        return "borehole log";
    }


    @Override
    //EFFECTS: returns true if id has not been assigned to a sample in the BoreholeLog
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
    //MODIFIES: this, AppPanel
    //EFFECTS: removes soil sample from the BoreholeLog based on id and notifies observers
    public void removeSampleFromLog(String deleteId) {
        for (int i = 0; i < logSize(); i++) {
            if (getSample(i).getName().equals(deleteId)) {
                removeSample(i);
                notifyObservers(this);
                break;
            }
        }
        printer.printSampleHasBeenDeleted(deleteId, logSize());
        printLog();
    }

    //MODIFIES: this
    //EFFECTS: creates a new soil sample based on user input and adds it to the BoreholeLog
    public void addSoilSampleToLog(String name, String colour, String type, boolean odour) {
        SoilSample soilSample = new SoilSample(name, colour, type, odour, new BoreholeLog());
        addSample(soilSample);
        printer.printSampleHasBeenAdded(name);
        System.out.println(soilSample + " was added.");
    }


    //EFFECTS: returns sample from BorehoreLog at specified index
    public SoilSample getSample(int i) {
        return soilSamples.get(i);
    }


    //MODIFIES: this
    //EFFECTS: removes sample from the BoreholeLog at the specified index
    public void removeSample(int i) {
        soilSamples.remove(i);
    }


    @Override
    //EFFECTS: returns how many samples are in the BoreholeLog
    public int logSize() {
        return soilSamples.size();
    }

    @Override
    //EFFECTS: converts samples in the BoreholeLog to a list of string and prints the result
    public void printLog() {
        for (SoilSample soilSample : soilSamples) {
            System.out.println("[" + soilSample.toString() + "]");
        }
    }

    @Override
    //EFFECTS: creates new hashmap containing soil sample data
    public void setHashMap(String addSampleID, WaterSample buildHashArray) {
        Map<String, WaterSample> boreholeMap = new HashMap<>();
        boreholeMap.put(addSampleID, buildHashArray);
    }

    //EFFECTS: returns true if borehole log contains sample
    public boolean contains(Sample sample) {
        return soilSamples.contains(sample);
    }


}



