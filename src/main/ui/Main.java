package ui;

import model.BoreholeLog;
import model.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu.welcomeStatement("1.0");
        Menu.initiateApplication();
        BoreholeLog main = new BoreholeLog();
        main.handleUserInput();
        main.returnContaminatedSamples();
    }

}
