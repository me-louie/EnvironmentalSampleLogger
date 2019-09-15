package ui;


import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<String> logs = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Welcome to BH Log Generator v.1.0!");
//        ArrayList<String> logs = new ArrayList<String>();
        Main sm = new Main();
        sm.initiateApplication();
    }

    public void initiateApplication() {
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new borehole log.");
        System.out.println("Press [2] to view list of existing borehole logs.");
        System.out.println("Press [3] to delete an existing borehole log.");
        System.out.println("Type 'quit' to end the application.");
        handleUserInput();
//        printInstructions();
    }

//    public static void printInstructions() {
//        System.out.println("Press [1] to add a new borehole log.");
//        System.out.println("Press [2] to view list of existing borehole logs.");
//        System.out.println("Press [3] to delete an existing borehole log.");
//        System.out.println("Type 'quit' to end the application.");
//        printOptions();
//    }

    public void handleUserInput() {
        String str = "";

        while (true) {
            Scanner input = new Scanner(System.in);
            str = input.nextLine();
            if (str.equals("1")) {
                optionOne();
            } else if (str.equals("2")) {
                optionTwo();
            } else if (str.equals("3")) {
                System.out.println("Select log to delete.");
            }

            if (str.equals("quit")) {
                break;
            }
        }
    }

    public void optionOne() {
        System.out.println("Please enter a new borehole name.");
        Scanner bhid = new Scanner(System.in);
        logs.add(bhid.nextLine());
        System.out.println("You successfully added an entry.");
        System.out.println(logs);
        initiateApplication();

    }

    public void optionTwo() {
        System.out.println(logs);
        initiateApplication();
    }

}
