package model;

public class ProjectInfo {

    private int projectNumber;
    private String projectManager;
    private String companyName = "210 Consulting";
    private String siteAddress;


    //MODIFIES: this
    //EFFECTS: creates new project info object
    public ProjectInfo() {

    }

    //MODIFIES: this
    //EFFECTS: constructs new project info object with project number, project manager, and site address
    public ProjectInfo(int projectNumber, String projectManager, String siteAddress) {
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

}
