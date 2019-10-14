package tests;

import exceptions.InvalidWaterTypeException;
import model.SoilSample;
import model.WaterSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterSampleTest {

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
    void testSetTurbidity() {
        testWaterSample.setTurbidity("123");
        assertEquals("123", testWaterSample.getTurbidity());
    }

    @Test
    void testSetTemperature() {
        testWaterSample.setTemperature("30");
        assertEquals("30", testWaterSample.getTemperature());
    }

    @Test
    void testSetConductivity() {
        testWaterSample.setConductivity("1244");
        assertEquals("1244", testWaterSample.getConductivity());
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


    @Test
    void testAllowableWaterSampleType() {
        WaterSample newSample = new WaterSample();
        try {
            newSample.setWaterSampleType(newSample, "groundwater");
            assertEquals("groundwater", newSample.getType());
            newSample.setWaterSampleType(newSample, "surface water");
            assertEquals("surface water", newSample.getType());
        } catch (InvalidWaterTypeException e) {
            e.printStackTrace();
            fail("InvalidWaterTypeException should not have been thrown.");
        }
    }

    @Test
    void testInvalidWaterSampleType() {
        WaterSample newSample = new WaterSample();
        try {
            newSample.setWaterSampleType(newSample, "tap water");
            fail("InvalidWaterTypeException should have been thrown");
        } catch (InvalidWaterTypeException e) {
//            e.printStackTrace();
            //expected
        }
    }
}
