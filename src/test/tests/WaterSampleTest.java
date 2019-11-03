package tests;

import exceptions.InvalidWaterTypeException;
import model.WaterLog;
import model.WaterSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterSampleTest {

    private WaterLog wl;
    private WaterSample w1;
    private WaterSample w2;
    private WaterSample w3;


    @BeforeEach
    void setup() {
        wl = new WaterLog();
        w1 = new WaterSample(10, 20, 30, 7);
        w2 = new WaterSample(11, 22, 33, 8);
        w3 = new WaterSample(150, 25, 556, 6);
    }

        @Test
        void testConstructor() {
            WaterSample w0 = new WaterSample(1, 2, 3, 4);
            assertEquals(1, w0.getConductivity());
            assertEquals(2, w0.getTemperature());
            assertEquals(3, w0.getTurbidity());
            assertEquals(4, w0.getPH());
        }

        @Test
        void testOtherConstructor () {
        WaterSample w0 = new WaterSample();
            assertEquals(0, w0.getConductivity());
            assertEquals(0, w0.getTemperature());
            assertEquals(0, w0.getTurbidity());
            assertEquals(0, w0.getPH());
        }

        @Test
        void testSetters () {
            WaterSample w0 = new WaterSample();
            w0.setConductivity(1500);
            assertEquals(1500, w0.getConductivity());
            w0.setTemperature(25);
            assertEquals(25, w0.getTemperature());
            w0.setTurbidity(567);
            assertEquals(567, w0.getTurbidity());
            w0.setPH(7);
            assertEquals(7, w0.getPH());

        }

        @Test
        void testToString() {
        assertEquals("10 20 30 7", w1.toString());
        }

        @Test
        void testSetWaterLog(){
        w1.setWaterLog(wl);
        assertEquals(wl, w1.getWaterLog());
        }








        @Test
        void testAllowableWaterSampleType () {
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
        void testInvalidWaterSampleType () {
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
