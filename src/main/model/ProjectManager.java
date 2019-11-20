package model;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends Employee {
    private List<Employee> staff;

    //MODIFIES: this
    //EFFECTS: creates new project manager with a name and adds it to the list of employees
    public ProjectManager(String name) {
        super(name);
        this.staff = new ArrayList<>();
    }

    //EFFECTS: adds employee to the list of employees if the employee is not already in the list
    public void addStaff(Employee employee) {
        if (!staff.contains(employee)) {
            staff.add(employee);
        }
    }

    //EFFECTS: returns size of the employee list
    public int getStaffSize(Employee employee) {
        return staff.size();
    }


    @Override
    //EFFECTS: prints name of the project manager and all employees under that manager
    public String print(int indent) {
        String tab = "";
        for (int i = 0; i < indent; i++) {
            tab = ">>>" + tab;
        }
        System.out.println(tab + "Project Manager: " + name);
        for (Employee employee : staff) {
            employee.print(indent + 1);
        }
        System.out.println();

        return this.name;
    }
}
