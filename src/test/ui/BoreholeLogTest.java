package ui;

import model.BoreholeLog;
import model.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class BoreholeLogTest {

    private List<Sample> testLog;
    private List<Sample> otherTestLog;

    private BoreholeLog testLog3;
    private BoreholeLog testLog4;


    private Sample testSample1 = new Sample("101", "brown", "gravel", false);
    private Sample testSample2 = new Sample("102", "grey", "silt", true);
    private Sample testSample3 = new Sample("103", "blue", "sand", false);


    @BeforeEach
    void setup() {
        testLog = new ArrayList<>();
        otherTestLog = new ArrayList<>();

        otherTestLog.add(testSample1);
        otherTestLog.add(testSample2);
        otherTestLog.add(testSample3);

        testLog3 = new BoreholeLog();
        testLog3.addSample(testSample3);
        testLog3.addSample(testSample1);

        testLog4 = new BoreholeLog();
        testLog4.addSample(testSample2);
        testLog4.addSample(testSample1);
    }

    @Test
    void testGetSize() {
        assertEquals(0, testLog.size());
        assertEquals(3, otherTestLog.size());
    }

    @Test
    void testGetBHSize() {
        assertEquals(2, testLog3.bhLogSize());
        assertEquals(2, testLog4.bhLogSize());
    }

    @Test
    void addSample() {
        testLog.add(testSample1);
        assertEquals("101 brown gravel false", testLog.get(0).toString());
    }

    @Test
    void testBHSave() throws IOException {
        testLog3.save("Save Test File.txt");
        assertEquals(Files.readAllLines(Paths.get("Save Test Answers.txt")), Files.readAllLines(Paths.get("Save Test File.txt")));
    }

    @Test
    void testBHLoad() throws IOException {
        BoreholeLog testLoadLog = new BoreholeLog();
        testLoadLog.load("Load Test File.txt");
        assertEquals("123", testLoadLog.getSample(0).getName());
        assertEquals("blue", testLoadLog.getSample(0).getColour());
        assertEquals("gravel", testLoadLog.getSample(0).getType());
        assertTrue(testLoadLog.getSample(0).isOdourous());
    }

    @Test
    void loadAddSave() throws IOException {
        BoreholeLog testLoadLog = new BoreholeLog();
        testLoadLog.load("Load Test File.txt");
        testLoadLog.addSample(testSample1);
        assertEquals("101", testLoadLog.getSample(1).getName());
        assertEquals("brown", testLoadLog.getSample(1).getColour());
        assertTrue(testLoadLog.getSample(0).isOdourous());
        testLoadLog.save("Load Add Save.txt");
        assertEquals(Files.readAllLines(Paths.get("Load Add Save Answer.txt")), Files.readAllLines(Paths.get("Load Add Save.txt")));
    }


//    @Test
//    void returnContaminatedSamplesEmptyList() {
//        assertEquals("102", boreholeLog.returnContaminatedSamples());
//    }

//for loop and check each item because it also checks the order
//object1.isEqual(object2)

//TA said complete this test once we cover Override in lecture.. hashes are different

}









