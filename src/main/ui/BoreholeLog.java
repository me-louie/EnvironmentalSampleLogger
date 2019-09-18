package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class BoreholeLog {
    public ArrayList<Sample> samples = new ArrayList<Sample>();


    public static void main(String[] args) {
        welcomeStatement("1.0");
        BoreholeLog main = new BoreholeLog();
        main.initiateApplication();
    }

    private static void welcomeStatement(String version) {
        System.out.println("Welcome to Borehole Log Generator v." + version + "!");
    }


    public void initiateApplication() {

        System.out.println("What would you like to do?");
        System.out.println("Press [1] to create a new borehole log.");
        System.out.println("Press [2] to view existing borehole log.");
        System.out.println("Press [3] to delete a sample from an existing borehole log.");
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
        Sample sample1 = new Sample();
        System.out.println("Please enter a new sample id.");
        Scanner sampleData = new Scanner(System.in);
        sample1.name = (sampleData.nextLine());
//        enterId();
//        enterColour();
//        enterStatigraphy();
//        enterOdours();
        System.out.println("Is the sample grey, blue, or brown?");
        sample1.colour = (sampleData.nextLine());
        System.out.println("Is the sample silt, sand, or gravel?");
        sample1.type = (sampleData.nextLine());
        System.out.println("Is the sample odorous?");
        String contaminated = sampleData.nextLine();
        if (contaminated.equals("yes")) {
            sample1.odour = true;
        } else {
            sample1.odour = false;
        }
        samples.add(sample1);
        System.out.println("You successfully added an entry.");
//        System.out.println(samples.toString());
        initiateApplication();
    }

//    public String enterId() {
//        Sample sample1 = new Sample();
//        System.out.println("Please enter a new sample id.");
//        Scanner sampleData = new Scanner(System.in);
//        sample1.name = (sampleData.nextLine());
//        return sample1.name;
//    }

//    public void enterColour() {
//        Sample sample1 = new Sample();
//        System.out.println("Is the sample grey, blue, or brown?");
//        Scanner sampleData = new Scanner(System.in);
//        sample1.colour = (sampleData.nextLine());
//    }
//
//    public void enterStatigraphy() {
//        Sample sample1 = new Sample();
//        System.out.println("Is the sample silt, sand, or gravel?");
//        Scanner sampleData = new Scanner(System.in);
//        sample1.type = (sampleData.nextLine());
//    }
//
//    public void enterOdours() {
//        Sample sample1 = new Sample();
//        System.out.println("Is the sample odorous?");
//        Scanner sampleData = new Scanner(System.in);
//        String contaminated = sampleData.nextLine();
//        if (contaminated.equals("yes")) {
//            sample1.odour = true;
//        } else {
//            sample1.odour = false;
//        }
//    }

    public void optionTwo() {
        System.out.println("This borehole log has " + size() + " samples.");
        System.out.println(samples);
        initiateApplication();
    }

    public void optionThree() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < samples.size(); i++) {
            if (samples.get(i).name.equals(deleteId)) {
                samples.remove(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println(samples);
        initiateApplication();
    }


    public void invalidInput() {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        initiateApplication();
    }

    public Integer size() {
        return samples.size();
    }


}


