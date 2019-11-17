package tests;

import model.BoreholeLog;
import model.LogBuilder;
import model.SoilSample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogBuilderTest {
    private BoreholeLog bh;
    private SoilSample s1;
    private SoilSample s2;
    private LogBuilder lb1;

    @BeforeEach
    void setUp() {
        bh = BoreholeLog.getInstance();
        lb1 = new LogBuilder();
        bh.addObserver(lb1);
        s1 = new SoilSample("123", "blue", "sand", false, bh);
        s2 = new SoilSample("456", "grey", "silt", true, bh);

        bh.addSample(s1);
        bh.addSample(s2);
    }

//    @Test
//    void testUpdate() {
//        assertEquals("blue", lb1.update(s1));
//        assertEquals("grey", lb1.update(s2));
//    }

}
