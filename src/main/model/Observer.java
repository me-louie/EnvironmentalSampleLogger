package model;

public interface Observer {
    //MODIFIES: BoreholeLogDrawer
    //EFFECTS: updates BoreholeLogDrawer with boreholeLog
    String update(BoreholeLog boreholeLog);
}
