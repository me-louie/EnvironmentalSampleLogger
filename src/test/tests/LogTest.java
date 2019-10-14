package tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


class LogTest {

    private BoreholeLog testBoreholeLog;
    private WaterLog testWaterLog;
    private SoilSample soilTestSample1;
    private SoilSample soilTestSample2;
    private WaterSample waterTestSample1 = new WaterSample("101n", "groundwater", true,
            "123", "234", "345");



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
    void testSampleIDIsUnique() {

        assertTrue(testBoreholeLog.isSampleIDUnique("test3"));
        assertTrue(testBoreholeLog.isSampleIDUnique("test4"));
    }

    @Test
    void testSampleIDIsNotUnique() {

        assertFalse(testBoreholeLog.isSampleIDUnique("test1"));
        assertFalse(testBoreholeLog.isSampleIDUnique("test2"));
    }

    @Test
    void testRemoveSampleFromLog() {
        testBoreholeLog.removeSampleFromLog(testBoreholeLog, "test1");

        assertEquals(1, testBoreholeLog.logSize());
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


}
