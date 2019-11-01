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
    private BoreholeLog bh;
//    private WaterSample waterTestSample1 = new WaterSample("101n", "groundwater", true,
//            "123", "234", "345");



    @BeforeEach
    void setup() {
        bh = new BoreholeLog();
        testBoreholeLog = new BoreholeLog();
        testWaterLog = new WaterLog();
        soilTestSample1 = new SoilSample("test1", "blue", "sand", false, bh);
        soilTestSample2 = new SoilSample("test2", "grey", "silt", true, bh);
//        waterTestSample1 = new WaterSample("101n", "groundwater", true,
//                "123", "234", "345");


        testBoreholeLog.addSample(soilTestSample1);
        testBoreholeLog.addSample(soilTestSample2);


    }

    @Test
    void testSampleIDIsUnique() {

        assertTrue(testBoreholeLog.isSoilSampleIDUnique("test3"));
        assertTrue(testBoreholeLog.isSoilSampleIDUnique("test4"));
    }

    @Test
    void testSampleIDIsNotUnique() {

        assertFalse(testBoreholeLog.isSoilSampleIDUnique("test1"));
        assertFalse(testBoreholeLog.isSoilSampleIDUnique("test2"));
    }

    @Test
    void testRemoveSampleFromLog() {
        testBoreholeLog.removeSampleFromBoreholeLog(testBoreholeLog, "test1");

        assertEquals(1, testBoreholeLog.logSize());
        assertTrue(testBoreholeLog.contains(soilTestSample2));
        assertFalse(testBoreholeLog.contains(soilTestSample1));
    }

    @Test
    void testSampleToRemoveFromLogDoesNotExist() {
        testBoreholeLog.removeSampleFromBoreholeLog(testBoreholeLog, "test3");
        assertEquals(2, testBoreholeLog.logSize());
        assertTrue(testBoreholeLog.contains(soilTestSample1));
        assertTrue(testBoreholeLog.contains(soilTestSample2));
    }


}
