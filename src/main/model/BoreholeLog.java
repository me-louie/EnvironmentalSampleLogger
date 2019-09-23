package model;

import java.util.ArrayList;
import java.util.Scanner;

public class BoreholeLog {
    public ArrayList<Sample> samples = new ArrayList<Sample>();


    //EFFECTS:
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
        Scanner sampleData = new Scanner(System.in);  //
        sample1.setName(sampleData.nextLine());
        System.out.println("Is the sample grey, blue, or brown?");
        sample1.setColour(sampleData.nextLine());
        System.out.println("Is the sample silt, sand, or gravel?");
        sample1.setType(sampleData.nextLine());
        System.out.println("Is the sample odorous?");
        String contaminated = sampleData.nextLine();
        if (contaminated.equals("yes")) {
            sample1.setOdour(true);
        } else {
            sample1.setOdour(false);
        }
        samples.add(sample1);
        System.out.println("You successfully added the entry: [" + sample1.toString() + "].");
        Menu.initiateApplication();
    }

    //EFFECTS: prints list of samples currently logged
    public void optionTwo() {
        System.out.println("This borehole log has " + size() + " samples.");
        System.out.println(samples);
        Menu.initiateApplication();
    }

    //MODIFIES: this
    //EFFECTS: removes sample from borehole log based on sample id user inputted
    public void optionThree() {
        System.out.println("Please enter the ID of the sample you would like to delete.");
        Scanner id = new Scanner(System.in);
        String deleteId = id.next();

        for (int i = 0; i < samples.size(); i++) {
            if (samples.get(i).getName().equals(deleteId)) {
                samples.remove(i);
                break;
            }
        }
        System.out.println("You successfully removed a sample.");
        System.out.println("The remaining samples are:" + samples);
        Menu.initiateApplication();
    }


    //EFFECTS: prints error statement when user does not input a valid response
    public void invalidInput() {
        System.out.println("Sorry, I didn't understand. Please try a different command.");
        Menu.initiateApplication();
    }

    //EFFECTS: returns number of samples in the borehole log
    public Integer size() {
        return samples.size();
    }

}


