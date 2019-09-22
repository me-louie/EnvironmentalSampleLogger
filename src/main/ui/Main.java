package ui;

import model.BoreholeLog;

public class Main {
    public static void main(String[] args) {
        BoreholeLog.welcomeStatement("1.0");
        BoreholeLog main = new BoreholeLog();
        main.initiateApplication();
    }

}
