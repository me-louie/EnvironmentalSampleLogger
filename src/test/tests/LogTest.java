package tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.*;


class LogTest {


    private BoreholeLog bh;
    private SoilSample s1;
    private SoilSample s2;
    private SoilSample s3;

    private WaterLog wl;
    private WaterSample w1;
    private WaterSample w2;
    private WaterSample w3;



    @BeforeEach
    void setup() {
        bh = BoreholeLog.getInstance();
//        bh.clear();
        s1 = new SoilSample("s1", "blue", "sand", false, bh);
        s2 = new SoilSample("s2", "grey", "silt", true, bh);
        s3 = new SoilSample("s3", "brown", "gravel", true, bh);
//        bh.addSample(s1);
//        bh.addSample(s2);
//        bh.addSample(s3);


//        wl = new WaterLog();

    }

    @Test
    void testConstructor() {
        Log boreholeLog = BoreholeLog.getInstance();
        assertEquals(4, boreholeLog.logSize());
    }

    @Test
    void testGetSample() {
//        bh.clear();
//        bh.addSample(s1);
//        bh.addSample(s2);
//        bh.addSample(s3);
        assertEquals(s1, bh.getSample(2));
        assertEquals(s2, bh.getSample(0));
        assertNotEquals(s1, bh.getSample(1));
    }

    @Test
    void testRemoveSample(){
//        bh.addSample(s1);
//        bh.addSample(s2);
//        bh.addSample(s3);
        bh.removeSample(2);
        assertEquals(2, bh.logSize());
        assertFalse(bh.contains(s1));
    }

    @Test
    void testGetType() {
        bh.addSample(s1);
        bh.addSample(s2);
        bh.addSample(s3);
        assertEquals("borehole log", bh.getType());
    }

    @Test
    void testIsSampleIDUnique(){
//        bh.addSample(s1);
//        bh.addSample(s2);
//        bh.addSample(s3);
       assertFalse(bh.isSampleIDUnique("s1"));
       assertTrue(bh.isSampleIDUnique("s5"));
    }

    @Test
    void testRemoveSampleFromLog(){
        bh.addSample(s1);
        bh.addSample(s2);
        bh.addSample(s3);
        bh.removeSampleFromLog("s1");
        assertEquals(2, bh.logSize());
        assertFalse(bh.contains(s1));
    }

    @Test
    void testRemoveSampleFromLogTwice(){
        bh.addSample(s1);
        bh.addSample(s2);
        bh.addSample(s3);
        bh.removeSampleFromLog("s1");
        bh.removeSampleFromLog("s1");
        assertEquals(2, bh.logSize());
        assertFalse(bh.contains(s1));
    }

    @Test
    void testAddSoilSampleToLog(){
        bh.addSample(s1);
        bh.addSample(s2);
        bh.addSample(s3);
        bh.addSampleToLog("s4", "blue", "sand", false);
        assertEquals(4, bh.logSize());
        assertFalse(bh.isSampleIDUnique("s4"));
    }

    @Test
    void testAddSoilSampleToLogTwice(){
        bh.addSample(s1);
        bh.addSample(s2);
        bh.addSample(s3);
        bh.addSampleToLog("s4", "blue", "sand", false);
        bh.addSampleToLog("s4", "blue", "sand", false);
        assertEquals(4, bh.logSize());
        assertFalse(bh.isSampleIDUnique("s4"));
    }


}
