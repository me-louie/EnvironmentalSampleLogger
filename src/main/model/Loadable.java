package model;


import java.io.FileNotFoundException;

public interface Loadable {

    //MODIFIES: log
    //EFFECTS: loads data saved in form of .txt file
    void load(String fname) throws  FileNotFoundException;
}
