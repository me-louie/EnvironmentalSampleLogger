package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to BH Log Generator v.1.0!");
        initiateApplication();
    }

    public static void initiateApplication() {
        System.out.println("What would you like to do?");
        printInstructions();
    }

    public static void printInstructions() {
        System.out.println("Press [1] to add a new borehole log.");
        System.out.println("Press [2] to view list of existing borehole logs.");
        System.out.println("Press [3] to delete an existing borehole log.");
        System.out.println("Type 'quit' to end the application.");
        printOptions();
    }

    public static void printOptions() {
        Scanner input = new Scanner(System.in);
        String userinput = input.nextLine();
        ArrayList<String> logs = new ArrayList();

        if (userinput.equals("1")) {
            System.out.println("Please enter new borehole ID.");
            Scanner bhid = new Scanner(System.in);
            logs.add(bhid.nextLine());
            System.out.println(logs + "end of list");
        } else if (userinput.equals("2")) {
            System.out.println(logs);
        } else if (userinput.equals("quit")) {
            System.out.println("Quitting");
        } else {
            System.out.println("Sorry I didn't understand the command, please try again.");
        }
    }
}



