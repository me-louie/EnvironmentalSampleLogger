package tests;

import model.Employee;
import model.ProjectManager;
import model.StaffBuilder;
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
