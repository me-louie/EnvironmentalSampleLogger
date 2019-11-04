package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Project {

    //    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private int projectNumber;
    private String projectManager;
    private String companyName = "210 Consulting";
    private String siteAddress;


    public Project() {

    }

    public Project(int projectNumber, String projectManager, String siteAddress) {
//        this.date = date;
        this.projectNumber = projectNumber;
        this.projectManager = projectManager;
        this.companyName = companyName;
        this.siteAddress = siteAddress;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

//    public SimpleDateFormat getDate() {
//        return date;
//    }
//
//    public void setDate(SimpleDateFormat date) {
//        this.date = date;
//    }
}
