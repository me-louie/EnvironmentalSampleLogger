package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaterLog extends Log {

    WaterSample waterSample = new WaterSample();

    //EFFECTS: creates empty water log
    public WaterLog() {
        super();
    }


    //EFFECTS: adds a sample to borehole log
    public void addSample(WaterSample waterSample) {
        waterLog.add(waterSample);
    }

    @Override
    //REQUIRES: access to directory where file will be saved
    //EFFECTS: writes borehole log data to txt file
    public void save(String fileSaveName) throws FileNotFoundException {
        File fileName = new File("data", fileSaveName);
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (WaterSample waterSample : waterLog) {
            pw.println(waterSample.getName());
            pw.println(waterSample.getType());
            pw.println(waterSample.isOdourous());
            pw.println(waterSample.getConductivity());
            pw.println(waterSample.getTemperature());
            pw.println(waterSample.getTurbidity());
        }
        pw.close();
        System.out.println("File " + fileName + " was saved.");

    }

    @Override
    //REQUIRES: file to be loaded to be saved in project directory
    //MODIFIES: this
    //EFFECTS: loads borehole log data saved in .txt file
    public void load(String fileLoadName) throws FileNotFoundException {
        File file = new File("data", fileLoadName);
        FileInputStream fis = new FileInputStream(file);
        Scanner in = new Scanner(fis);
        List<WaterSample> waterLog = new ArrayList<>();
        this.waterLog = waterLog;

        while (in.hasNext()) {
            WaterSample waterSample1 = new WaterSample();
            waterSample1.setName(in.nextLine());
            waterSample1.setType(in.nextLine());
            waterSample1.setOdour((in.nextLine().equals("true")));
            waterSample1.setConductivity((in.nextLine()));
            waterSample1.setTemperature((in.nextLine()));
            waterSample1.setTurbidity((in.nextLine()));
            waterLog.add(waterSample1);
        }
        System.out.println(file + " data has been loaded.");
    }

    //EFFECTS: converts waterlog to list of string
    public boolean printLog() {

        for (int i = 0; i < waterLog.size(); i++) {
            System.out.println("[" + waterLog.get(i).toString() + "]");
        }
        return true;
    }


    //EFFECTS: returns size of the water log
    @Override
    public Integer logSize() {
        return waterLog.size();
    }


    @Override
    //EFFECTS: returns sample from water log at specified index
    public WaterSample getSample(int i) {
        return waterLog.get(i);
    }


    //EFFECTS: removes sample from waterlog at specified index
    @Override
    public void removeSample(int i) {
        waterLog.remove(i);
    }

    //EFFECTS: returns true is water log contains sample, otherwise false
    @Override
    public boolean contains(Sample sample) {
        if (waterLog.contains(sample)) {
            return true;
        } else {
            return false;
        }
    }
}

//methods inherited from sample
// set/getName
// set/getType
// set/isOdourous