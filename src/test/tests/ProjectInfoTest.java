package tests;

import model.ProjectInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectInfoTest {
    private ProjectInfo projectInfo;

    @BeforeEach
    void setup(){
        projectInfo = new ProjectInfo(12345, "Mikayla", "604 Street");
    }

    @Test
    void testConstructor(){
        assertEquals(12345, projectInfo.getProjectNumber());
        assertEquals("Mikayla", projectInfo.getProjectManager());
        assertEquals("604 Street", projectInfo.getSiteAddress());
        assertEquals("210 Consulting", projectInfo.getCompanyName());
    }

    @Test
    void testOtherConstructor(){
        ProjectInfo blankProject = new ProjectInfo();
        blankProject.setProjectNumber(123);
        assertEquals(123, blankProject.getProjectNumber());
    }

    @Test
    void testSetProjectNumber(){
        projectInfo.setProjectNumber(54321);
        assertEquals(54321, projectInfo.getProjectNumber());
    }

    @Test
    void testSetProjectManager(){
        projectInfo.setProjectManager("Max");
        assertEquals("Max", projectInfo.getProjectManager());
    }

    @Test
    void testSetSiteAddress(){
        projectInfo.setSiteAddress("123 Place");
        assertEquals("123 Place", projectInfo.getSiteAddress());
    }

    @Test
    void testSetCompanyName(){
        projectInfo.setCompanyName("My Company");
        assertEquals("My Company", projectInfo.getCompanyName());
    }

}
