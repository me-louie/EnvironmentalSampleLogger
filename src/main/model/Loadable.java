package model;

import exceptions.FileNotFoundException2;

import java.io.FileNotFoundException;

public interface Loadable {
    void load(String fname) throws FileNotFoundException2, FileNotFoundException;
}
