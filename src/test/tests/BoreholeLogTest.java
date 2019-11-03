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


    private BoreholeLog emptyTestLog;
    private BoreholeLog testLog3;
    private BoreholeLog testLog4;
    private BoreholeLog bh;


    private SoilSample testSoilSample1 = new SoilSample("101", "brown", "gravel", false, bh);
    private SoilSample testSoilSample2 = new SoilSample("102", "grey", "silt", true, bh);
    private SoilSample testSoilSample3 = new SoilSample("103", "blue", "sand", false, bh);

    private ArrayList emptyArray = new ArrayList();
    private ArrayList testArray = new ArrayList();


    @BeforeEach
    void setup() {


        emptyTestLog = new BoreholeLog();

        testLog3 = new BoreholeLog();
        testLog3.addSample(testSoilSample3);
        testLog3.addSample(testSoilSample1);

        testLog4 = new BoreholeLog();
        testLog4.addSample(testSoilSample2);
        testLog4.addSample(testSoilSample1);

//        bh = new BoreholeLog();
    }


    @Test
    void testBHSave() throws IOException {
        testLog3.save("Save Test File.txt");
        Files.readAllLines(Paths.get("data", "soil", "Save Test File.txt"));
        assertEquals(Files.readAllLines(Paths.get("data", "soil", "Save Test Answers.txt")),
                Files.readAllLines(Paths.get("data", "soil", "Save Test File.txt")));
    }

    @Test
    void testBHLoad() throws IOException {
        BoreholeLog testLoadLog = new BoreholeLog();
        testLoadLog.load("Load Test File.txt");
        assertEquals("123", testLoadLog.getSample(0).getName());
        assertEquals("blue", testLoadLog.getSample(0).getColour());
        assertEquals("gravel", testLoadLog.getSample(0).getType());
        assertTrue(testLoadLog.getSample(0).isOdourous());

        assertEquals(1, testLoadLog.logSize());
    }

    @Test
    void testLoadAddSave() throws IOException {
        BoreholeLog testLoadLog = new BoreholeLog();
        testLoadLog.load("Load Test File.txt");
        testLoadLog.addSample(testSoilSample1);
        assertEquals("101", testLoadLog.getSample(1).getName());
        assertEquals("brown", testLoadLog.getSample(1).getColour());
        assertTrue(testLoadLog.getSample(0).isOdourous());
        testLoadLog.save("Load Add Save.txt");
        assertEquals(Files.readAllLines(Paths.get("data", "soil", "Load Add Save Answer.txt")),
                Files.readAllLines(Paths.get("data", "soil", "Load Add Save.txt")));
    }

//    @Test
//    void testAddSample() {
//        testLog.add(testSoilSample1);
//        Assertions.assertEquals("101 brown gravel false", testLog.get(0).toString());
//    }

//    @Test
//    void testGetSample() {
//        assertEquals(testSoilSample2, testLog4.getSample(0));
//    }

//    @Test
//    void testRemoveSample() {
//        testLog4.removeSample(0);
//        assertEquals(1, testLog4.logSize());
//        assertFalse(testLog4.contains(testSoilSample2));
//        assertTrue(testLog4.contains(testSoilSample1));
//    }


    @Test
    void testReturnContaminatedSamplesEmptyList() {
        assertEquals(emptyArray, emptyTestLog.returnContaminatedSamples());
    }

    @Test
    void testReturnContaminatedSamples() {
        testArray.add(testSoilSample2);
        assertEquals(testArray, testLog4.returnContaminatedSamples());
    }
//
//    @Test
//    void testPrintLog() {
//        assertTrue(testLog4.printLog());
//    }

//    @Test
//    void testCheckUnique() {
//        assertFalse(testLog3.isSoilSampleIDUnique("103"));
//        assertFalse(testLog3.isSoilSampleIDUnique("101"));
//        assertTrue(testLog3.isSoilSampleIDUnique("102"));
//
//
//    }

    @Test
    void testIncompatibleFileSaveName() {
        try {
            testLog3.save("///");
            fail("Exception was not thrown");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            //expected
        }
    }

    @Test
    void testAllowableFileSaveName() {
        try {
            testLog3.save("Testlog3.txt");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testLoadFileDoesntExist() {
        BoreholeLog testLoadLog = new BoreholeLog();
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
        BoreholeLog testLoadLog = new BoreholeLog();
        try {
            testLoadLog.load("Load Test File.txt");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            fail("Exception should not have been thrown");
        }
    }

}









