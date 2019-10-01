package ui;

import model.BoreholeLog;


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
