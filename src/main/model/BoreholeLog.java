package model;



import exceptions.PathNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoreholeLog extends Log {



    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        super();
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
    //REQUIRES: access to location where file is intended to be saved
    //EFFECTS: writes borehole log data to txt file
    public void save(String fileSaveName) throws FileNotFoundException {
        File dir = new File(dirName);
        File fileName = new File(dir, fileSaveName);
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


    }

    @Override
    //REQUIRES: file to be loaded to be located in the project directory
    //MODIFIES: this
    //EFFECTS: loads borehole log data saved in .txt file
    public void load(String fileLoadName) throws FileNotFoundException {
        File dir = new File(dirName);
        File file = new File(dir, fileLoadName);
        FileInputStream fis = new FileInputStream(file);
        Scanner in = new Scanner(fis);
        List<SoilSample> boreholeLog = new ArrayList<>();
        this.boreholeLog = boreholeLog;

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
        return boreholeLog.get(i);
    }


    @Override
    //MODIFIES: this
    //EFFECTS: removes sample from the borehole log at the specified index
    public void removeSample(int i) {
        boreholeLog.remove(i);
    }

    @Override
    //EFFECTS: returns true if borehole log contains sample, otherwise return false
    public boolean contains(Sample sample) {
        if (boreholeLog.contains(sample)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    //EFFECTS: returns size of the borehole log
    public Integer logSize() {
        return boreholeLog.size();
    }

    //EFFECTS: converts borehole log to a list of string
    public boolean printLog() {

        for (int i = 0; i < boreholeLog.size(); i++) {
            System.out.println("[" + boreholeLog.get(i).toString() + "]");
        }
        return true;

    }



}


