package tests;

import model.ProjectManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerTest extends EmployeeTest{

    private ProjectManager testPM1;
    private ProjectManager testPM2;

    @BeforeEach
    void setUp(){
        testPM1 = new ProjectManager("pm1");
        testPM2 = new ProjectManager("pm2");

    }

    @Test
    void testConstructor(){
        assertEquals("pm1", testPM1.getName());
    }

    @Test
    void testAddEmployeeOnce(){
        testPM1.addStaff(testPM2);
        assertEquals(1, testPM1.getStaffSize(testPM1));
    }

    @Test
    void testAddEmployeeTwice(){
        testPM1.addStaff(testPM2);
        testPM1.addStaff(testPM2);
        assertEquals(1, testPM1.getStaffSize(testPM1));
    }

}
