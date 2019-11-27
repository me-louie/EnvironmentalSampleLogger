package ui;

import model.Log;

import java.util.Scanner;

class SampleBuilder {

    //MODIFIES: log, SoilSample
    //EFFECTS: sets sample ID based on user input and returns sample ID
    String addSampleID(Log log) {
        boolean runLoop = false;
        String id = "";
        while (!runLoop) {
            System.out.println("Please enter a new sample id.");
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            if (log.isSampleIDUnique(input)) {
                id = input;
                runLoop = true;
            } else {
                System.out.println("Sorry, that ID has been used. Please enter a unique name");
            }

        }
        return id;
    }
}


