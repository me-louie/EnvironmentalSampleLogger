//package tests;
//
//import model.WaterLog;
//import model.WaterSample;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ui.exceptions.SampleDoesNotExistException;
//
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class WaterLogTest extends LogTest {
//
//    private WaterLog wl;
//    private WaterSample w1;
//    private WaterSample w2;
//    private WaterSample w3;
//
//
//    @BeforeEach
//    void setup() {
//        wl = new WaterLog();
//        w1 = new WaterSample(10, 20, 30, 7 );
//        w2 = new WaterSample(11, 22, 33, 8);
//        w3 = new WaterSample(150, 25, 556, 6);
//
//
//    }
//
//    @Test
//    void testConstructor(){
//        assertEquals(0, wl.logSize());
//    }
//
//    @Test
//    void testSetHashMap(){
//        wl.setHashMap("w1", w1);
//        wl.setHashMap("w2", w2);
//        wl.setHashMap("w3", w3);
//        assertEquals(3, wl.logSize());
//        assertTrue(wl.contains("w1"));
//        assertTrue(wl.contains("w2"));
//    }
//
//    @Test
//    void testGetSample(){
//        wl.setHashMap("w1", w1);
//        wl.setHashMap("w2", w2);
//
//        assertEquals(w1, wl.getSample("w1"));
//        assertEquals(w2, wl.getSample("w2"));
//    }
//
//    @Test
//    void testRemoveSampleNoException() {
//        wl.setHashMap("w1", w1);
//        wl.setHashMap("w2", w2);
//        assertEquals(2, wl.logSize());
//        try {
//            wl.removeSample("w1");
//            assertEquals(1, wl.logSize());
//            assertFalse(wl.contains("w1"));
//        } catch (SampleDoesNotExistException e) {
//            e.printStackTrace();
//            fail("Exception should not have been thrown");
//        }
//    }
//
//    @Test
//    void testRemoveSampleThrowException() {
//        wl.setHashMap("w1", w1);
//        wl.setHashMap("w2", w2);
//        assertEquals(2, wl.logSize());
//        try {
//            wl.removeSample("w3");
//            fail("Exception should not have been thrown");
//        } catch (SampleDoesNotExistException e) {
////            e.printStackTrace();
//            //expected
//        }
//    }
//
//    @Test
//    void testGetType(){
//        assertEquals("water log", wl.getType());
//    }
//
//    @Test
//    void testIsSampleIDUnique(){
//        wl.setHashMap("w1", w1);
//        wl.setHashMap("w2", w2);
//        assertFalse(wl.isSampleIDUnique("w1"));
//        assertTrue(wl.isSampleIDUnique("w3"));
//    }
//
//    @Test
//    void removeSampleFromLog(){
//        wl.setHashMap("w1", w1);
//        wl.setHashMap("w2", w2);
//        wl.removeSampleFromLog("w1");
//        assertEquals(1, wl.logSize());
//        assertFalse(wl.contains("w1"));
//    }
//
//
//
//    @Test
//    void testWLSave() throws IOException {
//        WaterLog testWL = new WaterLog();
//
//        testWL.setHashMap("wl1", w1);
//        testWL.setHashMap("wl2", w2);
//
//        testWL.save("Save Test Waterlog2.txt");
//        assertEquals(Files.readAllLines(Paths.get("data", "water", "WL Save Test.txt")),
//                Files.readAllLines(Paths.get("data", "water", "Save Test Waterlog2.txt")));
//    }
////
////    @Test
////    void testWLLoad() throws IOException {
////        WaterLog testLoadLog = new WaterLog();
////        testLoadLog.load("Load Test Waterlog.txt");
////        assertEquals("105n", testLoadLog.getSample(0).getName());
////        assertEquals("groundwater", testLoadLog.getSample(0).getType());
////        assertTrue(testLoadLog.getSample(0).isOdourous());
////        assertEquals("123", testLoadLog.getSample(0).getConductivity());
////        assertEquals("23", testLoadLog.getSample(0).getTemperature());
////        assertEquals("355", testLoadLog.getSample(0).getTurbidity());
////
////        assertEquals(1, testLoadLog.logSize());
////    }
//}
