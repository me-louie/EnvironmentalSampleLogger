package model;

import exceptions.YesOrNoInputException;

public abstract class Sample {
    String name;
    String type;
    boolean odour;

    //EFFECTS: creates new sample
    Sample() {

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

    //EFFECTS: sets isOdurous to true if user inputs 'yes' or sets isOdourous to false if user inputs 'no'
    public void setIsSampleOdourous(Sample sample, String contaminated) throws YesOrNoInputException {
        if (contaminated.equals("yes")) {
            sample.setOdour(true);
        } else if (contaminated.equals("no")) {
            sample.setOdour(false);
        } else {
            throw new YesOrNoInputException();
        }
    }
}

