package model;

public abstract class Sample {
    protected String name;
    protected String type;
    protected boolean odour;

    //EFFECTS: creates new sample
    public Sample(){

    }

    //MODIFIES: this
    //EFFECTS: sets sample name to name
    public void setName(String name) {
        this.name = name;
    }

    //MODIFIES: this
    //EFFECTS: sets sample type
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

    //EFFECTS: return sample type
    public String getType() { //getter
        return type;
    }

    //EFFECTS: return true if sample is odourous, otherwise false
    public boolean isOdourous() {
        return odour;
    }

    //EFFECTS: print sample's name and qualifiers
    public abstract String toString();
}

