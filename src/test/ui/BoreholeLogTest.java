package ui;

import model.BoreholeLog;
import model.Sample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoreholeLogTest {

    //TODO: Test return contaminated sample empty: no contaminated samples to remove
    //TODO: outcome: returns empty list

    //TODO: test return contaminated samples with entries: some contaminated samples
    //TODO: outcome: returns only contaminated samples
    private BoreholeLog log;
    private ArrayList<Sample> testLog;
    private List<Sample> log2 = new ArrayList<>();
    private Sample testSample1 = new Sample("101", "brown", "gravel", false);
    private Sample testSample2 = new Sample("102", "grey", "silt", true);
    private Sample testSample3 = new Sample("103", "blue", "sand", true);


    @BeforeEach
    private void setup() {
        testLog = new ArrayList<>();
        log2.add(testSample1);
        log2.add(testSample2);
        log2.add(testSample3);

    }

//    @Test
//    public void returnContaminatedSamplesEmptyList() {
//        log.returnContaminatedSamples();
//        assertEquals(0, log.returnContaminatedSamples());
//    }

    @Test
    void testSize() {
        assertEquals(0,testLog.size());
        assertEquals(3, log2.size());
    }

//    @Test
//    public void returnContaminatedSamplesTest() {
//         boreholeLog.returnContaminatedSamples();


    }
//
//
//    @Test
//    public void returnContaminatedSamplesEmptyLogTest() {
//        assertTrue(testLog.contains(0));
//        assertEquals(0, testLog.returnContaminatedSamples());
//    }
//
//    @Test
//    public void returnContaminatedSamplesNonEmptyTest() {
//        Sample testSample1 = new Sample("101", "brown", "gravel", false);
//        Sample testSample2 = new Sample("102", "grey", "silt", true);
//        Sample testSample3 = new Sample("103", "blue", "sand", true);
//        testLog.add(testSample1);
//        testLog.add(testSample2);
//        testLog.add(testSample3);
////        testLog.returnContaminatedSamples();
//        testLog.returnContaminatedSamples();
//        ArrayList<Sample> logg = new ArrayList<>();
//        logg = testLog.returnContaminatedSamples();
//        assertEquals(testLog.size(), 2);
//}







