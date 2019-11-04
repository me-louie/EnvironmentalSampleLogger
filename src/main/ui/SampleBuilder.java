package ui;

import java.util.Scanner;

class SampleBuilder {

    String addSampleID() {
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        String id = s.nextLine();
//        if (!log.isSampleIDUnique(id)) {
//            System.out.println("Sorry that id has already been used.");
//            addSampleID();
//        }
        //TODO: ask TA, why when adding a sample with a duplicate name,
        // after the return statement, addSample() is called again?
        return id;
    }
}
