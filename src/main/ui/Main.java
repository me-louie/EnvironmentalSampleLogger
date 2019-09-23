package ui;

import model.BoreholeLog;
import model.Menu;

public class Main {
    public static void main(String[] args) {
        Menu.welcomeStatement("1.0");
        Menu.initiateApplication();

        BoreholeLog main = new BoreholeLog();
//        main.initiateApplication();
        main.handleUserInput();
    }

}
