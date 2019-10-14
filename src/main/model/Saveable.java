package model;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface Saveable {
    void save(String fileName) throws FileNotFoundException;
}
