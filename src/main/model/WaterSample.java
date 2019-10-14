package model;

import exceptions.InvalidWaterTypeException;

public class WaterSample extends Sample {

    private String conductivity;
    private String temperature;
    private String turbidity;

    //EFFECTS: creates sample with name, type, odour, conductivity, temperature, turbidity
    public WaterSample(String name, String type, boolean odour, String conductivity, String temperature,
                       String turbidity) {
        this.name = name;
        this.type = type;
        this.odour = odour;
        this.conductivity = conductivity;
        this.temperature = temperature;
        this.turbidity = turbidity;
    }

    //MODIFIES: this
    //EFFECTS: creates new empty water sample
    public WaterSample() {
        super();
    }

    //MODIFIES: this
    //EFFECTS: sets water sample conductivity in uS
    public void setConductivity(String conductivity) {
        this.conductivity = conductivity;
    }


    //MODIFIES: this
    //EFFECTS: sets water sample temperature in deg C;
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    //MODIFIES: this
    //EFFECTS: set water sample turbidity in ppm
    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity;
    }

    //EFFECTS: returns sample conductivity
    public String getConductivity() {
        return conductivity;
    }

    //EFFECTS: return sample temperature;
    public String getTemperature() {
        return temperature;
    }

    //EFFECTS: return sample turbidity
    public String getTurbidity() {
        return turbidity;
    }

    @Override
    //EFFECTS: overwrites native toString function to print sample's name, colour, type, and whether it is odourous
    public String toString() {
        return name + " " + type + " " + odour + " " + conductivity + " " + temperature + " " + turbidity;
    }


    //EFFECTS: sets water sample type to groundwater or surface water based on user input
    public void setWaterSampleType(Sample waterSample, String str) throws InvalidWaterTypeException {
        if (str.equals("groundwater")) {
            waterSample.setType("groundwater");
        } else if (str.equals("surface water")) {
            waterSample.setType("surface water");
        } else {
            throw new InvalidWaterTypeException();
        }
    }
}
