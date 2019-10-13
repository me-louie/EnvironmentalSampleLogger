package tests;

import model.SoilSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoilSampleTest {
    private SoilSample testSoilSample;
    private SoilSample otherTestSoilSample;
    private SoilSample testSoilSample1;



    @BeforeEach
    void setup() {
        testSoilSample = new SoilSample();
        otherTestSoilSample = new SoilSample("101", "grey", "sand", false);
        testSoilSample1 = new SoilSample("101", "brown", "gravel", false);

    }

    @Test
    void testConstructor() {
        assertNull(testSoilSample.getName());
        assertNull(testSoilSample.getColour());
        assertNull(testSoilSample.getType());
        assertFalse(testSoilSample.isOdourous());
    }

    @Test
    void testOtherConstructor() {
//        Sample otherTestSample = new Sample("101", "grey", "sand", false);
        assertEquals("101", otherTestSoilSample.getName());
        assertEquals("grey", otherTestSoilSample.getColour());
        assertEquals("sand", otherTestSoilSample.getType());
        assertFalse(otherTestSoilSample.isOdourous());
    }

    @Test
    void testSetName() {
        testSoilSample.setName("101");
        assertEquals("101", testSoilSample.getName());
    }

    @Test
    void testSetTypeColour() {
        testSoilSample.setColour("blue");
        assertEquals("blue", testSoilSample.getColour());
    }

    @Test
    void testSetType() {
        testSoilSample.setType("sand");
        assertEquals("sand", testSoilSample.getType());
    }

    @Test
    void testIsOdourous() {
        testSoilSample.setOdour(true);
        assertTrue(testSoilSample.isOdourous());
    }



    @Test
    void testToString() {
        assertEquals("101 grey sand false", otherTestSoilSample.toString());
    }

}
