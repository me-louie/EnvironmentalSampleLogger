package ui;

import model.WaterLog;
import model.WaterSample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WaterLogTest {
    private WaterLog testWaterLog;
    private WaterLog otherTestWaterLog;

    private WaterSample testWaterSample1;
    private WaterSample testWaterSample2;


    @BeforeEach
    void setup() {
        testWaterLog = new WaterLog();
        otherTestWaterLog = new WaterLog();

        testWaterSample1 = new WaterSample("101n", "groundwater", true,
                "111", "222", "333");
        testWaterSample2 = new WaterSample("999", "surface water",
                false, "888", "777", "666");

        otherTestWaterLog.addSample(testWaterSample1);
    }

    @Test
    void testAddSample() {
        testWaterLog.addSample(testWaterSample1);
        Assertions.assertEquals("101n groundwater true 111 222 333", testWaterLog.getSample(0).toString());
    }

    @Test
    void testGetSample() {
        assertEquals(testWaterSample1, testWaterLog.getSample(0));
    }

    @Test
    void testRemoveSample() {
        testWaterLog.addSample(testWaterSample1);
        testWaterLog.addSample(testWaterSample2);
        testWaterLog.removeSample(1);
        assertEquals(1, testWaterLog.logSize());
        assertFalse(testWaterLog.contains(testWaterSample2));
        assertTrue(testWaterLog.contains(testWaterSample1));
    }

    @Test
    void testPrintLog() {
        assertTrue(otherTestWaterLog.printLog());
    }
}
