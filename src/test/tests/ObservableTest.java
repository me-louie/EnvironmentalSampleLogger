//package tests;
//
//import model.BoreholeLog;
////import model.LogBuilder;
//import model.Observable;
//import model.SoilSample;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ObservableTest {
//    private Observable o;
////    private LogBuilder lb1;
////    private LogBuilder lb2;
//
//    @BeforeEach
//    void setUp() {
//        o = new Observable();
////        lb1 = new LogBuilder();
////        lb2 = new LogBuilder();
//    }
//
//    @Test
//    void testConstructor() {
//        assertEquals(0, o.getObserverSize());
//    }
//
//    @Test
//    void addOneObserver() {
//        o.addObserver(lb1);
//        assertEquals(1, o.getObserverSize());
//    }
//
//    @Test
//    void addSameObserverTwice(){
////        o.addObserver(lb1);
////        o.addObserver(lb1);
//        assertEquals(1, o.getObserverSize());
//    }
//
////    @Test
////    void testNotifyObservers(){
////        BoreholeLog bh = new BoreholeLog();
////        SoilSample s = new SoilSample("123", "grey", "sand", true, bh);
////        o.addObserver(lb1);
////        o.addObserver(lb2);
////        o.notifyObservers(s);
////
////    }
//}
