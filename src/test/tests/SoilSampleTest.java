package tests;

import exceptions.InvalidSoilColourException;
import exceptions.InvalidSoilTypeException;
import exceptions.YesOrNoInputException;
import model.BoreholeLog;
import model.SoilSample;
import model.WaterSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoilSampleTest {
    private SoilSample testExceptionSample;
    private BoreholeLog bh;

    private SoilSample s0;
    private SoilSample s1;
    private SoilSample s2;
    private SoilSample s3;



    @BeforeEach
    void setup() {
        s0 = new SoilSample();

        s1 = new SoilSample("s1", "blue", "sand", false, bh);
        s2 = new SoilSample("s2", "grey", "silt", true, bh);
        s3 = new SoilSample("s3", "brown", "gravel", true, bh);

        testExceptionSample = new SoilSample();
        BoreholeLog bh = new BoreholeLog();
    }

    @Test
    void testConstructor() {
        assertNull(s0.getName());
        assertNull(s0.getColour());
        assertNull(s0.getType());
        assertFalse(s0.isOdourous());
    }

    @Test
    void testOtherConstructor() {
//        Sample otherTestSample = new Sample("101", "grey", "sand", false);
        assertEquals("s1", s1.getName());
        assertEquals("blue", s1.getColour());
        assertEquals("sand", s1.getType());
        assertFalse(s1.isOdourous());
        assertEquals(bh, s1.getBoreholeLog());
    }

    @Test
    void testSetName() {
        s0.setName("101");
        assertEquals("101", s0.getName());
    }

    @Test
    void testSetTypeColour() {
        s0.setColour("blue");
        assertEquals("blue", s0.getColour());
    }

    @Test
    void testSetType() {
        s0.setType("sand");
        assertEquals("sand", s0.getType());
    }

    @Test
    void testIsOdourous() {
        s0.setOdour(true);
        assertTrue(s0.isOdourous());
    }


    @Test
    void testToString() {
        assertEquals("s1 blue sand false", s1.toString());
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
        List<String> myList = new ArrayList<>();

        assertEquals((s1.hashCode()), s2.hashCode());
        assertEquals((s1.hashCode()), s4.hashCode());
        assertNotEquals((s1.hashCode()), s3.hashCode());
        assertEquals(s1, s2);
        assertEquals(s1, s4);
        assertNotEquals(s1, s3);
        assertNotEquals(s1, myList);
    }
}
