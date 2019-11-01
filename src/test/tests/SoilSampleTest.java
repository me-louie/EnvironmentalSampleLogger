package tests;

import exceptions.InvalidSoilColourException;
import exceptions.InvalidSoilTypeException;
import exceptions.YesOrNoInputException;
import model.BoreholeLog;
import model.SoilSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoilSampleTest {
    private SoilSample testSoilSample;
    private SoilSample otherTestSoilSample;
    private SoilSample testSoilSample1;
    private SoilSample testExceptionSample;
    private BoreholeLog bh;



    @BeforeEach
    void setup() {
        testSoilSample = new SoilSample();
        otherTestSoilSample = new SoilSample("101", "grey", "sand", false, bh);
        testSoilSample1 = new SoilSample("101", "brown", "gravel", false, bh);
        testExceptionSample = new SoilSample();

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


    @Test
    void testAllowableSoilColour() {
        try {
            testExceptionSample.setSoilColour(testExceptionSample, "blue");
            assertEquals("blue", testExceptionSample.getColour());
            testExceptionSample.setSoilColour(testExceptionSample, "brown");
            assertEquals("brown", testExceptionSample.getColour());
            testExceptionSample.setSoilColour(testExceptionSample, "grey");
            assertEquals("grey", testExceptionSample.getColour());
            //expected
        } catch (InvalidSoilColourException e) {
            e.printStackTrace();
            fail("Exception should have not been thrown");
        }
    }

    @Test
    void testNotAllowedSoilColour() {

        try {
            testExceptionSample.setSoilColour(testExceptionSample,"purple");
            assertNull(testExceptionSample.getColour());
            fail("Invalid Soil Colour Exception thrown.");
        } catch (InvalidSoilColourException e) {
//            e.printStackTrace();
            //expected
        }
    }


    @Test
    void testAllowableSoilType() {
        try {
            testExceptionSample.setSoilType(testExceptionSample,"sand");
            assertEquals("sand", testExceptionSample.getType());
            testExceptionSample.setSoilType(testExceptionSample,"silt");
            assertEquals("silt", testExceptionSample.getType());
            testExceptionSample.setSoilType(testExceptionSample, "gravel");
            assertEquals("gravel", testExceptionSample.getType());
        } catch (InvalidSoilTypeException e) {
//            e.printStackTrace();
            fail("InvalidSoilTypeException should not have been thrown");
        }

    }

    @Test
    void testInvalidSoilType() {
        try {
            testExceptionSample.setSoilType(testExceptionSample,"stone");
            fail("InvalidSoilTypeException should have been thrown");
        } catch (InvalidSoilTypeException e) {
//            e.printStackTrace();
            //expected
        }
    }

    @Test
    void testYesOrNoInputRequired() {
        try {
            testExceptionSample.setIsSampleOdourous(testExceptionSample, "yes");
            assertTrue(testExceptionSample.isOdourous());
            testExceptionSample.setIsSampleOdourous(testExceptionSample, "no");
            assertFalse(testExceptionSample.isOdourous());
        } catch (YesOrNoInputException e) {
            e.printStackTrace();
            fail("YesOrNoException should have not been thrown");
        }

    }

    @Test
    void testNeitherYesNorNoInput() {
        try {
            testExceptionSample.setIsSampleOdourous(testExceptionSample, "maybe");
            fail("YesOrNoException should have been thrown");
        } catch (YesOrNoInputException e) {
//            e.printStackTrace();
            //expected
        }
    }

    @Test
    void testOverrideEqualsandHashCode() {
        SoilSample s1 = new SoilSample("1", "grey", "silt", true, bh);
        SoilSample s2 = new SoilSample("1", "grey", "silt", true, bh);
        SoilSample s3 = new SoilSample("2", "grey", "silt", true, bh);
        SoilSample s4 = s1;
        assertTrue((s1.hashCode()==s2.hashCode()));
        assertTrue((s1.hashCode()==s4.hashCode()));
        assertFalse((s1.hashCode()==s3.hashCode()));
        assertTrue(s1.equals(s2));
        assertTrue(s1.equals(s4));
        assertFalse(s1.equals(s3));
    }
}
