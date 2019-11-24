package model;


public abstract class Log extends Observable implements Saveable, Loadable  {

    //EFFECTS: returns size of the log
    public abstract int logSize();

    //EFFECTS: prints log to string
    public abstract void printLog();

    //EFFECTS: returns type of the log
    public abstract String getType();

    //EFFECTS: returns true if sampleID has not yet been used
    public abstract boolean isSampleIDUnique(String deleteId);

    //MODIFIES: log
    //EFFECTS: removes sample from log based on user input
    public abstract void removeSampleFromLog(String deleteId);

    //MODIFIES: log
    //EFFECTS: adds sample to log based on user input
    public abstract void addSoilSampleToLog(String name, String colour, String type, boolean odour);

    //MODIFIES: log
    //EFFECTS: adds sample to log based on user input
    public abstract void setHashMap(String addSampleID, WaterSample buildHashArray);

}






