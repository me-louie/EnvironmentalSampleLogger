package tests;

import model.consultants.Employee;
import model.consultants.FieldTechnician;
import model.consultants.ProjectManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private Employee pm1 = new ProjectManager("pm1");
    private Employee ft1 = new FieldTechnician("ft1");

    @Test
    void testGetName() {
        assertEquals("pm1", pm1.getName());
    }

    @Test
    void testOverrideHashcodeEquals() {
        Employee pm2 = new ProjectManager("pm2");
        Employee pm3 = new ProjectManager("pm2");
        FieldTechnician ft2 = new FieldTechnician("pm2");
        assertEquals(pm2.hashCode(), pm2.hashCode());
        assertEquals(pm2, pm3);
        assertNotEquals(ft2, pm2);
    }
}
