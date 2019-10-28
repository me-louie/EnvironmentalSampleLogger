package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Log implements Saveable, Loadable {
    private List<Sample> log;

    Log() {
        this.log = new ArrayList<>();
    }

    public abstract Integer logSize();

    public abstract Sample getSample(int i);

//    public abstract void removeSample(int i);


//    public abstract boolean contains(Sample sample);

    public abstract boolean printLog();
}






