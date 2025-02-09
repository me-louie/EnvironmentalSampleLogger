package model;

import ui.Printer;
import ui.exceptions.SampleDoesNotExistException;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class WaterLog extends Log {

    private HashMap<String, WaterSample> waterLog = new HashMap<>();
    private Printer printer = new Printer();

    //EFFECTS: creates empty water log
    public WaterLog() {
        HashMap waterLog = new HashMap();
    }


    //MODIFIES: this
    //EFFECTS: adds new entry to water log based on user input
    public void setHashMap(String str, WaterSample data) {
        waterLog.put(str, data);
        printer.printSampleHasBeenAdded(str);
    }

    //EFFECTS: returns true if water log contains sample
    public boolean contains(String sampleID) {
        return waterLog.containsKey(sampleID);
    }



    //EFFECTS: writes water log data to txt file
    public void save(String fileSaveName) throws FileNotFoundException {

        File fileName = new File(String.valueOf(Paths.get("data", "water", fileSaveName)));
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pw = new PrintWriter(fos);
        for (Map.Entry me : waterLog.entrySet()) {
            pw.println(me.getKey() + "=" + me.getValue());
        }
        pw.flush();
        pw.close();
        printer.printLogHasBeenSaved(fileName);
    }

    //MODIFIES: this
    //EFFECTS: loads water log data saved as .txt file
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
    //EFFECTS: prints all water samples in water log
    public void printLog() {
        System.out.println(waterLog);
//
//        for (int i = 0; i < myWaterSamples.size(); i++) {
//            System.out.println("[" + myWaterSamples.get(i).toString() + "]");
//        }
    }


    @Override
    //EFFECTS: returns size of the water log
    public int logSize() {
        return waterLog.size();
    }


    //EFFECTS: returns size of the water log
    public Sample getSample(String sampleID) {
        return waterLog.get(sampleID);
    }


    //EFFECTS: removes sample from waterlog
    public void removeSample(String sampleID) throws SampleDoesNotExistException {
        if (!waterLog.containsKey(sampleID)) {
            throw new SampleDoesNotExistException("Sorry, that sample does not exist.");
        } else {
            waterLog.remove(sampleID);
            printer.printSampleHasBeenDeleted(sampleID, logSize());
            System.out.println(waterLog);
        }
    }

    //EFFECTS: returns "water log"
    public String getType() {
        return "water log";
    }


    @Override
    //EFFECTS: returns true if id has not been assigned to a sample in the water log
    public boolean isSampleIDUnique(String sampleID) {
        return (!waterLog.containsKey(sampleID));
    }

    @Override
    //EFFECTS: removes specified sample from waterlog
    public void removeSampleFromLog(String deleteId) {
        waterLog.remove(deleteId);
        printer.printSampleHasBeenDeleted(deleteId, logSize());
        printLog();
    }

    @Override
    //EFFECTS: creates a new soil sample based on user input and adds it to the BoreholeLog
    public void addSampleToLog(String name, String colour, String type, boolean odour) {
    }

}