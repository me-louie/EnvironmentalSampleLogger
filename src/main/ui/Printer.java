package ui;



public class Printer {
    //TODO: why do things break if PrintStatements extend PrintMenu?

    public Printer(){
    }

    //EFFECTS: prints welcome statement and indicates current version of the program
    void welcomeStatement(String version) {
        System.out.println("Welcome to Sample Log Generator v." + version + "!");
    }

    //EFFECTS: prints main user menu for specified log type
    void printMainMenu(String type) {
        System.out.println("What would you like to do?");
        System.out.println("Press [1] to add a new sample to the " + type);
        System.out.println("Press [2] to view the " + type);
        System.out.println("Press [3] to delete an existing sample from the " + type);
        System.out.println("Type 'save' to save your " + type);
        System.out.println("Type 'load' to load a " + type + " from a text file.");
        System.out.println("Type 'return' to return to the main menu.");
        System.out.println("Type 'quit' to end the application.");
    }

    public void sampleHasBeenDeleted() {
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining sample(s) is/are:");

    }
}
