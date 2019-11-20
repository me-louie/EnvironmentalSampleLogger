package model;


import java.util.Objects;

public abstract class Employee {
    protected String name;

    //MODIFIES: this
    //EFFECTS: creates new employee with a name
    Employee(String name) {
        this.name = name;
    }

    //EFFECTS: returns employee's name
    public String getName() {
        return name;
    }


    public abstract String print(int index);

    @Override
    //EFFECTS: returns true if two employees have the same name
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    //EFFECTS: returns employee's hashcode
    public int hashCode() {
        return Objects.hash(name);
    }
}
