package ui;

import model.WaterSample;

import java.util.Scanner;

class WaterSampleBuilder extends SampleBuilder {

    WaterSampleBuilder() {

    }

    WaterSample buildHashArray() {
        WaterSample waterSample = new WaterSample();
        waterSample.setTemperature(addWaterTemperature());
        waterSample.setTurbidity(addWaterTurbidity());
        waterSample.setConductivity(addWaterConductivity());
        return waterSample;
    }


    private Integer addWaterTemperature() {
        System.out.println("Please enter the sample temperature.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private Integer addWaterTurbidity() {
        System.out.println("Please enter the sample turbidity.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }

    private Integer addWaterConductivity() {
        System.out.println("Please enter the sample conductivity.");
        Scanner s = new Scanner(System.in);
        String sampleData = s.nextLine();
        return Integer.parseInt(sampleData);
    }


}
