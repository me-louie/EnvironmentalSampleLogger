package ui;


import java.util.ArrayList;
import java.util.Scanner;

public class Log {
    public ArrayList<String> boreholes = new ArrayList<String>();


    public static void main(String[] args) {
        System.out.println("Welcome to BH Log Generator v.1.0!");
        Log main = new Log();
        main.initiateApplication();
    }

    public void initiateApplication() {

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new borehole log.");
        System.out.println("Press [2] to view list of existing borehole logs.");
        System.out.println("Press [3] to delete an existing borehole log.");
        System.out.println("Type 'quit' to end the application.");
        handleUserInput();
    }


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
                optionThree();
            } else if (!str.equals("quit")) {
                invalidInput();
            }

            if (str.equals("quit")) {
                System.out.println("Goodbye.");
                break;
            }
        }
    }

    public void optionOne() {
        System.out.println("Please enter a new borehole name.");
        Scanner bhId = new Scanner(System.in);
        boreholes.add(bhId.nextLine());
        System.out.println("You successfully added an entry.");
        System.out.println(boreholes);
        initiateApplication();

    }

    public void optionTwo() {
        System.out.println(boreholes);
        initiateApplication();
    }

    public void optionThree() {
        System.out.println("Please enter the name of the log you would like to delete.");
        Scanner deleteBh = new Scanner(System.in);
        boreholes.remove(deleteBh.nextLine());
        System.out.println("You successfully removed an entry.");
        System.out.println(boreholes);
        initiateApplication();
    }


    public void invalidInput() {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        initiateApplication();
    }
}

