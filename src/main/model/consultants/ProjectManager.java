package model.consultants;

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

    public int getStaffSize(Employee employee) {
        return staff.size();
    }


    @Override
    public void print(int indent) {
        String tab = "";
        for (int i = 0; i < indent; i++) {
            tab = ">>>" + tab;
        }
        System.out.println(tab + "Project Manager: " + name);
        for (Employee employee : staff) {
            employee.print(indent + 1);
        }
    }
}
