package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Log implements Saveable, Loadable {
    protected List<Sample> log;
    protected List<SoilSample> boreholeLog = new ArrayList<>();
    protected List<WaterSample> waterLog = new ArrayList<>();

    String dirName = "C:\\Users\\Pikachu\\Documents\\!Courses\\Fall 2019\\CPSC 210\\project_u7v2b\\data";

    Log() {
        this.log = new ArrayList<>();
    }

    public Integer logSize() {
        return log.size();
    }

    public abstract Sample getSample(int i);

    public abstract void removeSample(int i);

    public abstract boolean contains(Sample sample);
}


