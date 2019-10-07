package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Log implements Saveable, Loadable {
    protected List<Sample> log;
    protected List<SoilSample> boreholeLog = new ArrayList<>();
    protected List<WaterSample> waterLog = new ArrayList<>();

    Log() {
        this.log = new ArrayList<>();
    }

    public abstract Integer logSize();

    public abstract Sample getSample(int i);

    public abstract void removeSample(int i);

    public abstract void printLog();




}


