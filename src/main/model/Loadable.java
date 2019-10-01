package model;

import java.io.FileNotFoundException;

public interface Loadable {
    void load(String fname) throws FileNotFoundException;
}
