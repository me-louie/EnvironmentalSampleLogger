package model;

public class Menu {

    //EFFECTS: prints welcome statement and indicates current version of the program
    public static void welcomeStatement(String version) {
        System.out.println("Welcome to Borehole Log Generator v." + version + "!");
    }

    //EFFECTS: prints user options to begin application, or quit application
    public static void initiateApplication() {

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to create a new borehole log.");
        System.out.println("Press [2] to view existing borehole log.");
        System.out.println("Press [3] to delete a sample from an existing borehole log.");
        System.out.println("Type 'quit' to end the application.");
    }
}
