package tests;

import model.WaterLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaterLogTest2 {

    private HashMap<String, ArrayList<Integer>> testMap = new HashMap<>();
    private WaterLog testWaterLog = new WaterLog();
    private ArrayList<Integer> data = new ArrayList<>(Arrays.asList(10, 11, 12));

    @BeforeEach
    void setup() {
        testWaterLog.setHashMap("sample1", data);
    }

    @Test
    void testSetMap() {
        assertEquals(1, testWaterLog.logSize());
    }

    @Test
    void testGetValues() {
        assertEquals(data, testWaterLog.getData("sample1"));
    }

    @Test
    void testContainsValue() {
        assertTrue(testWaterLog.contains("sample1"));
        assertFalse(testWaterLog.contains("sample2"));
    }

    @Test
    void testPrintLog(){
        assertTrue(testWaterLog.printLog());
    }
}
