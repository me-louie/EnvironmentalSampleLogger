package model;


import exceptions.InvalidSoilColourException;

public class SoilSample extends Sample {
    private String colour;


    //EFFECTS: creates soil sample with name, colour, type, and odour
    public SoilSample(String name, String colour, String type, boolean odour) {
        this.name = name;
        this.colour = colour;
        this.type = type;
        this.odour = odour;
    }

    //EFFECTS: creates empty soil sample
    public SoilSample() {
        super();
    }

    //MODIFIES: this
    //EFFECTS: set soil sample colour to grey, blue, or brown
    public void setColour(String colour) {
        this.colour = colour;
    }


    //EFFECTS: return soil sample colour
    public String getColour() {  //getter
        return colour;
    }




    @Override
    //EFFECTS: print soil sample's name, colour, type, and whether it is odourous
    public String toString() {
        return name + " " + colour + " " + type + " " + odour;
    }


    public void setSoilColour(SoilSample soilSample, String str) throws InvalidSoilColourException {
        if (str.equals("blue")) {
            soilSample.setColour("blue");
        } else if (str.equals("grey")) {
            soilSample.setColour("grey");
        } else if (str.equals("brown")) {
            soilSample.setColour("brown");
        } else {
            throw new InvalidSoilColourException();
        }
    }

}




