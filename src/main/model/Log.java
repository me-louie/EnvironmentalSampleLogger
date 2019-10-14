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


    public abstract boolean contains(Sample sample);

    public abstract boolean printLog();

    public boolean checkUnique(String testString) {
        for (int i = 0; i < logSize(); i++) {
            if (testString.equals(getSample(i).getName())) {
                return false;
            }
        }
        return true;
    }

    public void removeSampleFromLog(Log log, String deleteId) {
        for (int i = 0; i < log.logSize(); i++) {
            if (log.getSample(i).getName().equals(deleteId)) {
                log.removeSample(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining sample(s) is/are:");
        log.printLog();
    }
}



