package model;

import ui.Printer;
import ui.exceptions.SampleDoesNotExistException;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class WaterLog extends Log {

    private HashMap<String, WaterSample> waterLog = new HashMap<>();
    private String type = "water log";
    private Printer printer = new Printer();

    //EFFECTS: creates empty water log
    public WaterLog() {
        HashMap waterLog = new HashMap();
    }


    //setHashMap(String id, WaterSample) waterSample is list of Int.
    public void setHashMap(String str, WaterSample data) {
        waterLog.put(str, data);
        System.out.println("You successfully added water sample " + str);
    }

    @Override
    public boolean contains(Sample sample) {
        return waterLog.containsKey(sample);
    }

//    @Override
//    public boolean contains(Sample sample) {
//        return contains(sample);
//    }


    public void save(String fileSaveName) throws FileNotFoundException {

        File fileName = new File(String.valueOf(Paths.get("data", "water", fileSaveName)));
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (Map.Entry me : waterLog.entrySet()) {
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
    public void printLog() {
        System.out.println(waterLog);
//
//        for (int i = 0; i < myWaterSamples.size(); i++) {
//            System.out.println("[" + myWaterSamples.get(i).toString() + "]");
//        }
    }


    //EFFECTS: returns size of the water log
    @Override
    public int logSize() {
        return waterLog.size();
    }

    @Override
    public Sample getSample(int i) {
        return null;
    }

    @Override
    public void removeSample(int i) {

    }



    //EFFECTS: removes sample from waterlog at specified index
    public void removeSample(String sampleID) throws SampleDoesNotExistException {
        if (!waterLog.containsKey(sampleID)) {
            throw new SampleDoesNotExistException("Sorry, that sample does not exist.");
        } else {
            waterLog.remove(sampleID);
            System.out.println("You sucessfully removed " + sampleID);
            System.out.println("There are " + waterLog.size() + " samples remaining.");
            System.out.println(waterLog);
        }
    }

    //EFFECTS: return soil type
    public String getType() {
        return type;
    }


    @Override
    public boolean isSampleIDUnique(String deleteId) {
        return (!waterLog.containsKey(deleteId));
    }

    @Override
    public void removeSampleFromLog(String deleteId) {
        waterLog.remove(deleteId);
        printer.sampleHasBeenDeleted();
//        System.out.println("You successfully removed a sample.");
//        System.out.println("The remaining sample(s) is/are:");
        printLog();
    }

    @Override
    public void addSoilSampleToLog(String name, String colour, String type, boolean odour) {

    }

}