package model;

import static javax.xml.transform.OutputKeys.INDENT;

public abstract class Employee {
    protected String name;
//    protected String INDENT = "     ";

    public Employee(String name) {
        this.name = name;
    }

    public void print() {
        print(0);
    }

    public void print(int indent) {
//        printIndent();

    }

    public void printIndent(String indent) {
        System.out.println(INDENT);
    }
}
