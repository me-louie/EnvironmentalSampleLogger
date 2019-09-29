package ui;

import model.BoreholeLog;
import model.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class BoreholeLogTest {

    private BoreholeLog testLog;
    private BoreholeLog otherTestLog;
//    private BoreholeLog thirdTestLog;

    private Sample testSample1 = new Sample("101", "brown", "gravel", false);
    private Sample testSample2 = new Sample("102", "grey", "silt", true);
    private Sample testSample3 = new Sample("103", "blue", "sand", false);


    @BeforeEach
    void setup() {
        testLog = new BoreholeLog();
        otherTestLog = new BoreholeLog();
//        thirdTestLog = new BoreholeLog();

        otherTestLog.addSample(testSample1);
        otherTestLog.addSample(testSample2);
        otherTestLog.addSample(testSample3);
//        thirdTestLog.addSample(testSample1);

    }

    @Test
    void testGetSize() {
        assertEquals(0, testLog.size());
        assertEquals(3, otherTestLog.size());
    }

//    @Test
//    void addSample() {
//        otherTestLog.addSample(testSample1);
//        assertEquals(thirdTestLog, otherTestLog);
//    }

//    @Test
//    void returnContaminatedSamplesEmptyList() {
//        assertEquals(otherTestLog, otherTestLog.returnContaminatedSamples());
//    }

    //for loop and check each item because it also checks the order
    //object1.isEqual(object2)

    //TA said complete this test once we cover Override in lecture.. hashes are different
}










