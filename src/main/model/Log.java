package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Log implements Saveable, Loadable {
    private List<Sample> log;

    Log() {
        this.log = new ArrayList<>();
    }

    public abstract int logSize();

//    public abstract Sample getSample(int i);

//    public abstract void removeSample(int i);

    public abstract void printLog();

    public abstract String getType();

    public abstract boolean isSampleIDUnique(String deleteId);

    public abstract void removeSampleFromLog(String deleteId);

    public abstract void addSoilSampleToLog(String name, String colour, String type, boolean odour);

    public abstract void setHashMap(String addSampleID, WaterSample buildHashArray);


}






