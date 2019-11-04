package tests;

import model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectTest {
    private Project project;

    @BeforeEach
    void setup(){
        project = new Project(12345, "Mikayla", "604 Street");
    }

    @Test
    void testConstructor(){
        assertEquals(12345, project.getProjectNumber());
        assertEquals("Mikayla", project.getProjectManager());
        assertEquals("604 Street", project.getSiteAddress());
        assertEquals("210 Consulting", project.getCompanyName());
    }

    @Test
    void testSetProjectNumber(){
        project.setProjectNumber(54321);
        assertEquals(54321, project.getProjectNumber());
    }

    @Test
    void testSetProjectManager(){
        project.setProjectManager("Max");
        assertEquals("Max", project.getProjectManager());
    }

    @Test
    void testSetSiteAddress(){
        project.setSiteAddress("123 Place");
        assertEquals("123 Place", project.getSiteAddress());
    }

    @Test
    void testSetCompanyName(){
        project.setCompanyName("My Company");
        assertEquals("My Company", project.getCompanyName());
    }

}
