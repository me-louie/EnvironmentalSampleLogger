package ui;

public class Menu {

    //EFFECTS: prints welcome statement and indicates current version of the program
    public static void welcomeStatement(String version) {
        System.out.println("Welcome to Borehole Log Generator v." + version + "!");
    }

    //EFFECTS: prints user options to begin application, or quit application
    public static void initiateApplication() {

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the borehole log.");
        System.out.println("Press [2] to view the borehole log.");
        System.out.println("Press [3] to delete an existing sample from the borehole log.");
        System.out.println("Type 'save' to save your borehole log.");
        System.out.println("Type 'load' to load a borehole from a text file.");
        System.out.println("Type 'quit' to end the application.");
    }

}
