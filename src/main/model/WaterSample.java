package model;

public class WaterSample extends Sample {

    private Integer conductivity;
    private Double temperature;
    private Integer turbidity;

    //EFFECTS: creates sample with name, type, odour, conductivity, temperature, turbidity
    public WaterSample(String name, String type, boolean odour, Integer conductivity, Double temperature,
                       Integer turbidity) {
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

    }

    //MODIFIES: this
    //EFFECTS: sets water sample conductivity in uS
    public void setConductivity() {
        this.conductivity = conductivity;
    }


    //MODIFIES: this
    //EFFECTS: sets water sample temperature in deg C;
    public void setTemperature() {
        this.temperature = temperature;
    }

    //MODIFIES: this
    //EFFECTS: set water sample turbidity in ppm
    public void setTurbidity() {
        this.turbidity = turbidity;
    }

    //EFFECTS: returns sample conductivity
    public int getConductivity() {
        return conductivity;
    }

    //EFFECTS: return sample temperature;
    public double getTemperature() {
        return temperature;
    }

    //EFFECTS: return sample turbidity
    public int getTurbidity() {
        return turbidity;
    }

    @Override
    //EFFECTS: overwrites native toString function to print sample's name, colour, type, and whether it is odourous
    public String toString() {
        return name + " " + " " + type + " " + odour + " " + conductivity + " " + temperature + " " + turbidity;
    }

}
