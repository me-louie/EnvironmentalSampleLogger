package ui;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LogTest {

    private Log testBoreholeLog;
    private Log testWaterLog;
    private Sample soilTestSample1;
    private Sample waterTestSample1;

    protected String dirName = "C:\\Users\\Pikachu\\Documents\\!Courses\\Fall 2019\\CPSC 210\\project_u7v2b\\data";


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
