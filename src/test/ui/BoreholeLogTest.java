package ui;

import model.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class BoreholeLogTest {

    private List<Sample> testLog;
    private List<Sample> otherTestLog;


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
    }

    @Test
    void testGetSize() {
        assertEquals(0, testLog.size());
        assertEquals(3, otherTestLog.size());
    }

    @Test
    void addSample() {
        testLog.add(testSample1);
        assertEquals("101 brown gravel false", testLog.get(0).toString());
    }

    @Test
    void testSaveSamples() throws FileNotFoundException {
        Sample sample1 = new Sample("101", "grey", "sand", false);
        Sample sample2 = new Sample("102", "blue", "gravel", true);
        List<Sample> testLog2 = new ArrayList<>();
        testLog2.add(sample1);
        testLog2.add(sample2);

        String testString1 = "101 grey sand false";
        String testString2 = "102 blue gravel true";

        File testFile = new File("Save Tester.txt");
        FileOutputStream fos = new FileOutputStream(testFile);
        PrintWriter pw = new PrintWriter(fos);
        for (Sample sample : testLog2) {
            pw.println(sample.getName());
            pw.println(sample.getColour());
            pw.println(sample.getType());
            pw.println(sample.isOdourous());
        }
        pw.close();


        FileInputStream fis = new FileInputStream(testFile);
        Scanner in = new Scanner(fis);

        while (in.hasNext()) {
            Sample testSample = new Sample();
            testSample.setName(in.nextLine());
            testSample.setColour(in.nextLine());
            testSample.setType(in.nextLine());
            testSample.setOdour((in.nextLine().equals("true")));
            testLog2.add(testSample);
        }

        assertEquals(testString1, testLog2.get(0).toString());
        assertEquals(testString2, testLog2.get(1).toString());
    }

    @Test
    void testLoad() throws FileNotFoundException {
        List<Sample> testLoadLog = new ArrayList<>();

        File testFile = new File("Load Tester.txt");
        FileOutputStream fos = new FileOutputStream(testFile);
        PrintWriter pw = new PrintWriter(fos);
        pw.println("105");
        pw.println("blue");
        pw.println("sand");
        pw.println(false);
        pw.println("106");
        pw.println("brown");
        pw.println("gravel");
        pw.println(true);
        pw.close();

        FileInputStream fis = new FileInputStream(testFile);
        Scanner in = new Scanner(fis);

        while (in.hasNext()) {
            Sample testSample = new Sample();
            testSample.setName(in.nextLine());
            testSample.setColour(in.nextLine());
            testSample.setType(in.nextLine());
            testSample.setOdour((in.nextLine().equals("true")));
            testLoadLog.add(testSample);
        }

        assertEquals("105", testLoadLog.get(0).getName());
        assertEquals("blue", testLoadLog.get(0).getColour());
        assertEquals("sand", testLoadLog.get(0).getType());
        assertFalse(testLoadLog.get(0).isOdourous());

        assertEquals("106", testLoadLog.get(1).getName());
        assertEquals("brown", testLoadLog.get(1).getColour());
        assertEquals("gravel", testLoadLog.get(1).getType());
        assertTrue(testLoadLog.get(1).isOdourous());

    }

    @Test
    void loadThenAdd() throws FileNotFoundException {
        List<Sample> testLoadEditSaveLog = new ArrayList<>();

        File testFile = new File("Load Edit Save Tester.txt");
        FileOutputStream fos = new FileOutputStream(testFile);
        PrintWriter pw = new PrintWriter(fos);
        pw.println("105");
        pw.println("blue");
        pw.println("sand");
        pw.println(false);
        pw.close();

        FileInputStream fis = new FileInputStream(testFile);
        Scanner in = new Scanner(fis);

        while (in.hasNext()) {
            Sample testSample = new Sample();
            testSample.setName(in.nextLine());
            testSample.setColour(in.nextLine());
            testSample.setType(in.nextLine());
            testSample.setOdour((in.nextLine().equals("true")));
            testLoadEditSaveLog.add(testSample);
        }

        testLoadEditSaveLog.add(testSample1);

        assertEquals("105", testLoadEditSaveLog.get(0).getName());
        assertEquals("101", testLoadEditSaveLog.get(1).getName());
        assertEquals("brown", testLoadEditSaveLog.get(1).getColour());
        assertEquals("gravel", testLoadEditSaveLog.get(1).getType());
        assertFalse(testLoadEditSaveLog.get(1).isOdourous());

    }


//    @Test
//    void returnContaminatedSamplesEmptyList() {
//        assertEquals("102", boreholeLog.returnContaminatedSamples());
//    }

//for loop and check each item because it also checks the order
//object1.isEqual(object2)

//TA said complete this test once we cover Override in lecture.. hashes are different

}









