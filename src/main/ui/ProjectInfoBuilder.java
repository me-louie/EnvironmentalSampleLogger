package ui;

import model.ProjectInfo;

import java.util.Scanner;

class ProjectInfoBuilder {
    private ProjectInfo projectInfo = new ProjectInfo();

    ProjectInfoBuilder() {

    }

    void createProject() {
        projectInfo.setProjectNumber(createProjectNumber());
//        projectInfo.setProjectManager(createProjectManager());
        projectInfo.setSiteAddress(createSiteAddress());
    }

    private String createSiteAddress() {
        System.out.println("Please enter the Site address");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private int createProjectNumber() {
        System.out.println("Please enter a project number.");
        Scanner input = new Scanner(System.in);
        String projectNum = input.nextLine();
        return Integer.parseInt(projectNum);
    }

    private String createProjectManager() {
        System.out.println("Please enter a project manager.");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }


}
