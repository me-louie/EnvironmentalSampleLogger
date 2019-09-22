package model;

public class Sample {
    private String name;
    private String colour;
    private String type;
    private Boolean odour;

    Sample(String name, String colour, String type, Boolean odour) {
        this.name = name;
        this.colour = colour;
        this.type = type;
        this.odour = odour;
    }

    public Sample() {
        this.name = name;
        this.colour = colour;
        this.type = type;
        this.odour = odour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOdour(Boolean odour) {
        this.odour = odour;
    }

    String getName() {  //getter
        return name;
    }

    String getColour() {  //getter
        return colour;
    }

    String getType() { //getter
        return type;
    }

    Boolean getOdour() { //getter
        return odour;
    }


    public String toString() {
        return name + " " + colour + " " + type + " " + odour;
    }

}



