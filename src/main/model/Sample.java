package model;


import java.io.*;
import java.util.Scanner;

public class Sample {
    private String name;
    private String colour;
    private String type;
    private boolean odour;

    //EFFECTS: creates sample with name, colour, type, and odour
    public Sample(String name, String colour, String type, boolean odour) {
        this.name = name;
        this.colour = colour;
        this.type = type;
        this.odour = odour;
    }

    //EFFECTS: creates empty sample
    public Sample() {
    }

    //MODIFIES: this
    //EFFECTS: sets sample name to name
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES: this
    //EFFECTS: set sample colour to grey, blue, or brown
    public void setColour(String colour) {
        this.colour = colour;
    }

    //MODIFIES: this
    //EFFECTS: sets sample type to silt, sand, or gravel
    public void setType(String type) {
        this.type = type;
    }


    //MODIFIES: this
    //EFFECTS: sets sample odour to true if odourous, otherwise false
    public void setOdour(Boolean odour) {
        this.odour = odour;
    }

    //EFFECTS: returns sample name
    public String getName() {  //getter
        return name;
    }

    //EFFECTS: return sample colour
    public String getColour() {  //getter
        return colour;
    }

    //EFFECTS: return sample type
    public String getType() { //getter
        return type;
    }

    //EFFECTS: return true if sample is odourous, otherwise false
    public boolean isOdourous() {
        return odour;
    }


    @Override
    //EFFECTS: overwrites native toString function to print sample's name, colour, type, and whether it is odourous
    public String toString() {
        return name + " " + colour + " " + type + " " + odour;
    }

//    @Override
//    public void load() throws FileNotFoundException {
//        File fileName = new File("Sample.txt");
//        FileInputStream fis = new FileInputStream(fileName);
//        Scanner in = new Scanner(fis);
//
//        while (in.hasNext()) {
//            Sample sampleToLoad = new Sample();
//            sampleToLoad.setName(in.nextLine());
//            sampleToLoad.setType(in.nextLine());
//            sampleToLoad.setColour(in.nextLine());
//            sampleToLoad.setOdour((in.nextLine().equals("true")));
//        }
//        System.out.println(fileName + " data has been loaded.");
//
//    }
//
//    @Override
//    public void save() throws IOException {
//        Sample sampleToSave = new Sample();
//        File fileName = new File("Sample.txt");
//        FileOutputStream fos = new FileOutputStream(fileName);
//        PrintWriter pw = new PrintWriter(fos);
//        pw.println(sampleToSave.getName());
//        pw.println(sampleToSave.getType());
//        pw.println(sampleToSave.getColour());
//        pw.println(sampleToSave.isOdourous());
//        pw.close();
//        System.out.println("File " + fileName + " was saved.");
//
//    }
}



