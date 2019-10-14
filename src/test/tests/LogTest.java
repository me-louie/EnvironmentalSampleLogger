package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class LogTest {

    private BoreholeLog testBoreholeLog;
    private WaterLog testWaterLog;
    private SoilSample soilTestSample1;
    private SoilSample soilTestSample2;
    private WaterSample waterTestSample1;



    @BeforeEach
    void setup() {
       testBoreholeLog = new BoreholeLog();
       testWaterLog = new WaterLog();
       soilTestSample1 = new SoilSample("test1", "blue", "sand", false);
       soilTestSample2 = new SoilSample("test2", "grey", "silt", true);
       waterTestSample1 = new WaterSample("101n", "groundwater", true,
               "123", "234", "345");


        testBoreholeLog.addSample(soilTestSample1);
        testBoreholeLog.addSample(soilTestSample2);


    }

    @Test
    void testRemoveSampleFromLog() {
        testBoreholeLog.removeSampleFromLog(testBoreholeLog, "test1");

        assertEquals(1,testBoreholeLog.logSize());
        assertTrue(testBoreholeLog.contains(soilTestSample2));
        assertFalse(testBoreholeLog.contains(soilTestSample1));
    }

    @Test
    void testSampleToRemoveFromLogDoesNotExist() {
        testBoreholeLog.removeSampleFromLog(testBoreholeLog, "test3");
        assertEquals(2, testBoreholeLog.logSize());
        assertTrue(testBoreholeLog.contains(soilTestSample1));
        assertTrue(testBoreholeLog.contains(soilTestSample2));
    }

//    @Test
//    void testLogSize() {
//        Assertions.assertEquals(0, testBoreholeLog.logSize());
//        Assertions.assertEquals(0, testWaterLog.logSize());
//    }





}
