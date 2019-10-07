package ui;

import model.BoreholeLog;
import model.Log;
import model.WaterLog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {

    Log testBoreholeLog;
    Log testWaterLog;

    @BeforeEach
    void setup() {
       testBoreholeLog = new BoreholeLog();
       testWaterLog = new WaterLog();
    }

    @Test
    void testGetBHSize() {
        Assertions.assertEquals(0, testBoreholeLog.logSize());
        Assertions.assertEquals(0, testWaterLog.logSize());
    }


}
