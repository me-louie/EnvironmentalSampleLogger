package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class Log implements Saveable, Loadable {
    protected List<Sample> log;

    Log() {
        this.log = new ArrayList<>();
    }

    public Integer logSize() {
        return log.size();
    }


}
