package model;


public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract void print(int index);



}
