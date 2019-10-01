package ui;

import model.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {
    private Sample testSample;
    private Sample otherTestSample;
    private Sample testSample1;



    @BeforeEach
    void setup() {
        testSample = new Sample();
        otherTestSample = new Sample("101", "grey", "sand", false);
        testSample1 = new Sample("101", "brown", "gravel", false);

    }

    @Test
    void testConstructor() {
        assertNull(testSample.getName());
        assertNull(testSample.getColour());
        assertNull(testSample.getType());
        assertFalse(testSample.isOdourous());
    }

    @Test
    void testOtherConstructor() {
//        Sample otherTestSample = new Sample("101", "grey", "sand", false);
        assertEquals("101", otherTestSample.getName());
        assertEquals("grey", otherTestSample.getColour());
        assertEquals("sand", otherTestSample.getType());
        assertFalse(otherTestSample.isOdourous());
    }

    @Test
    void testSetName() {
        testSample.setName("101");
        assertEquals("101", testSample.getName());
    }

    @Test
    void testSetTypeColour() {
        testSample.setColour("blue");
        assertEquals("blue", testSample.getColour());
    }

    @Test
    void testSetType() {
        testSample.setType("sand");
        assertEquals("sand", testSample.getType());
    }

    @Test
    void testIsOdourous() {
        testSample.setOdour(true);
        assertTrue(testSample.isOdourous());
    }

//    @Test
//    void testLoadSingleSample() throws IOException {
//        testSample1.save();
//        assertEquals("101", Files.readAllLines(Paths.get("Sample.txt")));
//
//    }



    @Test
    void testToString() {
        assertEquals("101 grey sand false", otherTestSample.toString());
    }
}
