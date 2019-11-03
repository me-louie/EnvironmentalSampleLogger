package model;

import exceptions.InvalidWaterTypeException;

public class WaterSample extends Sample {

    private int conductivity;
    private int temperature;
    private int turbidity;
    private int ph;
    private WaterLog waterSamples;

    //EFFECTS: creates sample with name, type, odour, conductivity, temperature, turbidity.cvb
    public WaterSample(int conductivity, int temperature, int turbidity, int ph) {
        this.conductivity = conductivity;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.ph = ph;
        waterSamples = null;

    }

    //MODIFIES: this
    //EFFECTS: creates new empty water sample
    public WaterSample() {
        super();
    }


    //MODIFIES: this
    //EFFECTS: sets water sample conductivity in uS
    public void setConductivity(int conductivity) {
        this.conductivity = conductivity;
    }


    //MODIFIES: this
    //EFFECTS: sets water sample temperature in deg C;
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //MODIFIES: this
    //EFFECTS: set water sample turbidity in ppm
    public void setTurbidity(int turbidity) {
        this.turbidity = turbidity;
    }

    //MODIFIES: this
    //EFFECTS: set water sample PH
    public void setPH(int ph) {
        this.ph = ph;
    }

    //EFFECTS: returns sample conductivity
    public int getConductivity() {
        return conductivity;
    }

    //EFFECTS: return sample temperature;
    public int getTemperature() {
        return temperature;
    }

    //EFFECTS: return sample turbidity
    public int getTurbidity() {
        return turbidity;
    }

    //EFFECTS: returns sample pH
    public int getPH() {
        return ph;
    }

    @Override
    //EFFECTS: overwrites native toString function to print sample's name, colour, type, and whether it is odourous
    public String toString() {
        return conductivity + " " + temperature + " " + turbidity + " " + ph;
    }


    //EFFECTS: sets water sample type to groundwater or surface water based on user input
    public void setWaterSampleType(Sample waterSample, String str) throws InvalidWaterTypeException {
        if (str.equals("groundwater")) {
            waterSample.setType("groundwater");
        } else if (str.equals("surface water")) {
            waterSample.setType("surface water");
        } else {
            throw new InvalidWaterTypeException("Please enter a valid sample type.");
        }
    }

    public void setWaterLog(WaterLog wl) {
        this.waterSamples = wl;
//        if (!wl.contains(this)) {
//            wl.addSample(this);
//        }
    }

    public WaterLog getWaterLog() {
        return waterSamples;
    }

}
