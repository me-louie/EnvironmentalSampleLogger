package tests;

import model.consultants.Employee;
import model.consultants.ProjectManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectManagerTest{

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
