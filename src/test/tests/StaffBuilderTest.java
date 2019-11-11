package tests;

import model.consultants.Employee;
import model.consultants.ProjectManager;
import model.consultants.StaffBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StaffBuilderTest {
    private Employee boss = new ProjectManager("Alex");

    @Test
    void testConstructor(){
        StaffBuilder staffBuilder = new StaffBuilder();
        assertEquals(boss, staffBuilder.getBoss());
    }
}
