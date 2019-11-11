package ui;

import java.util.Scanner;

class SampleBuilder {

    String addSampleID() {
        System.out.println("Please enter a new sample id.");
        Scanner s = new Scanner(System.in);
        String id = s.nextLine();
        return id;
    }
}
