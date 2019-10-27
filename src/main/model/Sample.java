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
            throw new YesOrNoInputException("A 'yes' or 'no' is required.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sample)) {
            return false;
        }

        Sample sample = (Sample) o;

        if (!name.equals(sample.name)) {
            return false;
        }
        return type.equals(sample.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

