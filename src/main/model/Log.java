package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Log implements Saveable, Loadable {
    private List<Sample> log;

    Log() {
        this.log = new ArrayList<>();
    }

    public abstract Integer logSize();

//    public abstract Sample getSample(int i);

//    public abstract void removeSample(int i);


//    public abstract boolean contains(Sample sample);

    public abstract boolean printLog();

    public abstract String getType();


    public abstract boolean isSampleIDUnique(String deleteId);

    public abstract void removeSampleFromLog(BoreholeLog boreholeLog, String deleteId);

    public abstract void addSoilSampleToLog(String name, String colour, String type, boolean odour);

    public abstract void setHashMap(String addSampleID, WaterSample buildHashArray);
}






