package model;

public class FieldTechnician extends Employee {

    //MODIFIES: this
    //EFFECTS: creates new field technician with a name
    public FieldTechnician(String name) {
        super(name);
    }

    @Override
    //EFFECTS: prints field technician's name
    public String print(int indent) {
        String tab = ">>>";
        for (int i = 0; i < indent; i++) {
            tab = ">>>" + tab;
        }
        System.out.println(tab + "Field Technician: " + name);

        return this.name;
    }
}
