package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LogTest {

    private BoreholeLog testBoreholeLog;
    private WaterLog testWaterLog;
    private Sample soilTestSample1;
    private Sample waterTestSample1;



    @BeforeEach
    void setup() {
       testBoreholeLog = new BoreholeLog();
       testWaterLog = new WaterLog();
       soilTestSample1 = new SoilSample("test1", "blue", "sand", false);
       waterTestSample1 = new WaterSample("101n", "groundwater", true,
               "123", "234", "345");


    }

//    @Test
//    void testLogSize() {
//        Assertions.assertEquals(0, testBoreholeLog.logSize());
//        Assertions.assertEquals(0, testWaterLog.logSize());
//    }





}
