package model;

import ui.exceptions.SampleDoesNotExistException;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class WaterLog extends Log {

    private HashMap<String, ArrayList<Integer>> myWaterSamples = new HashMap<>();
    private String waterLogName;

    //EFFECTS: creates empty water log
    public WaterLog() {
        super();
        waterLogName = "WaterLog 1";

        //construct new hashMap
    }


    //setHashMap(String id, WaterSample) waterSample is list of Int.
    public void setHashMap(String str, ArrayList<Integer> data) {
        myWaterSamples.put(str, data);
        System.out.println("You successfully added water sample " + str);
    }


    public void save(String fileSaveName) throws FileNotFoundException {

        File fileName = new File(String.valueOf(Paths.get("data", "water", fileSaveName)));
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (Map.Entry me : myWaterSamples.entrySet()) {
            pw.println(me.getKey() + "=" + me.getValue());
        }
        pw.flush();
        pw.close();
        System.out.println("File " + fileName + " was saved.");
    }

    public void load(String fileLoadName){

    }

//    public void load(String fileLoadName) throws FileNotFoundException {
//        File file = new File(String.valueOf(Paths.get("data", "water", fileLoadName)));
//        FileInputStream fis = new FileInputStream(file);
//        Scanner in = new Scanner(fis);
//        HashMap<String, ArrayList<Integer>> myWaterSamples = new HashMap<>();
//        this.myWaterSamples = myWaterSamples;
//        String currentLine;
//
//        while (in.hasNext()) {
//            currentLine = in.nextLine();
//            StringTokenizer st = new StringTokenizer(currentLine, "=", false);
//            myWaterSamples.put(st.nextToken(), st.nextToken());
//        }
//        fis.close();
//        for (Map.Entry<String, ArrayList<Integer>> m : myWaterSamples.entrySet()) {
//            System.out.println(m.getKey() + " : " + m.getValue());
//        }
//        System.out.println(file + " data has been loaded.");
//    }



//    @Override
//
//    //EFFECTS: writes borehole log data to txt file
//    public void save(String fileSaveName) throws FileNotFoundException {
//        File fileName = new File(String.valueOf(Paths.get("data", "water", fileSaveName)));
//        FileOutputStream fos = new FileOutputStream(fileName);
//        PrintWriter pw = new PrintWriter(fos);
//        for (WaterSample waterSample : myWaterSamples) {
//            pw.println(waterSample.getName());
//            pw.println(waterSample.getType());
//            pw.println(waterSample.isOdourous());
//            pw.println(waterSample.getConductivity());
//            pw.println(waterSample.getTemperature());
//            pw.println(waterSample.getTurbidity());
//        }
//        pw.close();
//        System.out.println("File " + fileName + " was saved.");
//
//    }

//    @Override
//
//    //MODIFIES: this
//    //EFFECTS: loads borehole log data saved in .txt file
//    public void load(String fileLoadName) throws FileNotFoundException {
//        File file = new File(String.valueOf(Paths.get("data", "water", fileLoadName)));
//        FileInputStream fis = new FileInputStream(file);
//        Scanner in = new Scanner(fis);
//        List<WaterSample> waterLog = new ArrayList<>();
//        this.myWaterSamples = waterLog;
//
//        while (in.hasNext()) {
//            WaterSample waterSample1 = new WaterSample();
//            waterSample1.setName(in.nextLine());
//            waterSample1.setType(in.nextLine());
//            waterSample1.setOdour((in.nextLine().equals("true")));
//            waterSample1.setConductivity((in.nextLine()));
//            waterSample1.setTemperature((in.nextLine()));
//            waterSample1.setTurbidity((in.nextLine()));
//            waterLog.add(waterSample1);
//        }
//        System.out.println(file + " data has been loaded.");
//    }

    @Override
    //EFFECTS: converts waterlog to list of string
    public boolean printLog() {
        System.out.println(myWaterSamples);
//
//        for (int i = 0; i < myWaterSamples.size(); i++) {
//            System.out.println("[" + myWaterSamples.get(i).toString() + "]");
//        }
        return true;
    }


    //EFFECTS: returns size of the water log
    @Override
    public Integer logSize() {
        return myWaterSamples.size();
    }


    //EFFECTS: returns sample from water log at specified index
    public ArrayList<Integer> getData(String str) {
//        return myWaterSamples.get(i);
        return myWaterSamples.get(str);
    }


    //EFFECTS: removes sample from waterlog at specified index
    public void removeSample(String sampleID) throws SampleDoesNotExistException {
        if (!myWaterSamples.containsKey(sampleID)) {
            throw new SampleDoesNotExistException("Sorry, that sample does not exist.");
        } else {
            myWaterSamples.remove(sampleID);
            System.out.println("You sucessfully removed " + sampleID);
            System.out.println("There are " + myWaterSamples.size() + " samples remaining.");
            System.out.println(myWaterSamples);
        }
    }


//    @Override
//    public boolean contains(Sample sample) {
////        return myWaterSamples.contains(sample);
//        return contains(sample);
//    }

    //EFFECTS: returns true is water log contains sample, otherwise false
    public boolean contains(String sampleID) {
        return myWaterSamples.containsKey(sampleID);
    }


}