package model;

public class FieldTechnician extends Employee {
    public FieldTechnician(String name) {
        super(name);
    }

    @Override
    public void print(int indent) {
        String tab = ">>>";
        for (int i = 0; i < indent; i++) {
            tab = ">>>" + tab;
        }
        System.out.println(tab + "Field Technician: " + name);
    }
}
