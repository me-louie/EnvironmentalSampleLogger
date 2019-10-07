package ui;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogTest {

    Log testBoreholeLog;
    Log testWaterLog;
    Sample soilTestSample1;
    Sample waterTestSample1;

    @BeforeEach
    void setup() {
       testBoreholeLog = new BoreholeLog();
       testWaterLog = new WaterLog();
       soilTestSample1 = new SoilSample("test1", "blue", "sand", false);
       waterTestSample1 = new WaterSample("101n", "groundwater", true,
               "123", "234", "345");

    }

    @Test
    void testLogSize() {
        Assertions.assertEquals(0, testBoreholeLog.logSize());
        Assertions.assertEquals(0, testWaterLog.logSize());
    }



}
