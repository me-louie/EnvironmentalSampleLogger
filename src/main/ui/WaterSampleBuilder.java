package ui;

import model.WaterSample;

import java.util.Scanner;

class WaterSampleBuilder extends SampleBuilder {

    //MODIFIES: this
    //EFFECTS: constructs new water sample builder
    WaterSampleBuilder() {

    }

    //MODIFIES: WaterSample, WaterLog
    //EFFECTS: constructs new WaterSample based on user input and returns the water sample
    WaterSample buildHashArray() {
        WaterSample waterSample = new WaterSample();
        waterSample.setTemperature(addWaterTemperature());
        waterSample.setTurbidity(addWaterTurbidity());
        waterSample.setConductivity(addWaterConductivity());
        waterSample.setPH((addWaterPH()));
        return waterSample;
    }

    private int addWaterPH() {
        System.out.println("Please enter the sample pH.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }


    private int addWaterTemperature() {
        System.out.println("Please enter the sample temperature.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private int addWaterTurbidity() {
        System.out.println("Please enter the sample turbidity.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private int addWaterConductivity() {
        System.out.println("Please enter the sample conductivity.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }


}
