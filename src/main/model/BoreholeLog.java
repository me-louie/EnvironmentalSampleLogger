package model;


import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoreholeLog extends Log {
    private List<SoilSample> mySoilSamples = new ArrayList<>();
    private String bhLogName;


    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        super();
        bhLogName = "BHLog 1";

    }

    //EFFECTS: returns list of samples which are odourous
    public List<SoilSample> returnContaminatedSamples() {
        List<SoilSample> contaminated = new ArrayList<>();

        for (SoilSample soilSample : mySoilSamples) {
            if (soilSample.isOdourous()) {
                contaminated.add(soilSample);
            }
        }
        return contaminated;
    }


    //EFFECTS: adds a sample to borehole log
    public void addSample(SoilSample soilSample) {
        if (!mySoilSamples.contains(soilSample)) {
            mySoilSamples.add(soilSample);
            soilSample.setBoreholeLog(this);
        }

    }


    @Override
    //EFFECTS: writes borehole log data to txt file
    public void save(String fileSaveName) throws FileNotFoundException {
        File fileName = new File(String.valueOf(Paths.get("data", "soil", fileSaveName)));
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (SoilSample soilSample : mySoilSamples) {
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
        this.mySoilSamples = boreholeLog;

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


    @Override
    //MODIFIES: this
    //EFFECTS: returns sample from borehole log at specified index
    public SoilSample getSample(int i) {
        return mySoilSamples.get(i);
    }


    @Override
    //MODIFIES: this
    //EFFECTS: removes sample from the borehole log at the specified index
    public void removeSample(int i) {
        mySoilSamples.remove(i);
    }

    @Override
    //EFFECTS: returns true if borehole log contains sample, otherwise return false
    public boolean contains(Sample sample) {
        return mySoilSamples.contains(sample);
    }

    @Override
    //EFFECTS: returns size of the borehole log
    public Integer logSize() {
        return mySoilSamples.size();
    }

    @Override
    //EFFECTS: converts borehole log to a list of string
    public boolean printLog() {

        for (int i = 0; i < mySoilSamples.size(); i++) {
            System.out.println("[" + mySoilSamples.get(i).toString() + "]");
        }
        return true;

    }


}


