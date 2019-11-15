package tests;

import model.BoreholeLog;
import model.SoilSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;


class BoreholeLogTest extends LogTest {

    //    private BoreholeLog emptyTestLog;
//    private BoreholeLog testLog3;
//    private BoreholeLog testLog4;
    private BoreholeLog bh;


    private SoilSample testSoilSample1 = new SoilSample("101", "brown", "gravel", false, bh);
    private SoilSample testSoilSample2 = new SoilSample("102", "grey", "silt", true, bh);
    private SoilSample testSoilSample3 = new SoilSample("103", "blue", "sand", false, bh);

    private ArrayList emptyArray = new ArrayList();
    private ArrayList testArray = new ArrayList();


    @BeforeEach
    void setup() {


//        emptyTestLog = BoreholeLog.getInstance();
//
//        testLog3 = BoreholeLog.getInstance();
//        testLog3.addSample(testSoilSample3);
//        testLog3.addSample(testSoilSample1);
//
//        testLog4 = BoreholeLog.getInstance();
//        testLog4.addSample(testSoilSample2);
//        testLog4.addSample(testSoilSample1);

        bh = BoreholeLog.getInstance();
    }


    @Test
    void testBHSave() throws IOException {
        bh.addSample(testSoilSample3);
        bh.addSample(testSoilSample1);
        bh.save("Save Test File.txt");
        Files.readAllLines(Paths.get("data", "soil", "Save Test File.txt"));
        assertEquals(Files.readAllLines(Paths.get("data", "soil", "Save Test Answers.txt")),
                Files.readAllLines(Paths.get("data", "soil", "Save Test File.txt")));
    }

    @Test
    void testBHLoad() throws IOException {
        BoreholeLog testLoadLog = BoreholeLog.getInstance();
        testLoadLog.load("Load Test File.txt");
        assertEquals("123", testLoadLog.getSample(0).getName());
        assertEquals("blue", testLoadLog.getSample(0).getColour());
        assertEquals("gravel", testLoadLog.getSample(0).getType());
        assertTrue(testLoadLog.getSample(0).isOdourous());

        assertEquals(1, testLoadLog.logSize());
    }

    @Test
    void testLoadAddSave() throws IOException {
        BoreholeLog testLoadLog = BoreholeLog.getInstance();
        testLoadLog.load("Load Test File.txt");
        testLoadLog.addSample(testSoilSample1);
        assertEquals("101", testLoadLog.getSample(1).getName());
        assertEquals("brown", testLoadLog.getSample(1).getColour());
        assertTrue(testLoadLog.getSample(0).isOdourous());
        testLoadLog.save("Load Add Save.txt");
        assertEquals(Files.readAllLines(Paths.get("data", "soil", "Load Add Save Answer.txt")),
                Files.readAllLines(Paths.get("data", "soil", "Load Add Save.txt")));
    }


    @Test
    void testReturnContaminatedSamplesEmptyList() {
        assertEquals(emptyArray, bh.returnContaminatedSamples());
    }

    @Test
    void testReturnContaminatedSamples() {
        bh.addSample(testSoilSample2);
        bh.addSample(testSoilSample1);
        testArray.add(testSoilSample2);
        assertEquals(testArray, bh.returnContaminatedSamples());
    }


    @Test
    void testIncompatibleFileSaveName() {
        bh.addSample(testSoilSample3);
        bh.addSample(testSoilSample1);
        try {
            bh.save("///");
            fail("Exception was not thrown");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            //expected
        }
    }

    @Test
    void testAllowableFileSaveName() {
        bh.addSample(testSoilSample3);
        bh.addSample(testSoilSample1);
        try {
            bh.save("Testlog3.txt");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testLoadFileDoesntExist() {
        BoreholeLog testLoadLog = BoreholeLog.getInstance();
        try {
            testLoadLog.load("Imaginary File.txt");
            fail("FileNotFoundException should have been thrown");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            //expected
        }

    }

    @Test
    void testLoadFileExists() {
        BoreholeLog testLoadLog = BoreholeLog.getInstance();
        try {
            testLoadLog.load("Load Test File.txt");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            fail("Exception should not have been thrown");
        }
    }

}









