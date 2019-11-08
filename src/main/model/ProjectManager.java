package model;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends Employee {
    protected List<Employee> staff;

    public ProjectManager(String name) {
        super(name);
        this.staff = new ArrayList<>();
    }

    public void addStaff(Employee employee) {
        if (!staff.contains(employee)) {
            staff.add(employee);
        }
    }

    public void print(int indent) {
        System.out.println("Project Manager: " + name);
    }
}
