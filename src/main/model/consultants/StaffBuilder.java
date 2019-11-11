package model.consultants;

public class StaffBuilder {
    private Employee boss;

    public StaffBuilder() {
        ProjectManager pm1 = new ProjectManager("Alex");
        ProjectManager pm2 = new ProjectManager("Bob");
        ProjectManager pm3 = new ProjectManager("Carrie");
        FieldTechnician ft1 = new FieldTechnician("Dan");
        FieldTechnician ft2 = new FieldTechnician("Eva");
        FieldTechnician ft3 = new FieldTechnician("Frank");

        pm1.addStaff(pm2);
        pm1.addStaff(pm3);
        pm2.addStaff(ft1);
        pm3.addStaff(ft2);
        pm3.addStaff(ft3);

        boss = pm1;
    }

    public Employee getBoss() {
        return boss;
    }
}
