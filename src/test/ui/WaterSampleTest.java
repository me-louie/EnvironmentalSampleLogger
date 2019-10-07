package ui;

import model.SoilSample;
import model.WaterSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WaterSampleTest {

    private WaterSample testWaterSample;
    private WaterSample otherTestWaterSample;

    @BeforeEach
    void setup() {
        testWaterSample = new WaterSample();
        otherTestWaterSample = new WaterSample("101n", "groundwater", true,
                "111", "222", "333");


    }

    @Test
    void testConstructor() {
        assertNull(testWaterSample.getName());
        assertNull(testWaterSample.getType());
        assertFalse(testWaterSample.isOdourous());
        assertNull(testWaterSample.getConductivity());
        assertNull(testWaterSample.getTemperature());
        assertNull(testWaterSample.getTurbidity());
    }

    @Test
    void testOtherConstructor() {
        assertEquals("101n", otherTestWaterSample.getName());
        assertEquals("groundwater", otherTestWaterSample.getType());
        assertTrue(otherTestWaterSample.isOdourous());
        assertEquals("111", otherTestWaterSample.getConductivity());
        assertEquals("222", otherTestWaterSample.getTemperature());
        assertEquals("333", otherTestWaterSample.getTurbidity());
    }

    @Test
    void testSetName() {
        testWaterSample.setName("999");
        assertEquals("999", testWaterSample.getName());
    }


    @Test
    void testSetType() {
        testWaterSample.setType("groundwater");
        assertEquals("groundwater", testWaterSample.getType());
    }

    @Test
    void testIsOdourous() {
        testWaterSample.setOdour(true);
        assertTrue(testWaterSample.isOdourous());
    }


    @Test
    void testToString() {
        assertEquals("101n groundwater true 111 222 333", otherTestWaterSample.toString());
    }
}
