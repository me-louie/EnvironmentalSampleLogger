package model;

public class FieldTechnician extends Employee {
    public FieldTechnician(String name) {
        super(name);
    }

    public void print(int indent) {
        System.out.println("Field Technician: " + name);
    }
}
