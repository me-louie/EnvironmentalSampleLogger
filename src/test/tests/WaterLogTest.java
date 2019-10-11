package tests;

import model.WaterLog;
import model.WaterSample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class WaterLogTest extends LogTest {
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
        testWaterLog.addSample(testWaterSample1);
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

    @Test
    void testWLSave() throws IOException {
        otherTestWaterLog.addSample(testWaterSample2);

        otherTestWaterLog.save("Save Test Waterlog.txt");
        assertEquals(Files.readAllLines(Paths.get("data", "Save Test Waterlog Answers.txt")),
                Files.readAllLines(Paths.get("data", "Save Test Waterlog.txt")));
    }

    @Test
    void testWLLoad() throws IOException {
        WaterLog testLoadLog = new WaterLog();
        testLoadLog.load("Load Test Waterlog.txt");
        assertEquals("105n", testLoadLog.getSample(0).getName());
        assertEquals("groundwater", testLoadLog.getSample(0).getType());
        assertTrue(testLoadLog.getSample(0).isOdourous());
        assertEquals("123", testLoadLog.getSample(0).getConductivity());
        assertEquals("23", testLoadLog.getSample(0).getTemperature());
        assertEquals("355", testLoadLog.getSample(0).getTurbidity());

        assertEquals(1, testLoadLog.logSize());
    }
}
