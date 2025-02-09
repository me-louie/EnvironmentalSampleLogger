package ui;


import java.io.File;

public class Printer {

    //MODIFIES: this
    //EFFECTS: constructs new printer
    public Printer() {
    }

    //EFFECTS: prints welcome statement and indicates current version of the program
    void welcomeStatement(String version) {
        System.out.println("Welcome to Sample Log Generator v." + version + "!");
    }


    //EFFECTS: prints main user menu for specified log type
    void printSampleMenu(String type) {
        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the " + type);
        System.out.println("Press [2] to view the " + type);
        System.out.println("Press [3] to delete an existing sample from the " + type);
        System.out.println("Type 'save' to save your " + type);
        System.out.println("Type 'load' to load a " + type + " from a text file.");
        System.out.println("Type 'info' to view project information.");
        System.out.println("Type 'return' to return to the main menu.");
        System.out.println("Type 'quit' to end the application.");
    }

    //EFFECTS: prints name of sample which has been deleted and number of samples remaining
    public void printSampleHasBeenDeleted(String deleteID, int logSize) {
        System.out.println("You successfully removed sample " + deleteID + ".");
        System.out.println("There are " + logSize + " samples remaining:");

    }

    //EFFECTS: prints name of sample which has been added
    public void printSampleHasBeenAdded(String sampleID) {
        System.out.println("You successfully added sample " + sampleID + ".");
    }

    //EFFECTS: prints name of file which has been saved
    public void printLogHasBeenSaved(File fileName) {
        System.out.println("File " + fileName + " was saved.");

    }

    //EFFECTS: print name of file which has been loaded
    public void printLogHasBeenLoaded(File fileName) {
        System.out.println("File " + fileName + " has been loaded.");
    }

}
