package model;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface Saveable {

    //EFFECTS: saves data to .txt file
    void save(String fileName) throws FileNotFoundException;
}
