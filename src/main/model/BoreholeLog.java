package model;

import ui.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoreholeLog implements Saveable, Loadable {
    private List<SoilSample> boreholeLog;
//    private SoilSample soilSample1 = new SoilSample();

    //EFFECTS: creates empty borehole log
    public BoreholeLog() {
        boreholeLog = new ArrayList<>();
    }


    //EFFECTS: returns size of borehole log
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



    //EFFECTS: returns sample from borehole log at specified index
    public SoilSample getSample(int i) {
        return boreholeLog.get(i);
    }


    public void removeSample(int i) {
        boreholeLog.remove(i);
    }
}




